package com.suraj.cabService.RouteMate.services.impl;

import com.suraj.cabService.RouteMate.dto.DriverDto;
import com.suraj.cabService.RouteMate.dto.SignupDto;
import com.suraj.cabService.RouteMate.dto.UserDto;
import com.suraj.cabService.RouteMate.entities.Driver;
import com.suraj.cabService.RouteMate.entities.User;
import com.suraj.cabService.RouteMate.entities.enums.Role;
import com.suraj.cabService.RouteMate.exceptions.ResourceNotFoundException;
import com.suraj.cabService.RouteMate.exceptions.RuntimeConflictException;
import com.suraj.cabService.RouteMate.repositories.UserRepository;
import com.suraj.cabService.RouteMate.services.AuthService;
import com.suraj.cabService.RouteMate.services.DriverService;
import com.suraj.cabService.RouteMate.services.RiderService;
import com.suraj.cabService.RouteMate.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.suraj.cabService.RouteMate.entities.enums.Role.DRIVER;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;


    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user!=null)
               throw new RuntimeConflictException("Can not signup, user already exist with gmail "+ signupDto.getEmail());

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

//        Create user related entities
        riderService.createNewRider(savedUser);

        // TODO wallet related service here
        walletService.createNewWallet(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId, String vehicleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id "+userId));

        if(user.getRoles().contains(DRIVER))
            throw new RuntimeConflictException("User with id "+userId+" is already a Driver");

        Driver createDriver = Driver.builder()
                .user(user)
                .rating(0.0)
                .vehicleId(vehicleId)
                .available(true)
                .build();
        user.getRoles().add(DRIVER);
        userRepository.save(user);
        Driver savedDriver = driverService.createNewDriver(createDriver);
        return modelMapper.map(savedDriver, DriverDto.class);
    }
}

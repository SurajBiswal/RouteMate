package com.suraj.cabService.RouteMate.services.impl;

import com.suraj.cabService.RouteMate.dto.DriverDto;
import com.suraj.cabService.RouteMate.dto.SignupDto;
import com.suraj.cabService.RouteMate.dto.UserDto;
import com.suraj.cabService.RouteMate.entities.User;
import com.suraj.cabService.RouteMate.entities.enums.Role;
import com.suraj.cabService.RouteMate.exceptions.RuntimeConflictException;
import com.suraj.cabService.RouteMate.repositories.UserRepository;
import com.suraj.cabService.RouteMate.services.AuthService;
import com.suraj.cabService.RouteMate.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;


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

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}

package com.suraj.cabService.RouteMate.services;

import com.suraj.cabService.RouteMate.dto.DriverDto;
import com.suraj.cabService.RouteMate.dto.SignupDto;
import com.suraj.cabService.RouteMate.dto.UserDto;

public interface AuthService {
    String login(String email, String password);
    UserDto signup(SignupDto signupDto);
    DriverDto onboardNewDriver(Long userId, String vehicleId);
}

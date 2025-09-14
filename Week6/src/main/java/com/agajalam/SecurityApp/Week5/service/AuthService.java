package com.agajalam.SecurityApp.Week5.service;

import com.agajalam.SecurityApp.Week5.DTO.LoginDTO;
import com.agajalam.SecurityApp.Week5.DTO.LoginResponseDTO;
import com.agajalam.SecurityApp.Week5.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    public LoginResponseDTO login(LoginDTO loginDTO){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword())
        );

        User user=(User) authentication.getPrincipal();
        String accessToken= jwtService.generateAccessToken(user);
        String refreshToken=jwtService.generateRefreshToken(user);

        return new LoginResponseDTO(user.getId(),accessToken,refreshToken);
    }

    public LoginResponseDTO refreshToken(String refreshToken) {
        Long userId=jwtService.getUserIdFromToken(refreshToken);
        User user=userService.getUserById(userId);

        String accessToken=jwtService.generateAccessToken(user);

        return new LoginResponseDTO(user.getId(),accessToken,refreshToken);
    }
}

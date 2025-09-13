package com.agajalam.Week5HomeWork.services;

import com.agajalam.Week5HomeWork.Dto.LoginDto;
import com.agajalam.Week5HomeWork.entities.SessionEntity;
import com.agajalam.Week5HomeWork.entities.User;
import com.agajalam.Week5HomeWork.repositories.SessionRepository;
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
    private final SessionRepository sessionRepository;

    public String login(LoginDto loginDto){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );

        User user= (User) authentication.getPrincipal();
        String token= jwtService.generateToken(user);

        //remove old session if exists
        sessionRepository.deleteByUserId(user.getId());

        //save new session
        SessionEntity session=SessionEntity.builder()
                .userId(user.getId())
                .token(token)
                .build();
        sessionRepository.save(session);
        return token;
    }
}

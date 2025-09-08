package com.agajalam.SecurityApp.Week5.controllers;

import com.agajalam.SecurityApp.Week5.DTO.LoginDTO;
import com.agajalam.SecurityApp.Week5.DTO.SignUpDTO;
import com.agajalam.SecurityApp.Week5.DTO.UserDTO;
import com.agajalam.SecurityApp.Week5.service.AuthService;
import com.agajalam.SecurityApp.Week5.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.PanelUI;

@RestController
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO>singUP(@RequestBody SignUpDTO signUpDTO){
        UserDTO userDTO=userService.signUp(signUpDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginDTO loginDTO, HttpServletRequest request, HttpServletResponse response){
        String token=authService.login(loginDTO);

        Cookie cookie=new Cookie("token",token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }
}

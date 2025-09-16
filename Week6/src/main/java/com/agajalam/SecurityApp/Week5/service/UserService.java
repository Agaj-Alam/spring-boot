package com.agajalam.SecurityApp.Week5.service;

import com.agajalam.SecurityApp.Week5.DTO.SignUpDTO;
import com.agajalam.SecurityApp.Week5.DTO.UserDTO;
import com.agajalam.SecurityApp.Week5.entities.User;
import com.agajalam.SecurityApp.Week5.exceptions.ResourceNotFoundException;
import com.agajalam.SecurityApp.Week5.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.support.BeanDefinitionOverrideException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()->new ResourceNotFoundException("user  with email "+username+"not found"));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->new BadCredentialsException("user  with Id "+userId+"not found"));
    }

    public User getUerByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }
    public UserDTO signUp(SignUpDTO signUpDTO) {
        Optional<User>user=userRepository.findByEmail(signUpDTO.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("user with email already exists"+signUpDTO.getEmail());
        }


        User toBeCreatedUser=modelMapper.map(signUpDTO, User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));


        User savedUser=userRepository.save(toBeCreatedUser);
        return modelMapper.map(savedUser,UserDTO.class);
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }
}

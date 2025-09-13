package com.agajalam.Week5HomeWork.services;

import com.agajalam.Week5HomeWork.Dto.SignUpDto;
import com.agajalam.Week5HomeWork.Dto.UserDto;
import com.agajalam.Week5HomeWork.entities.User;
import com.agajalam.Week5HomeWork.exceptions.ResourceNotFoundException;
import com.agajalam.Week5HomeWork.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
                .orElseThrow(()->new BadCredentialsException("User not found with email"+username));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user not found with id"+userId));
    }

    public UserDto signUp(SignUpDto signUpDto){
        Optional<User>user=userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()){
                throw new BadCredentialsException("user with email already exists"+signUpDto.getEmail());
        }

        User toBeCreatedUser=modelMapper.map(signUpDto,User.class);
        toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));

        User savedUser=userRepository.save(toBeCreatedUser);
        return  modelMapper.map(savedUser,UserDto.class);
    }
}

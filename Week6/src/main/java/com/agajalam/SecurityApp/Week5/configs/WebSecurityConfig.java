package com.agajalam.SecurityApp.Week5.configs;

import com.agajalam.SecurityApp.Week5.filters.JwtAuthFilter;
import com.agajalam.SecurityApp.Week5.handlers.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/posts","/error","/auth/**","/home.html").permitAll()
//                        .requestMatchers("/posts/**").authenticated();
                        .anyRequest().authenticated())
                .csrf(csrfConfig->csrfConfig.disable())
                .sessionManagement(sessionConfig->sessionConfig
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oauthConfig->oauthConfig
                        .failureUrl("/login?error=true")
                        .successHandler(oAuth2SuccessHandler));
//                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


//
//    @Bean
//    UserDetailsService myInMemoryDetailsService(){
//        UserDetails normaluser= User
//                .withUsername("agaj")
//                .password(passwordEncoder().encode("agaj123"))
//                .roles("USER")
//                .build();
//
//        UserDetails adminUser=User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(normaluser,adminUser);
//    }


}


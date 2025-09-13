package com.agajalam.Week5HomeWork.filters;

import com.agajalam.Week5HomeWork.entities.SessionEntity;
import com.agajalam.Week5HomeWork.entities.User;
import com.agajalam.Week5HomeWork.repositories.SessionRepository;
import com.agajalam.Week5HomeWork.services.JwtService;
import com.agajalam.Week5HomeWork.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserService userService;
    private final SessionRepository sessionRepository;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            final String requestTokenHolder=request.getHeader("Authorization");
            if(requestTokenHolder==null || !requestTokenHolder.startsWith("Bearer")){
                filterChain.doFilter(request,response);
                return;
            }

            String token=requestTokenHolder.split("Bearer ")[1];
            Long userId=jwtService.getUserIdFromToken(token);

            //check DB if this token is still valid   *this is for sessionEntity
            Optional<SessionEntity>sessionOpt=sessionRepository.findByUserId(userId);
            if(sessionOpt.isEmpty() || !sessionOpt.get().getToken().equals(token)){
                throw new RuntimeException("Invalid or expired session. Please login again. ");
            }


            if(userId !=null && SecurityContextHolder.getContext().getAuthentication()==null){
                User user=userService.getUserById(userId);
                UsernamePasswordAuthenticationToken authenticationToken=
                        new UsernamePasswordAuthenticationToken(null,null);
                authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request,response);
        }catch(Exception e){
                handlerExceptionResolver.resolveException(request,response,null,e);
        }
    }
}

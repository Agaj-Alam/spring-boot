package com.agajalam.SecurityApp.Week5.service;

import com.agajalam.SecurityApp.Week5.entities.Session;
import com.agajalam.SecurityApp.Week5.entities.User;
import com.agajalam.SecurityApp.Week5.repositories.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final int SESSION_LIMIT=2;
    public void generateNewSession(User user, String refreshToken){
        List<Session> userSession=sessionRepository.findByUser(user);

        if(userSession.size()==SESSION_LIMIT){
            userSession.sort(Comparator.comparing(Session::getLastUsedAt));

            Session leastRecentlyUsedSession=userSession.getFirst();
            sessionRepository.delete(leastRecentlyUsedSession);
        }

        Session newSession=Session.builder()
                .user(user)
                .refreshToken(refreshToken)
                .build();
        sessionRepository.save(newSession);
    }

    public void validateSession(String refreshToken){
        Session session=sessionRepository.findByRefreshToken(refreshToken)
                .orElseThrow(()->new SessionAuthenticationException("session not found for refreshToken"+refreshToken));

        session.setLastUsedAt(LocalDateTime.now());
        sessionRepository.save(session);
    }
}

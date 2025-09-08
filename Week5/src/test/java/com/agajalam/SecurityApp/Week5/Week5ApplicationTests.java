package com.agajalam.SecurityApp.Week5;

import com.agajalam.SecurityApp.Week5.entities.User;
import com.agajalam.SecurityApp.Week5.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Week5ApplicationTests {
    @Autowired
    private JwtService jwtService;

	@Test
	void contextLoads() {
        User user=new User(4L,"agajalam@gmail.com","1234","Agaj");
        String token=jwtService.generateToken(user);
        System.out.println(token);

        Long id=jwtService.getUserIdFromToken(token);
        System.out.println(id);
	}

}

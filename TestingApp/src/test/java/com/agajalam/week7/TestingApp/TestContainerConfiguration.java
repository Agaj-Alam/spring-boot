package com.agajalam.week7.TestingApp;

import org.postgresql.util.internal.PgBufferedOutputStream;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration
public class TestContainerConfiguration {

//    @Bean
//    @ServiceConnection
//    PostgreSQLContainer<?>postgreSQLContainer(){
//        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
//    }

    @Bean
    @ServiceConnection // 👈 This tells Spring Boot to use this container for the datasource
    public PostgreSQLContainer<?> postgreSQLContainer() {
        // ✅ specify image properly
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"));
    }

}

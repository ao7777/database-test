package org.reevoo.movie_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MovieTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieTestApplication.class, args);
    }
}

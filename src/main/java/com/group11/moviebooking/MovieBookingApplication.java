package com.group11.moviebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.group11.moviebooking.repository")
// @SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class MovieBookingApplication {

    public static void main(String[] args) {
        // container
        ApplicationContext NgDTri = SpringApplication.run(MovieBookingApplication.class, args);
        for (String s : NgDTri.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }
}

package com.example.demo;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    UserService service(UsersRepository repsitory) {
        return new UserService(repsitory);
    }

    @Bean
    MeterBinder userMetrics(UserService userService) {
        return registry -> Gauge.builder("user.cout", userService::count);
    }

}

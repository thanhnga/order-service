package io.digital101.configuration;

import io.digital101.service.UserDetailServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Profile("app")
@Configuration
@EnableWebSecurity
public class ApplicationConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImp();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {
            requests
                    .requestMatchers("/*").permitAll()
                    .anyRequest().authenticated();
        }).csrf(c -> c.disable());

        return http.build();
    }


}
package io.digital101.configuration;

import io.digital101.entity.UserRole;
import io.digital101.exception.OrderServiceException;
import io.digital101.service.UserDetailServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImp();
    }

    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        http.authorizeHttpRequests((requests) -> {
            try {
                requests
                        .requestMatchers("/", "/login", "/logout").permitAll()
                        .requestMatchers("/admin/*").hasRole(UserRole.OWNER.name())
                        .requestMatchers("/operator/*").hasRole(UserRole.OPERATOR.name())
                        .anyRequest().authenticated();
            } catch (Exception e) {
                throw new OrderServiceException(e.getMessage());
            }
        })
        .authenticationProvider(authenticationProvider())
        .httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(encoder());
        return authenticationProvider;
    }

}
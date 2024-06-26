package com.example.demo;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
        ).logout(logout -> logout
                .logoutSuccessUrl("/")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/general").hasRole("GENERAL")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
        );
        return http.build();
		
	}
    
    @Bean
    InMemoryUserDetailsManager  userDetailsService() {
    	UserDetails  admin = User
    			.withUsername("admin")
    			.password(passwordEncoder().encode("admin1234"))
    			.roles("ADMIN")
    			.build();
    	UserDetails student = User
    			.withUsername("student")
    			.password(passwordEncoder().encode("student5678"))
    			.roles("USER")
    			.build();
    	System.out.printf("admin1234 -> [%s]\n", passwordEncoder().encode("admin1234"));
    	System.out.printf("student5678 -> [%s]\n", passwordEncoder().encode("student5678"));
    	return new InMemoryUserDetailsManager(admin, student);

    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

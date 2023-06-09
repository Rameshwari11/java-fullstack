package com.cgi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public AuthenticationManager authenticationManager(
                                 AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
	
	@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
        .authorizeHttpRequests((authorize) ->authorize
        		.antMatchers("/auth/*").permitAll()
				.antMatchers(HttpMethod.GET, "/movies/find-all-movies").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/movies/create-movie").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.GET, "/movies/*").hasRole("EMPLOYEE")		
				.antMatchers(HttpMethod.PUT, "/movies/update-movie").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.DELETE, "/movies/delete-movie/*").hasRole("EMPLOYEE")
				.anyRequest().authenticated()
        );
		
        return http.build();
    }
}

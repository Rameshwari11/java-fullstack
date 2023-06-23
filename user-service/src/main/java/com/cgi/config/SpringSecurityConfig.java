
package com.cgi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;



@Configuration
@ComponentScan(basePackages = "com.cgi")
public class SpringSecurityConfig {

	/*@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder().username("john").password("{noop}test123").roles("EMPLOYEE").build();
		UserDetails marry = User.builder().username("marry").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();
		UserDetails susan = User.builder().username("susan").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
		return new InMemoryUserDetailsManager(john, marry, susan);
	}

	@Bean
	public UserDetailsManager userDetailsmanager(DataSource dataSource)
	{
	  return	new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer.antMatchers(HttpMethod.GET, "/users").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/users").hasRole("MANAGER")
				.antMatchers(HttpMethod.PUT, "/users").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/users").hasRole("ADMIN"));
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests().antMatchers("/h2-console/**").permitAll();
        http.headers(headers -> headers.frameOptions().disable());
		return http.build();
		
		*/

	 private UserDetailsService userDetailsService;

	    public SpringSecurityConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

		public SpringSecurityConfig(UserDetailsService userDetailsService){
	        this.userDetailsService = userDetailsService;
	    }

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
	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	    	http.csrf().disable()
	        .authorizeHttpRequests((authorize) ->authorize
	        		.antMatchers("/api/auth/*").permitAll()
					.antMatchers(HttpMethod.GET, "/users" ).hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
					.antMatchers(HttpMethod.POST, "/users" ).hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
					.antMatchers(HttpMethod.GET, "/users/*/*").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
					.antMatchers(HttpMethod.PUT, "/users/*").hasAnyRole("MANAGER", "ADMIN")
					.antMatchers(HttpMethod.DELETE, "/users/*").hasAnyRole("ADMIN")
					.anyRequest().authenticated()
	        );
			
	        return http.build();
	    }
	}

package com.eeshu.springsecurity1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    	@Bean
		
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests((requests) -> requests
                                                .requestMatchers( "/mycards", "/myloans", "/contact")
                                .authenticated()
                                                .requestMatchers("/balance").hasAnyAuthority("READ")
                                                .requestMatchers("/account").hasRole("ADMIN")
                                                .requestMatchers("/notices", "/contact", "/error").permitAll());
                    http.formLogin(withDefaults());
                // http.formLogin(disable -> disable.disable());
                http.httpBasic(withDefaults());
                return http.build();
        }
                @Bean
                public UserDetailsService userDetailsService() {
                        UserDetails admin = User.withUsername("admin").password("{bcrypt}$2a$12$rYeWpAOpZrfz1mkENrx81.lRSEybKMRvgdddXOc1acNJASr1/AimO").roles("ADMIN").build();
                        UserDetails user = User.withUsername("user")
                                        .password("{bcrypt}$2a$12$nY1A9GuYalp9eO1mWCjaUuH2D4vHb.twoei8mXYSAyZpCpfFMwvZW")
                                        .authorities("READ").build();
                        // UserDetails user3 = User.withUsername("user3").password("{noop}123").roles("READ").build();

                        return new InMemoryUserDetailsManager(user, admin);
                }

                public PasswordEncoder passwordEncoder() {
                        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
                }
@Bean
                public CompromisedPasswordChecker compromisedPasswordChecker() {
                        return new HaveIBeenPwnedRestApiPasswordChecker();
                }

}

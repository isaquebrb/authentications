package br.com.isaquebrb.authentications.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static br.com.isaquebrb.authentications.adapter.config.UserPermission.ADMIN_READ;
import static br.com.isaquebrb.authentications.adapter.config.UserPermission.ADMIN_WRITE;
import static br.com.isaquebrb.authentications.adapter.config.UserPermission.BURGER_READ;
import static br.com.isaquebrb.authentications.adapter.config.UserPermission.BURGER_WRITE;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/h2-console/**").permitAll()
                        .antMatchers(GET, "/api/v1/burgers").hasAuthority(BURGER_READ.name())
                        .antMatchers(POST, "/api/v1/burgers").hasAuthority(BURGER_WRITE.name())
                        .antMatchers(PUT, "/api/v1/burgers").hasAuthority(BURGER_WRITE.name())
                        .antMatchers(DELETE, "/api/v1/burgers").hasAuthority(BURGER_WRITE.name())
                        .antMatchers("/api/v1/burgers").hasRole(UserRole.USER_BURGER.name())
                        .anyRequest().authenticated())
                .httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("test12345"))
                .roles(UserRole.USER_BURGER.name())
                .authorities(BURGER_READ.name())
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password(passwordEncoder().encode("test12345"))
                .roles(UserRole.USER_ADMIN.name())
                .authorities(ADMIN_READ.name(), ADMIN_WRITE.name())
                .build();

        UserDetails user3 = User.builder()
                .username("user3")
                .password(passwordEncoder().encode("test12345"))
                .roles(UserRole.USER_BURGER.name())
                .authorities(BURGER_READ.name(), BURGER_WRITE.name())
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}

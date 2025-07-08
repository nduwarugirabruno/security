package io.links.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static io.links.security.entity.app.enums.Permission.*;
import static io.links.security.entity.app.enums.Role.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// @EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    final JwtAuthenticationFilter jwtAuthFilter;
    final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/api/v1/auth/**").permitAll()
/*
                                .requestMatchers("/api/v1/admin/**").hasAnyRole(ADMIN.name(), ADMIN_SUDO.name())

                                .requestMatchers(GET, "/api/v1/admin/**").hasAnyAuthority(ADMIN_READ.name(), ADMIN_SUDO_READ.name())
                                .requestMatchers(PUT, "/api/v1/admin/**").hasAnyAuthority(ADMIN_UPDATE.name(), ADMIN_SUDO_UPDATE.name())
                                .requestMatchers(POST, "/api/v1/admin/**").hasAnyAuthority(ADMIN_CREATE.name(), ADMIN_SUDO_CREATE.name())
                                .requestMatchers(DELETE, "/api/v1/admin/**").hasAnyAuthority(ADMIN_DELETE.name(), ADMIN_SUDO_DELETE.name())
                                .requestMatchers(PATCH, "/api/v1/admin/**").hasAnyAuthority(ADMIN_PATCH.name(), ADMIN_SUDO_PATCH.name())
*/
                                .requestMatchers("/api/v1/manager/**").hasAnyRole(MANAGER_USERS.name(), ADMIN.name())

                                .requestMatchers(GET, "/api/v1/manager/**").hasAnyAuthority(MANAGER_USERS_READ.name(), ADMIN_READ.name())
                                .requestMatchers(PUT, "/api/v1/manager/**").hasAnyAuthority(MANAGER_USERS_UPDATE.name(), ADMIN_UPDATE.name())
                                .requestMatchers(POST, "/api/v1/manager/**").hasAnyAuthority(MANAGER_USERS_CREATE.name(), ADMIN_CREATE.name())
                                .requestMatchers(DELETE, "/api/v1/manager/**").hasAnyAuthority(MANAGER_USERS_DELETE.name(), ADMIN_DELETE.name())
                                .requestMatchers(PATCH, "/api/v1/manager/**").hasAnyAuthority(MANAGER_USERS_PATCH.name(), ADMIN_PATCH.name())

                                .requestMatchers("/api/v1/demo/**").hasRole(USER_STANDARD.name())

                                .anyRequest()
                                .authenticated())
                .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //.oauth2Login(withDefaults())
                //.formLogin(withDefaults())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
    }
}

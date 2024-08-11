package com.butler.booking.common.config

import com.butler.booking.common.filter.JwtRequestFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        return http
            .csrf { it.disable() }
            .cors { it.disable() }
            .authorizeHttpRequests{ request ->
                request.requestMatchers("/booking/**").hasAnyAuthority("ROLE_USER")
                request.anyRequest().authenticated()
            }
            .addFilterBefore(JwtRequestFilter(), UsernamePasswordAuthenticationFilter::class.java)
            .formLogin(Customizer.withDefaults())
            .build()
    }
}
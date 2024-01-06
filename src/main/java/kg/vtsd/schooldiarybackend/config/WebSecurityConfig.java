package kg.vtsd.schooldiarybackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import kg.vtsd.schooldiarybackend.services.UserAuthenticationService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired
    private UserAuthenticationService userAuthenticationService;

   	@Autowired
	private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/admins").hasAuthority("ADMIN")
                .requestMatchers("/users").permitAll() 
                .anyRequest().authenticated())
        .formLogin((form) -> form
                .permitAll())
        .logout((logout) -> logout
                .permitAll());
    return http.build();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userAuthenticationService)
            .passwordEncoder(passwordEncoder);
    }

}

package pl.monika.mavenproject1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("Password")).roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/students/**").hasRole("USER")
            .antMatchers(HttpMethod.POST, "/students").hasRole("USER")
            .antMatchers(HttpMethod.PUT, "/students/**").hasRole("USER")
            .antMatchers(HttpMethod.PATCH, "/students/**").hasRole("USER")
            .antMatchers(HttpMethod.DELETE, "/students/**").hasRole("USER")
            .antMatchers("/v2/api-docs",
                         "/configuration/ui",
                         "/swagger-resources/**",
                         "/configuration/security",
                         "/swagger-ui.html").hasRole("USER")
            .and()
            .csrf().disable()
            .formLogin().disable();
    }
    
}
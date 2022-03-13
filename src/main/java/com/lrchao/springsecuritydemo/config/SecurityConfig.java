package com.lrchao.springsecuritydemo.config;

import com.lrchao.springsecuritydemo.handler.MyAuthenticationErrorHandler;
import com.lrchao.springsecuritydemo.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * StringSecurity config class
 *
 * @author kevinliu
 * @date 3/8/22 10:44 PM
 * @since v1.0.0
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("username123")
                .passwordParameter("password123")
                .loginProcessingUrl("/login")
                .loginPage("/login.html")
                .successForwardUrl("/toMain")
//                .successHandler(new MyAuthenticationSuccessHandler("https://www.google.com"))
//                .failureHandler(new MyAuthenticationErrorHandler("https://www.baidu.com"));
                .failureForwardUrl("/toError");

        http.authorizeHttpRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
//                .regexMatchers(HttpMethod.GET, "/demo").permitAll()
//                .mvcMatchers("/demo").servletPath("/xxxx").permitAll()
                .antMatchers("/main1.html").hasAuthority("admin")
                .anyRequest().authenticated();

        // close
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }
}

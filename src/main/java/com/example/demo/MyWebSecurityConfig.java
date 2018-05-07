package com.example.demo;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService    userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MyWebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //        http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users/signup")
        //                .permitAll().anyRequest().authenticated().and().addFilter(new JWTLoginFilter(authenticationManager()))
        //                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
        //http.authorizeRequests() 有多个子方法，可以添加多个.antMatchers("/testRest", "/testPage")

        http.authorizeRequests().antMatchers("/testRest", "/testPage").permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

}

package com.hoangtu.admin.config;


import com.hoangtu.admin.service.user.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/admin/login")
                .defaultSuccessUrl("/")
                .failureUrl("/admin/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin/login");

        http.authorizeRequests().antMatchers("/admin/login").permitAll();

//        http.authorizeRequests().antMatchers("/admin/customer/home").hasAnyRole("ROLE_ADMIN","ROLE_USER");
//
        http.authorizeRequests().antMatchers("/admin/customer/home").access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/admin/product/home").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");

        http.exceptionHandling().accessDeniedPage("/admin/403");

        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rememberMeCookie")
                .tokenValiditySeconds(60 * 60);

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}

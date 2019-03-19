package com.spring.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private WebAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
        .authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=true")
            .defaultSuccessUrl("/", true)
            .usernameParameter("email")
            .passwordParameter("password")
            .and()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/login");
	
	//            .antMatchers("/webjars/**","/css/**","/js/**","/fonts/**","/images/**","/vendor/**").permitAll()

    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
	web
	    .ignoring()
	    .antMatchers("/webjars/**","/css/**","/js/**","/fonts/**","/images/**","/vendor/**");
    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//	http.
// 	authorizeRequests()
// 	    .antMatchers("/").permitAll()
//            .antMatchers("/login").permitAll()
//            .antMatchers("/registration").permitAll()
//            .antMatchers("/admin/**").hasAuthority("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//        .csrf()
//            .disable()
//        .formLogin()
//            .loginPage("/login")
//            .failureUrl("/login?error=true")
//            .defaultSuccessUrl("/admin/home")
//            .usernameParameter("email")
//            .passwordParameter("password")
//            .and()
//        .logout()
//            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//            .logoutSuccessUrl("/")
//            .and()
//        .exceptionHandling()
//            .accessDeniedPage("/access-denied");
//    }
}

/**
 *  All Rights Reserved.
 *  Private and Confidential. May not be disclosed without permission.
 */
package com.myprofile.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author venkatasaikiran
 * @date Apr 8, 2018 2:21:13 PM
 *
 */

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //--------------------------------------------------------------- Constants
    //--------------------------------------------------------- Class Variables
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private DataSource dataSource;
    
    @Value("${spring.queries.users-query}")
    private String usersQuery;
    //----------------------------------------------------- Static Initializers
    //------------------------------------------------------ Instance Variables
    //------------------------------------------------------------ Constructors
    //---------------------------------------------------------- Public Methods
    //------------------------------------------------------- Protected Methods
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().usersByUsernameQuery(usersQuery)
        .dataSource(dataSource)
        .passwordEncoder(bCryptPasswordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
        .antMatchers("/index.jsf", "/login/**","/signup/**", "/javax.faces.resources/**").permitAll()
        .antMatchers("/profile/**").anonymous()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login/login.jsf")
//        .defaultSuccessUrl("/profile/home.jsf")
        .usernameParameter("userID")
        .passwordParameter("password")
        .and()
        .logout().logoutSuccessUrl("/login/login.jsf").invalidateHttpSession(true).deleteCookies("JSESIONID")
        .and()
        .exceptionHandling().accessDeniedPage("/login/login.jsf")
        .and()
        .csrf().disable();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
    //--------------------------------------------------------- Default Methods
    //--------------------------------------------------------- Private Methods
    //---------------------------------------------------------- Static Methods
    
    //----------------------------------------------------------- Inner Classes
}
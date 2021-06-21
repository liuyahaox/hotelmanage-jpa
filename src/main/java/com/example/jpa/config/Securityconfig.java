package com.example.jpa.Config;


import com.example.jpa.User.Myservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter{
   @Autowired
   PasswordEncoder encoder;
   @Autowired
   Myservice myservice;
   

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       System.out.println("被调用");
       auth.userDetailsService(myservice).passwordEncoder(encoder);
   }
   @Bean
   public PasswordEncoder encoder() {
      return new BCryptPasswordEncoder();
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers("/User/tologin").permitAll()
      .antMatchers("/login").permitAll()
      .antMatchers("/page/logout").permitAll()
      .antMatchers("/User/registration").permitAll()
      .antMatchers("/User/regist").permitAll()
      .antMatchers("//page/Customer/getallroom").hasAnyAuthority("admin","common")
      .antMatchers("/page/**").hasAuthority("admin")
      .anyRequest().authenticated() //任何请求,登录后可以访问
      .and()
      .formLogin()
      .loginPage("/")
      .loginProcessingUrl("/User/tologin")
      .successForwardUrl("/page")
      .failureForwardUrl("/loginerro")
      .permitAll() //登录页面用户任意访问
      .and()
      .logout()
      .logoutUrl("/page/logout").permitAll()
      .logoutSuccessUrl("/tologout")              //注销行为任意访问
      .and()
      .csrf().disable()
      .headers().frameOptions().disable();//内嵌页面必须设置
   }

   @Override
   public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/layui/**","/page/test.html","/jquery-3.5.1.js/**");
   }
   @Bean
   public static PasswordEncoder passwordEncoder(){  
       return new BCryptPasswordEncoder();
  }  

 
    }





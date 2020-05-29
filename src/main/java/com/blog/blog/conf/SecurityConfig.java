package com.blog.blog.conf;

import com.blog.blog.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userService(){
        return new UserDetailServiceImpl();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login**").permitAll()
                    .antMatchers("/login.do**").permitAll()
                    .antMatchers("/register**").permitAll()
                    .antMatchers("/register.do**").permitAll()
                    .antMatchers("/admin/**").hasAnyRole("Admin")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login.do")
                    .usernameParameter("userName")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/admin/index")
                    .failureForwardUrl("/login?error=true")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .permitAll()
                    .logoutSuccessUrl("/admin/login")
                    .permitAll()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .and()
                .sessionManagement()
                    .invalidSessionUrl("/login")
                    .maximumSessions(1).maxSessionsPreventsLogin(true);

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http
                .addFilterBefore(filter, CsrfFilter.class);
        http
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**","/js/**","/img/**");
    }
}

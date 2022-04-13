package com.fasttrack.cafe.tmcafes.untils;

import com.fasttrack.cafe.tmcafes.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] IGNORED_RESOURCE_LIST = new String[] {"/fonts/**", "/webjars/**",
            "/files/**" , "/css/**", "/js/**", "/vendor/**", "/images/**", "/test" };
    private static final String[] PERMITALL_RESOURCE_LIST = new String[] { "/signin/**", "/login/**"};

    private final UserDetailsServiceImpl userDetailsService;

    private final AuthenticationFailureHandler authenticationFailureHandler;
    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService, AuthenticationFailureHandler authenticationFailureHandler, DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.dataSource = dataSource;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Configuration
    protected static class MySqlWebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
            userDetailsService.setDataSource(dataSource);
            PasswordEncoder encoder = new BCryptPasswordEncoder();

            auth.userDetailsService(userDetailsService).passwordEncoder(encoder).and().jdbcAuthentication()
                    .dataSource(dataSource);
        }
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(IGNORED_RESOURCE_LIST);

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(PERMITALL_RESOURCE_LIST).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                    .anonymous()
                    .key("anonymous")
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .loginProcessingUrl("/signin/authenticate")
                    .defaultSuccessUrl("/pos")
                    .failureHandler(authenticationFailureHandler)
                    .permitAll()
                .and()
                    .logout().logoutSuccessUrl("/login")
                    .deleteCookies("remember-me")
                    .permitAll()
                .and()
                    .csrf().disable()
                    .exceptionHandling()
                    .accessDeniedPage("/403");
    }
}


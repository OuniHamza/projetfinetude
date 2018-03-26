package pfe.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

//@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    DataSource dataSource;
//     @Autowired
//     private UserDetailsService userDetailsService;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username as principal,password as credentials , true from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username as principal ,role as role from users where username=?")
                .rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable();
//                http.authorizeRequests();
       http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll();
//      //  http.exceptionHandling().accessDeniedPage("/403");
    }
}

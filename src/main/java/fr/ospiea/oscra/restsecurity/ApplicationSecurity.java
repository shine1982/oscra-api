package fr.ospiea.oscra.restsecurity;



import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by taozheng on 27/09/2016.
 * refer to https://dzone.com/articles/secure-rest-services-using
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RESTAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private RESTLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    private DataSource restDataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder authbuilder) throws Exception {
        authbuilder.jdbcAuthentication()
                    .dataSource(restDataSource)
                    .passwordEncoder(passwordEncoder())
                    .usersByUsernameQuery(getUserQuery())
                    .authoritiesByUsernameQuery(getAuthoritiesQuery());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .formLogin().loginPage("/login").permitAll()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .sessionManagement()
                .maximumSessions(1);
        http.authorizeRequests().antMatchers("/**").authenticated();
        //http.authorizeRequests().antMatchers("/**").permitAll();

    }

    private String getUserQuery(){
        return "select username,password,enabled from user where username=?";
    }

    private String getAuthoritiesQuery(){
        return "select username,role from user where username=?";
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}

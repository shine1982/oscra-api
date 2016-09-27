package fr.ospiea.oscra.restsecurity;


import fr.ospiea.oscra.employee.object.Employee;
import fr.ospiea.oscra.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by taozheng on 27/09/2016.
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
    private EmployeeService employeeService;

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                Employee employee = employeeService.findByUserame(s);
                if(employee != null) {
                    /*
                    return new User(employee.getUsername(), employee.getPassword(), true, true, true, true,
                            AuthorityUtils.createAuthorityList("USER"));
                } else {
                    throw new UsernameNotFoundException("could not find the user '"
                            + username + "'");*/
                }
                return null;
            }
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authbuilder) throws Exception {
        authbuilder.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
                .password("admin").roles("ADMIN");
        /*
        * Authentication poricder is suitable for a centralized authentication system, where we offten
        * did not have the password.
        * In our case, we save the user's password into our own database. So it is better to use
        * userDetailsService for our case. May need to rethink this part when much more users occured.
        * */
        //authbuilder.authenticationProvider();
        authbuilder.userDetailsService(userDetailsService());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/**").permitAll();
                //.authenticated();
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);
    }
}

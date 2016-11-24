package fr.ospiea.oscra.restsecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ospiea.oscra.user.object.User;
import fr.ospiea.oscra.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taozheng on 27/09/2016.
 */
@Component
public class RESTAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RESTAuthenticationSuccessHandler.class);

    private final ObjectMapper mapper;

    RESTAuthenticationSuccessHandler(MappingJackson2HttpMessageConverter messageConverter) {
        this.mapper = messageConverter.getObjectMapper();
    }


    @Autowired
    private UserService userService;
    /*
    * when success, should return status code 200
    *               should return authenticated user
    **/
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        User authenticatedUser = userService.findByUserame(request.getParameter("username"));
        /* control of session http://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting */
        request.getSession(true);
        response.getWriter().write(mapper.writeValueAsString(authenticatedUser));
        response.getWriter().flush();
        response.getWriter().close();
        clearAuthenticationAttributes(request);

    }

}

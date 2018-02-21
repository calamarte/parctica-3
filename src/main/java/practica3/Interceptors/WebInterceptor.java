package practica3.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import practica3.login.AuthLogin;
import practica3.login.Mock;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WebInterceptor extends HandlerInterceptorAdapter {

    private AuthLogin checkLogin = new Mock();

    private static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    private static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    private static final String METHODS_NAME = "Access-Control-Allow-Methods";
    private static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    private static final String MAX_AGE_NAME = "Access-Control-Max-Age";
    private static final Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader(CREDENTIALS_NAME, "true");
        response.setHeader(ORIGIN_NAME, "*");
        response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader(HEADERS_NAME, "Origin, Content-Type, accept, Authorization");
        response.setHeader(MAX_AGE_NAME, "3600");

        logger.info(handler.toString());

        String auth = request.getHeader("Authorization");


        if (!request.getRequestURL().toString().endsWith("/")){

            if(auth != null) {
                String cypherHeader = auth.split(" ")[1];
                String[] decoded = new String(Base64.getDecoder().decode(cypherHeader)).split(":");

                if (checkLogin.validate(decoded[0],decoded[1])){
                    return true;
                }
            }
            response.sendError(401);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}


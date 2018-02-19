package practica3.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;
import practica3.login.AuthLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Authenticator;

@Component
public class WebInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    AuthLogin checkLogin;

    private static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    private static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    private static final String METHODS_NAME = "Access-Control-Allow-Methods";
    private static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    private static final String MAX_AGE_NAME = "Access-Control-Max-Age";
    private static final Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request URL::" + request.getRequestURL().toString());
        response.setHeader(CREDENTIALS_NAME, "true");
        response.setHeader(ORIGIN_NAME, "*");
        response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
        response.setHeader(HEADERS_NAME, "Origin, Content-Type, accept, Authorization");
        response.setHeader(MAX_AGE_NAME, "3600");

        logger.info(request.getHeader("Content-type"));

        String auth = request.getHeader("Authorization");
        logger.info(auth);

//
//        String headerContent = request.getHeader("Authorization");
//        logger.info("header 1: "+headerContent);

        if (!request.getRequestURL().toString().endsWith("/")){
//            logger.info("no /");
//            String headerContent2 = request.getHeader("Authorization");
//            logger.info("header2: "+headerContent);
            String cypherHeader = auth.split(" ")[1];
//            logger.info("cifrado"+cypherHeader);
            String decoded = new String(Base64.getDecoder().decode(cypherHeader));

            logger.warn(decoded);
//            logger.info("decoded: "+decoded);

//            checkLogin.validate(request.getHeader("Authorization"));
        }

//        String[] cypherHeader = headerContent.split(" ");
//        logger.info(cypherHeader.toString());
//        byte[] decoded = Base64.getDecoder().decode(cypherHeader);
//        logger.info("decoded: "+decoded);


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

}


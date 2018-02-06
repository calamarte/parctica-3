package practica3.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by xavi on 24/01/18.
 */
public class WebServletConfiguration implements WebApplicationInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException {
        // Load Spring web application com.configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(WebConfig.class);
        ac.setServletContext(servletContext);
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        // NEVER!! https://stackoverflow.com/questions/41577234/why-does-spring-mvc-respond-with-a-404-and-report-no-mapping-found-for-http-req
        // registration.addMapping("/*");
        registration.addMapping("/");

    }
}

package practica3.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import practica3.Interceptors.WebInterceptor;
import practica3.login.AuthLogin;
import practica3.login.Mock;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "practica3")
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public AuthLogin authLogin(){
        return new Mock();
    }

    @Bean
    public WebInterceptor webInterceptor(){
        WebInterceptor webInterceptor = new WebInterceptor();
        webInterceptor.setAuthLogin(authLogin());
        return webInterceptor;
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(webInterceptor());
    }

}

package practica3.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practica3.Utils.Utils;
import practica3.exception.CustomExceptionGenerator;


import java.net.SocketException;

@PropertySource("classpath:application.properties")
@Controller
public class ViewController {
    @Value("${view.myself}")
    private boolean viewMyself;
    @Value("${tomcat.port}")
    private int tomcatPort;

    @RequestMapping("/")
    public ModelAndView home() throws SocketException {
       ModelAndView jsp = new ModelAndView("index");
       jsp.addObject("port",tomcatPort);

       if(viewMyself)jsp.addObject("ip","/localhost");
       else jsp.addObject("ip", Utils.getFirstNonLoopbackAddress());

       return jsp;
    }

    @ExceptionHandler(CustomExceptionGenerator.class)
    public ModelAndView handleLoginException(CustomExceptionGenerator exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getErrorMessage());

        return modelAndView;
    }
}

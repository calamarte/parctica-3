package practica3.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practica3.exception.CustomExceptionGenerator;
import practica3.practica3.utils.Utils;

import java.net.SocketException;


@Controller
public class ViewController {

    @RequestMapping("/")
    public ModelAndView home() throws SocketException {
       ModelAndView jsp = new ModelAndView("index");
       jsp.addObject("ip", Utils.getFirstNonLoopbackAddress());
       return jsp;
    }

    @ExceptionHandler(CustomExceptionGenerator.class)
    public ModelAndView handleLoginException(CustomExceptionGenerator exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getErrorMessage());

        return modelAndView;
    }
}

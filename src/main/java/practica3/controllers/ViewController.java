package practica3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practica3.exception.CustomExceptionGenerator;
import practica3.login.AuthLogin;
import practica3.practica3.utils.Utils;

import java.net.SocketException;

@Controller
public class ViewController {

    @Autowired
    AuthLogin login;

    @RequestMapping("/")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/inici")
    public ModelAndView home(String password) throws CustomExceptionGenerator, SocketException {
        ModelAndView modelAndView = new ModelAndView("index");
        if (login.validate("","")) {
            modelAndView.addObject("ip", Utils.getFirstNonLoopbackAddress());
        } else {
            throw new CustomExceptionGenerator(HttpStatus.FORBIDDEN);
        }
        return modelAndView;
    }

    @ExceptionHandler(CustomExceptionGenerator.class)
    public ModelAndView handleLoginException(CustomExceptionGenerator exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",exception.getErrorMessage());

        return modelAndView;
    }
}

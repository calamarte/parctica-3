package practica3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practica3.exception.CustomExceptionGenerator;
import practica3.login.Mock;
import practica3.practica3.utils.Utils;

import java.net.SocketException;

@Controller
public class ViewController {

    @RequestMapping("/")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping("/inici")
    public ModelAndView home(@RequestParam("user") String user, @RequestParam("pass") String password) throws CustomExceptionGenerator, SocketException {
        Mock mock = new Mock();
        ModelAndView modelAndView = new ModelAndView("index");
        if (mock.validate(user,password)) {
            modelAndView.addObject("ip", Utils.getFirstNonLoopbackAddress());
        } else {
            throw new CustomExceptionGenerator("Credencials incorrectes");
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

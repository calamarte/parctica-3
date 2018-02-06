package practica3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import practica3.login.Mock;

@RestController
public class ViewController {

    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView mock = new ModelAndView("login");
        return mock;
    }

    @RequestMapping("/inici")
    public ModelAndView home(@RequestParam("user") String user, @RequestParam("pass") String password) {
        Mock mock = new Mock();
        ModelAndView modelAndView = new ModelAndView("index");
        if (mock.validate(user,password)) {
            modelAndView.addObject("name",user);
        } else {
            modelAndView.addObject("name","Error");
        }
        return modelAndView;
    }
}

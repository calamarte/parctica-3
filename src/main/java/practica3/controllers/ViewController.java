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
        ModelAndView m = new ModelAndView("login");
        System.out.println(m.getStatus());
        return m;
    }

    @RequestMapping("/inici")
    public String home(@RequestParam("user") String user, @RequestParam("pass") String password) {
        Mock m = new Mock();
        if (m.validate(user,password)) {
            return "Benvingut " + user;
        } else {
            return "Login error";
        }
    }
}

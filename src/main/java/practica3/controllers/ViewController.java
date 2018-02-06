package practica3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {

    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView m = new ModelAndView("login");
        System.out.println(m.getStatus());
        return m;
    }

    @RequestMapping("/inici")
    public String home(@RequestParam("user") String user){
        return "Benvingut " + user;
    }
}

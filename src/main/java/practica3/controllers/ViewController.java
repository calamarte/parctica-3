package practica3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {

    @RequestMapping("/")
    public ModelAndView prueba(){
        ModelAndView m = new ModelAndView("index");

        m.addObject("name","calamarte");
        return m;
    }

    @RequestMapping("/hola")
    public String ppe(){
        return "hoal";
    }
}

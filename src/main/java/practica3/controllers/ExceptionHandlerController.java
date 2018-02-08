package practica3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExceptionHandlerController {
    //    @ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Error credentials")
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public void conflict() {
//        System.out.println("Error");
//    }
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        System.out.println("Request: " + req.getRequestURL() + " raised " + ex);

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}

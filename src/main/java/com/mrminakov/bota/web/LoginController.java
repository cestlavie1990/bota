package com.mrminakov.bota.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mr.Minakov
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView mv = new ModelAndView();
        if (error != null) {
            mv.addObject("error", "Incorrect login or password!");
        }
        mv.setViewName("login");
        return mv;
    }
    
    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:objects";
    }
}

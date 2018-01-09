package com.mrminakov.bota.web;

import com.mrminakov.bota.service.interfaces.CompaniesService;
import com.mrminakov.bota.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Mr.Minakov
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {
    
    private static final int REG_COMPLITE = 0;
    private static final int ERR_EMAIL_IS_USED = 1;

    @Autowired
    private CompaniesService companiesService;

    @Autowired
    private UsersService usersService;

    @RequestMapping("")
    private String load() {
        return "registration";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    @ResponseBody
    private String confirm(
            @RequestParam String email,
            @RequestParam String login,
            @RequestParam String companyName,
            @RequestParam String password,
            @RequestParam String passwordRepeat,
            @RequestParam String username,
            @RequestParam String position) {
        return "redirect:/objects";
    }
}

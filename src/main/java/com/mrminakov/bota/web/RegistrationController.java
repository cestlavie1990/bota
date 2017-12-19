package com.mrminakov.bota.web;

import com.mrminakov.bota.service.interfaces.CompaniesService;
import com.mrminakov.bota.service.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mr.Minakov
 */
@Controller
public class RegistrationController {
    
    @Autowired
    private CompaniesService companiesService;
    
    @Autowired
    private UsersService usersService;
    
    @RequestMapping("/registration")
    private String load() {
        return "registration";
    }
    
}
package com.mrminakov.bota.web;

import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Users;
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

    private static final String REG_COMPLITE = "REG_COMPLITE";
    
    private static final String ERR_EMAIL_IS_USED = "ERR_EMAIL_IS_USED";
    private static final String ERR_COMPLOGIN_IS_USED = "ERR_COMPLOGIN_IS_USED";
    
    private static final String ERR_DIFFERENT_PASSWORDS = "ERR_DIFFERENT_PASSWORDS";    
    
    private static final String ERR_FIELD_IS_EMPTY = "ERR_FIELD_IS_EMPTY";
    
    private static final String ERR_EMAIL_IS_EMPTY = "ERR_EMAIL_IS_EMPTY";
    private static final String ERR_LOGIN_IS_EMPTY = "ERR_LOGIN_IS_EMPTY";
    private static final String ERR_COMPANY_NAME_IS_EMPTY = "ERR_COMPANY_NAME_IS_EMPTY";
    private static final String ERR_COMPANY_LOGIN_IS_EMPTY = "ERR_COMPANY_LOGIN_IS_EMPTY";
    private static final String ERR_PASSWORD_IS_EMPTY = "ERR_PASSWORD_IS_EMPTY";
    private static final String ERR_PASSWORD_REPEAT_IS_EMPTY = "ERR_PASSWORD_REPEAT_IS_EMPTY";
    private static final String ERR_USERNAME_IS_EMPTY = "ERR_USERNAME_IS_EMPTY";

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
            @RequestParam String companyLogin,
            @RequestParam String password,
            @RequestParam String passwordRepeat,
            @RequestParam String username,
            @RequestParam String position) {
        if (isUserLoginFree(login)) {
            return "ok";
        } else {
            return "fail";
        }
    }

    private boolean isUserLoginFree(final String login) {
        return usersService.getByLogin(login) == null;
    }
}

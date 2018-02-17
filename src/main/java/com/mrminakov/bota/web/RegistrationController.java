package com.mrminakov.bota.web;

import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Users;
import com.mrminakov.bota.service.interfaces.CompaniesService;
import com.mrminakov.bota.service.interfaces.UsersService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mr.Minakov
 */
@Controller
public class RegistrationController {

    private static final String ERR_EMAIL_USED = "ERR_EMAIL_USED";
    private static final String ERR_COMPANY_LOGIN_USED = "ERR_COMPANY_LOGIN_USED";
    private static final String ERR_USER_LOGIN_USED = "ERR_USER_LOGIN_USED";

    @Autowired
    private CompaniesService companiesService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    private ModelAndView load(HttpSession session) {
        ModelAndView mv = new ModelAndView("regCompany");
        mv.addObject("company", new Companies());
        return mv;
    }

    @RequestMapping(value = "/check-company", method = RequestMethod.POST)
    private ModelAndView checkCompany(@Valid @ModelAttribute("company") Companies company, BindingResult bindingResult, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("regCompany");
        if (bindingResult.hasErrors()) {
            return mv;
        } else if (isCompanyLoginUsed(company.getCompanyLogin())) {
            mv.addObject("error", ERR_COMPANY_LOGIN_USED);
            return mv;
        } else if (isEmailUsed(company.getEmail())) {
            mv.addObject("error", ERR_EMAIL_USED);
            return mv;
        }
        mv.clear();
        request.getSession().setAttribute("company", company);
        mv.addObject("user", new Users());
        mv.setViewName("regUser");
        return mv;
    }

    @RequestMapping(value = "/check-user", method = RequestMethod.POST)
    private ModelAndView checkUser(@Valid @ModelAttribute("user") Users user, BindingResult bindingResult, HttpServletRequest request) {
        Companies company = (Companies) request.getSession().getAttribute("company");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("regUser");
        if (bindingResult.hasErrors()) {
            return mv;
        } else if (isUserLoginUsed(user.getUsername())) {
            mv.addObject("error", ERR_USER_LOGIN_USED);
            return mv;
        }
        company = createCompany(company);
        createUser(company, user);

        mv.clear();
        mv.setViewName("regComplete");
        return mv;
    }

    private Companies createCompany(final Companies company) {
        company.setDateRegistration(new Date());

        companiesService.createCompany(company);

        return company;
    }

    private void createUser(
            final Companies company,
            final Users user) {
        user.setRecordIdCompany(company);
        user.setDateRegistration(new Date());
        user.setEnabled(true);
        
        usersService.addUserToGroupAdmin(user.getUsername());

        usersService.createUser(user);
    }

    private boolean isCompanyLoginUsed(final String companyLogin) {
        return companiesService.getByCompanyLogin(companyLogin) != null;
    }

    private boolean isEmailUsed(final String email) {
        return companiesService.getByEmail(email) != null;
    }

    private boolean isUserLoginUsed(final String username) {
        return usersService.getByUsername(username) != null;
    }

}

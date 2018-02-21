package com.mrminakov.bota.web;

import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Users;
import com.mrminakov.bota.service.interfaces.CompaniesService;
import com.mrminakov.bota.service.interfaces.UsersService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mr.Minakov
 */
@Controller
public class MainController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CompaniesService companiesService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Map<String, Object> map) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            Users user = usersService.getByUsername(userDetails.getUsername());

            Companies company = user.getRecordIdCompany();
            String mainURL = "company/" + company.getCompanyLogin();

            return "redirect:" + mainURL;
        }
        return "main";
    }

    @RequestMapping(value = "/company/{companyLogin}", method = RequestMethod.GET)
    public String mainLogged(@PathVariable("companyLogin") String companyLogin, Map<String, Object> map) {
        Companies company = companiesService.getByCompanyLogin(companyLogin);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        if (company != null) {
            map.put("username", userDetails.getUsername());
            map.put("companyName", company.getName());
            return "main";
        } else {
            return "redirect:main";
        }
    }
}

package com.mrminakov.bota.web;

import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Users;
import com.mrminakov.bota.service.interfaces.ObjectsService;
import com.mrminakov.bota.service.interfaces.UsersService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mr.Minakov
 */
@Controller
public class ObjectsController {

    @Autowired
    private ObjectsService objectsService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/objects", method = RequestMethod.GET)
    public String listObjects(Map<String, Object> map) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Users user = usersService.getByUsername(userDetails.getUsername());
        Companies company = user.getRecordIdCompany();

        String companyName = company.getName();
        String username = user.getName();
        Integer countAllActiveObjects = objectsService.getObjects().size();

        map.put("objectsList", objectsService.getObjects());
        map.put("username", username);
        map.put("companyName", companyName);
        map.put("countAllActiveObjects", countAllActiveObjects);

        return "objects";
    }
}

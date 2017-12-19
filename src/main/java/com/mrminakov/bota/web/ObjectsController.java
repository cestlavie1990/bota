package com.mrminakov.bota.web;

import com.mrminakov.bota.service.interfaces.ObjectsService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mr.Minakov
 */
@Controller
public class ObjectsController {

    @Autowired
    private ObjectsService objectsService;

    @RequestMapping("/objects")
    public String listObjects(Map<String, Object> map) {
        map.put("objectsList", objectsService.getObjects());
        return "objects";
    }
    
    @RequestMapping("/")
    public String home() {
        return "redirect:/objects";
    }

}
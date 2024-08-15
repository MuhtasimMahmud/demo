package com.test.demo.controller;

import com.test.demo.models.Property;
import com.test.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/addProperty")
    public Property addProperty(@RequestBody Property property){
        return this.propertyService.addProperty(property);
    }

    @GetMapping("/allProperties")
    public List<Property> allProperties(){
        return this.propertyService.allProperties();
    }



}

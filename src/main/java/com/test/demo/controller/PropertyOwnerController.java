package com.test.demo.controller;

import com.test.demo.models.PropertyOwner;
import com.test.demo.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerService propertyOwnerService;

    @PostMapping("/createPropertyOwner")
    public PropertyOwner create(@RequestBody PropertyOwner owner){
        return this.propertyOwnerService.save(owner);
    }

    @GetMapping("/owners")
    public List<PropertyOwner> home(){
        return propertyOwnerService.getAllOwners();
    }

}

// create, read, update, delete
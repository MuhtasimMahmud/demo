package com.test.demo.controller;

import com.test.demo.models.PropertyOwner;
import com.test.demo.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<PropertyOwner> owners(){
        return this.propertyOwnerService.allOwners();
    }

    @GetMapping("/owners/{id}")
    public PropertyOwner owner(@PathVariable int id){
        return this.propertyOwnerService.findOwner(id);
    }

    @PutMapping("/updateOwner")
    public PropertyOwner updateOwner(@RequestBody PropertyOwner owner){
        return this.propertyOwnerService.update(owner);
    }

    @DeleteMapping("/deleteOwner/{id}")
    public List<PropertyOwner> deleteOwner(@PathVariable int id){
        this.propertyOwnerService.delete(id);
        return owners();
    }
}
package com.test.demo.controller;

import com.test.demo.models.Property;
import com.test.demo.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/addProperty")
    public Property addProperty(@RequestBody Property property){
        return this.propertyService.save(property);
    }

    @GetMapping("/properties")
    public List<Property> allProperties(){
        return this.propertyService.allProperties();
    }

    @GetMapping("/properties/{id}")
    public Property findProperty(@PathVariable int id){
        return this.propertyService.findProperty(id);
    }

    @PutMapping("/updateProperty")
    public Property updateProperty(@RequestBody Property property){
        return this.propertyService.update(property);
    }

    @DeleteMapping("/deleteProperty/{id}")
    public List<Property> deleteProperty(@PathVariable int id){
        this.propertyService.delete(id);
        return allProperties();
    }

}

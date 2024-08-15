package com.test.demo.controller;

import com.test.demo.models.PropertyOwner;
import com.test.demo.service.PropertyOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PropertyOwnerController {

    @Autowired
    private PropertyOwnerService operations;

    @GetMapping("/propertyOwnerEntry")
    public String postNewPropertyOwner(){
        PropertyOwner owner = new PropertyOwner();
        try{
            operations.save(owner);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "home";
    }


    @GetMapping("/readPropertyOwner")
    public String readOwner(Model model){
        int id = 1; // it will be dynamic, just for now fixing as static
        PropertyOwner owner = operations.read(id);
        model.addAttribute("owner", owner);
        return "readOwner";
    }

    @GetMapping("/updatePropertyOwner")
    public String updateOwner(Model model){
        int id = 1;
        PropertyOwner owner = operations.update(id);
        model.addAttribute("owner", owner);
        return "readOwner";
    }



}

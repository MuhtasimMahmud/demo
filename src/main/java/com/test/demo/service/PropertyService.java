package com.test.demo.service;

import com.test.demo.models.Property;
import com.test.demo.models.PropertyOwner;
import com.test.demo.repositories.OwnerRepository;
import com.test.demo.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private OwnerRepository propertyOwnerRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public Property save(Property property) {
        if(propertyRepository.findById(property.getId()) == null && ownerRepository.findById(property.getOwnerId()) != null){
            try{
                propertyRepository.save(property);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return property;
    }

    public List<Property> allProperties() {
        return propertyRepository.findAll();
    }

    public Property findProperty(int id){
        return propertyRepository.findById(id);
    }

    public Property update(Property updatedProperty) {
        Property property = propertyRepository.findById(updatedProperty.getId());
        if(property != null){
            try {
                propertyRepository.save(updatedProperty);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return property;
    }

    public void delete(int id) {
        Property property = propertyRepository.findById(id);
        if(property != null){
            try {
                propertyRepository.delete(property);
                System.out.println("property id : "+ id +" is deleted successfully");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

}

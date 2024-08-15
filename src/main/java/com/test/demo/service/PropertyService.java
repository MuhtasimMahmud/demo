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

    public Property addProperty(Property property) {
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
}

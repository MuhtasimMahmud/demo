package com.test.demo.service;

import com.test.demo.models.PropertyOwner;
import com.test.demo.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyOwnerService {

    @Autowired
    private OwnerRepository repository;

    public PropertyOwner save(PropertyOwner owner){
        if(repository.findById(owner.getId()) == null){
            try {
                return repository.save(owner);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return null;
    }

    public List<PropertyOwner> allOwners(){
        return repository.findAll();
    }

    public PropertyOwner findOwner(int id){
        PropertyOwner owner = repository.findById(id);
        return owner;
    }


    public PropertyOwner update(PropertyOwner updatedOwner){
        PropertyOwner owner = repository.findById(updatedOwner.getId());
        if(owner != null){
            try{
                repository.save(updatedOwner);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return owner;
    }


    public void delete(int id) {
        PropertyOwner owner = repository.findById(id);
        if(owner != null){
            try {
                repository.delete(owner);
                System.out.println("property id : "+ id +" is deleted successfully");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }


}

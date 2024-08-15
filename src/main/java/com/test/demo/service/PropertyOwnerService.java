package com.test.demo.service;

import com.test.demo.models.PropertyOwner;
import com.test.demo.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PropertyOwner read(int id){
        PropertyOwner owner = repository.findById(id);
        return owner;
    }


    public PropertyOwner update(int id){
        PropertyOwner owner = repository.findById(id);
        if(owner != null){
            owner.setName("updating the new name");
            try{
                repository.save(owner);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        return owner;
    }


}

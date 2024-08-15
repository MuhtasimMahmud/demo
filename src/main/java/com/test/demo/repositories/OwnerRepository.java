package com.test.demo.repositories;

import com.test.demo.models.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<PropertyOwner, Integer> {
    PropertyOwner findById(int id);
}

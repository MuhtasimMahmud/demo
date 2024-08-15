package com.test.demo.repositories;

import com.test.demo.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    Property findById(int id);
}

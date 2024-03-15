package com.mkenlo.rentalmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mkenlo.rentalmanager.models.Image;
import com.mkenlo.rentalmanager.models.Property;

import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    List<Image> findByProperty(Property property);

    Image findById(long id);

}

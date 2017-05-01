package org.fyp.repository;

import org.fyp.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "manufacturer", path = "Manufacturers")
@Transactional
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    Manufacturer findByManufacturerId(Integer manufacturerId);
    Integer deleteByManufacturerId(Integer manufacturerId);
}

package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Manufacturer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 03/04/2017.
 */
@RestController
@RequestMapping(value = "Manufacturers", method= RequestMethod.GET)
public class ManufacturerController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Manufacturer manufacturer) { manufacturerRepo.save(manufacturer);  }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Manufacturer> read()
    {
        return manufacturerRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Manufacturer manufacturer) { manufacturerRepo.save(manufacturer); }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Manufacturer manufacturer)     {  manufacturerRepo.delete(manufacturer);    }

    @RequestMapping(value = "/{manufacturerId}", method = RequestMethod.GET)
    public Manufacturer getManufacturer(@PathVariable("manufacturerId") int manufacturerId) throws ParseException, JsonProcessingException {
        return manufacturerRepo.findByManufacturerId( manufacturerId );
    }


}

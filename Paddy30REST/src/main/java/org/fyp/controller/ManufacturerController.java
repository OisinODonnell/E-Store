package org.fyp.controller;

import org.fyp.model.Manufacturer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by oisin on 03/04/2017.
 */
@RestController
@RequestMapping(value = "Manufacturers", method= RequestMethod.GET)
public class ManufacturerController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Manufacturer manufacturer) { manufacturerRepo.save(manufacturer);  }

    @RequestMapping(value = "/read", method=RequestMethod.GET)
    public Collection<Manufacturer> read()
    {
        return manufacturerRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Manufacturer manufacturer) { manufacturerRepo.save(manufacturer); }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Manufacturer manufacturer)     {  manufacturerRepo.delete(manufacturer);    }

}

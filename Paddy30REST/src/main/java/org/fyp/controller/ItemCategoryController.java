package org.fyp.controller;

import org.fyp.model.ItemCategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by oisin on 03/04/2017.
 */
@RestController
@RequestMapping(value = "ItemCategories", method= RequestMethod.GET)
public class ItemCategoryController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(ItemCategory itemCategory)
    {
        itemCategoryRepo.save(itemCategory);
    }

    @RequestMapping(value = "/read", method=RequestMethod.GET)
    public Collection<ItemCategory> read()
    {
        return itemCategoryRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(ItemCategory itemCategory)
    {
        itemCategoryRepo.save(itemCategory);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(ItemCategory itemCategory) { itemCategoryRepo.delete(itemCategory);    }

}

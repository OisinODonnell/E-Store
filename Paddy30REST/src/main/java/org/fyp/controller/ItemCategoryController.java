package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.ItemCategory;
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
@RequestMapping(value = "ItemCategories", method= RequestMethod.GET)
public class ItemCategoryController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(ItemCategory itemCategory)
    {
        itemCategoryRepo.save(itemCategory);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
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


    @RequestMapping(value = "/delete/{itemCategoryId}", method=RequestMethod.GET)
    public String deleteById(@PathVariable("itemCategoryId") int itemCategoryId) throws ParseException {

        if(itemCategoryRepo.findByItemCategoryId(itemCategoryId)!=null) {
            if (stockItemRepo.findAllByItemCategoryId(itemCategoryId).size() > 0) {
                return "Cannot delete Category : " + itemCategoryId + " when stock exists in this category";
            } else {
                itemCategoryRepo.deleteByItemCategoryId(itemCategoryId);
            }
        } else {
            return "Item Category : " + itemCategoryId + " does not exist";
        }

        if(itemCategoryRepo.findByItemCategoryId(itemCategoryId)==null) {
            return "Item Category (id) " + itemCategoryId + " was deleted.";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/{itemCategoryId}", method = RequestMethod.GET)
    public ItemCategory getItemCategory(@PathVariable("itemCategoryId") int itemCategoryId) throws ParseException, JsonProcessingException {
        return itemCategoryRepo.findByItemCategoryId( itemCategoryId );
    }


}

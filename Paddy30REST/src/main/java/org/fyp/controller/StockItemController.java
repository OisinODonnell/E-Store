package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Account;
import org.fyp.model.StockItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping(value = {"StockItems","StockItem"}, method=RequestMethod.GET)
public class StockItemController extends MainController {

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<StockItem> read()    {
        return stockItemRepo.findAll();
    }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(StockItem stockItem)    {
        stockItemRepo.save(stockItem);
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(StockItem stockItem)    {
        stockItemRepo.save(stockItem);
    }

    // You cannot delete a StockItem. Not designed for that.

    @RequestMapping(value = "/Manufacturer/{manufacturerId}", method = RequestMethod.GET)
    public Collection<StockItem> getStockItemByManufacturerId(@PathVariable("manufacturerId") int manufacturerId)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findAllByManufacturerId( manufacturerId );
    }

    @RequestMapping(value = "/ItemCategory/{itemCategoryId}", method = RequestMethod.GET)
    public Collection<StockItem> getStockItemByItemCategoryId(@PathVariable("itemCategoryId") int itemCategoryId)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findAllByItemCategoryId( itemCategoryId );
    }

    @RequestMapping(value = "/Like/{titleLike}", method = RequestMethod.GET)
    public Collection<StockItem> getStockItem(@PathVariable("titleLike") String titleLike)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findByTitleLikeIgnoreCase( "%" + titleLike + "%" );
    }

    @RequestMapping(value = "/{stockItemId}", method = RequestMethod.GET)
    public StockItem getStockItem(@PathVariable("stockItemId") int stockItemId) throws ParseException, JsonProcessingException {
        return stockItemRepo.findByStockItemId( stockItemId );
    }


    @RequestMapping(value = "/Search/{manufacturerId}/{itemCategoryId}/{titleLike}", method = RequestMethod.GET)
    public ArrayList<StockItem> getStockSearch(@PathVariable("manufacturerId") Integer manufacturerId,
                                               @PathVariable("itemCategoryId")Integer itemCategoryId,
                                               @PathVariable("titleLike")     String  titleLike)
            throws ParseException, JsonProcessingException {

        respMap = new HashMap<>();

        ArrayList<StockItem> stockItems = new ArrayList<>();

        // case no manufacturer ot itemcategory
        if ((manufacturerId == 0) && (itemCategoryId == 0)) {
            stockItems =  stockItemRepo.findAllByTitleLikeIgnoreCase( "%"+titleLike+"%");
        }
        // case no itemcategory
        if ((manufacturerId == 0) && (itemCategoryId > 0)) {
            stockItems =  stockItemRepo.findByItemCategoryIdAndTitleLikeIgnoreCase( itemCategoryId, "%"+titleLike+"%");
        }
        // case no manufacturer
        if ((manufacturerId > 0) && (itemCategoryId == 0)) {
            stockItems =  stockItemRepo.findByManufacturerIdAndTitleLikeIgnoreCase( manufacturerId, "%"+titleLike+"%");
        }
        // all parameters entered
        if ((manufacturerId > 0) && (itemCategoryId > 0)) {
            stockItems =  stockItemRepo.findByManufacturerIdAndItemCategoryIdAndTitleLikeIgnoreCase( manufacturerId, itemCategoryId, "%"+titleLike+"%");
        }

        return stockItems;
    }
}
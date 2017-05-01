package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Account;
import org.fyp.model.StockItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping(value = "/StockItems", method=RequestMethod.GET)
public class StockItemController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(StockItem stockItem)    {
        stockItemRepo.save(stockItem);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<StockItem> read()    {
        return stockItemRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(StockItem stockItem)    {
        stockItemRepo.save(stockItem);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(StockItem stockItem)    {
        stockItemRepo.delete(stockItem);
    }


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

    @RequestMapping(value = "/Like/{titleLIke}", method = RequestMethod.GET)
    public Collection<StockItem> getStockItem(@PathVariable("titleLike") String titleLike)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findByTitleLike( titleLike );
    }

    @RequestMapping(value = "/{stockItemId}", method = RequestMethod.GET)
    public StockItem getStockItem(@PathVariable("stockItemId") int stockItemId) throws ParseException, JsonProcessingException {
        return stockItemRepo.findByStockItemId( stockItemId );
    }


}
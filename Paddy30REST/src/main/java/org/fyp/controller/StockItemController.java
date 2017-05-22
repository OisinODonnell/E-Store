package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.StockItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping(value = {"StockItems","StockItem"}, method=RequestMethod.GET)
public class StockItemController extends MainController {

    @RequestMapping(value = { "", "/", "/read"}, method= RequestMethod.GET)
    public ArrayList<StockItem> read()    {
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

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(StockItem stockItem)    {
        stockItemRepo.delete(stockItem);
    }

    @RequestMapping(value = "/{stockItemId}", method = RequestMethod.GET)
    public StockItem getStockItemById(@PathVariable("stockItemId") int stockItemId)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findByStockItemId( stockItemId );
    }

    @RequestMapping(value = "/Manufacturer/{manufacturerId}", method = RequestMethod.GET)
    public ArrayList<StockItem> getStockItemByManufacturerId(@PathVariable("manufacturerId") int manufacturerId)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findAllByManufacturerId( manufacturerId );
    }

    @RequestMapping(value = "/ItemCategory/{itemCategoryId}", method = RequestMethod.GET)
    public ArrayList<StockItem> getStockItemByItemCategoryId(@PathVariable("itemCategoryId") int itemCategoryId)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findAllByItemCategoryId( itemCategoryId );
    }

    @RequestMapping(value = "/Like/{titleLike}", method = RequestMethod.GET)
    public ArrayList<StockItem> getStockItem(@PathVariable("titleLike") String titleLike)
            throws ParseException, JsonProcessingException {
        return stockItemRepo.findByTitleLikeIgnoreCase( "%"+titleLike+"%" );
    }

    @RequestMapping(value = "/Search/{manufacturerId}/{itemCategoryId}/{titleLike}", method = RequestMethod.GET)
    public ArrayList<StockItem> getStockSearch(@PathVariable("manufacturerId") Integer manufacturerId,
                                                @PathVariable("itemCategoryId")Integer itemCategoryId,
                                                @PathVariable("titleLike")     String  titleLike)
                        throws ParseException, JsonProcessingException {



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

    @RequestMapping(value = "/{stockItemId}/{newStockQty}", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,String>> setNewStockLevel(
            @PathVariable("stockItemId") Integer stockItemId,
            @PathVariable("newStockQty") Integer newStockQty)

            throws ParseException, JsonProcessingException {

        respMap = new HashMap<>();

        // retrieve the stockitem and extract the current stock level
        StockItem stockItem = stockItemRepo.findByStockItemId(stockItemId);
        int newStockLevel = stockItem.getStockLevel() + newStockQty;
        stockItem.setStockLevel(newStockLevel);

        // save the changes
        stockItemRepo.save(stockItem);

        // check that stock was updated
        if (stockItemRepo.findByStockItemId(stockItemId).getStockLevel() == newStockLevel) {
            respMap.put("success","1");
            respMap.put("message","StockItemId [" + stockItemId + "] Stock Level Updated by [" + newStockQty + "]");
        } else {
            respMap.put("success","0");
            respMap.put("message","StockItemId [" + stockItemId + "] could not be updated");
        }
        return new ResponseEntity<>(respMap, httpStatus);
    }
}
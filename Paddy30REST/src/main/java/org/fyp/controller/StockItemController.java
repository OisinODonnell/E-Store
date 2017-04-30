package org.fyp.controller;

import org.fyp.model.StockItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/read", method=RequestMethod.GET)
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



}
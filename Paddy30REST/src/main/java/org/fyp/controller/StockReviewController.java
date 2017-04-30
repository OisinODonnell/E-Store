package org.fyp.controller;

import org.fyp.model.StockReview;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by oisin on 03/04/2017.
 */
@RestController
@RequestMapping(value = "StockReviews", method=RequestMethod.GET)
public class StockReviewController extends MainController {

    @RequestMapping(value = "/create",method=RequestMethod.GET)
    public void create(StockReview stockReview)    {
        stockReviewRepo.save(stockReview);
    }

    @RequestMapping(value = "/read",method=RequestMethod.GET)
    public Collection<StockReview> read()    {
        return stockReviewRepo.findAll();
    }

    @RequestMapping(value = "/update",method=RequestMethod.GET)
    public void update(StockReview stockReview)    { stockReviewRepo.save(stockReview); }

    @RequestMapping(value = "/delete",method=RequestMethod.GET)
    public void delete(StockReview stockReview)    {
        stockReviewRepo.delete(stockReview);
    }
}

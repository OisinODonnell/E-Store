package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.StockReview;
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
@RequestMapping(value = "StockReviews", method=RequestMethod.GET)
public class StockReviewController extends MainController {

    @RequestMapping(value = "/create",method=RequestMethod.GET)
    public void create(StockReview stockReview)    {
        stockReviewRepo.save(stockReview);
    }

    @RequestMapping(value = {"", "/", "/read"},method=RequestMethod.GET)
    public Collection<StockReview> read()    {
        return stockReviewRepo.findAll();
    }

    @RequestMapping(value = "/update",method=RequestMethod.GET)
    public void update(StockReview stockReview)    { stockReviewRepo.save(stockReview); }

    @RequestMapping(value = "/delete",method=RequestMethod.GET)
    public void delete(StockReview stockReview)    {
        stockReviewRepo.delete(stockReview);
    }

    @RequestMapping(value = "/delete/{accountId}/{stockItemId}", method=RequestMethod.GET)
    public String deleteById(@PathVariable("accountId") int accountId, @PathVariable("stockItemId") int stockItemId)
            throws ParseException {

        // check that item exists
        if(stockReviewRepo.findByAccountIdAndStockItemId(accountId, stockItemId)!=null) { // it exists
            // now delete it
            stockReviewRepo.deleteByAccountIdAndStockItemId(accountId, stockItemId);
        } else {
            return "Stock Review with Account Id : " + accountId + " and StockItemId : " + stockItemId + " Does not exist";
        }

        // finally check that its gone

        if(stockReviewRepo.findByAccountIdAndStockItemId(accountId, stockItemId)==null) {
            return "Stock Review with Account Id, " + accountId + ", Stock Item:  " + stockItemId + " was deleted.";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/{accountId, stockItemId}", method = RequestMethod.GET)
    public StockReview getStockReview(  @PathVariable("accountId") int accountId,
                                        @PathVariable("stockItemId") int stockItemId
    ) throws ParseException, JsonProcessingException {
        return stockReviewRepo.findByAccountIdAndStockItemId( accountId, stockItemId );
    }


    @RequestMapping(value = "/StockItem/{stockItemId}", method = RequestMethod.GET)
    public Collection<StockReview> getStockReviewsByStockItemId(  @PathVariable("stockItemId") int stockItemId

    ) throws ParseException, JsonProcessingException {
        return stockReviewRepo.findAllByStockItemId( stockItemId);
    }

    @RequestMapping(value = "/Account/{accountId}", method = RequestMethod.GET)
    public Collection<StockReview> getStockReviewsByAccountId(  @PathVariable("accountId") int accountId

    ) throws ParseException, JsonProcessingException {
        return stockReviewRepo.findAllByAccountId( accountId );

    }
}

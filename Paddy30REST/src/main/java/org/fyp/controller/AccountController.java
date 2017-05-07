package org.fyp.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.*;
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
@RequestMapping("Accounts")
public class AccountController extends MainController{


    @RequestMapping(value = "/loadData", method=RequestMethod.GET)
    public Collection<Account> loadTestData() throws Exception {

        loadData(new Account()     , util.ACCOUNTS       );
        loadData(new Session()     , util.SESSIONS       );
        loadData(new Manufacturer(), util.MANUFACTURERS  );
        loadData(new ItemCategory(), util.ITEM_CATEGORIES);
        loadData(new StockItem()   , util.STOCK_ITEMS    );
        loadData(new StockReview() , util.STOCK_REVIEWS  );
        loadData(new Order()       , util.ORDERS         );
        loadData(new OrderItem()   , util.ORDER_ITEMS    );
        loadData(new Cart()        , util.CARTS          );
        loadData(new CartItem()    , util.CART_ITEMS     );

        return accountRepo.findAll();
    }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Account account)   { accountRepo.save(account);  }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Account> read()
    {
        Collection<Account>  accounts = accountRepo.findAll();

        return accounts;
    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public Account getAccount(  @PathVariable("accountId") int accountId) throws ParseException {
        Account account = new Account();

        account = accountRepo.findByAccountId( accountId );
//        account.setCarts( cartRepo.findAllByAccountId( accountId ));
//        account.setOrders( orderRepo.findAllByAccountId( accountId ));
//        account.setSessions( sessionRepo.findAllByAccountId( accountId ));
//        account.setStockReviews( stockReviewRepo.findAllByAccountId( accountId ));

        return account;
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Account account)
    {
        accountRepo.save(account);
    }

    @RequestMapping(value = "/delete/", method=RequestMethod.GET)
    public void delete(Account account)     {  accountRepo.delete(account);    }

    @RequestMapping(value = "/delete/{accountId}", method=RequestMethod.GET)
    public String deleteById(@PathVariable("accountId") int accountId) throws ParseException {

        if(accountRepo.findByAccountId(accountId)!=null) {
            accountRepo.deleteByAccountId(accountId);
        } else {
            return "AccountID : " + accountId + " does not exist";
        }

        if(accountRepo.findByAccountId(accountId)==null) {
            return "Account " + accountId + " was deleted.";
        } else {
            return null;
        }
    }


}
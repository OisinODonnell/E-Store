package org.fyp.controller;

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
@RequestMapping({"Accounts","Account"})
public class AccountController extends MainController{

//    public final static String URL = "/{1}";

    @RequestMapping(value = { "", "/", "/read"}, method= RequestMethod.GET)
    public Collection<Account> read()    { return accountRepo.findAll();   }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Account account) { accountRepo.save(account);  }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Account account) { accountRepo.save(account);  }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Account account) { accountRepo.delete(account);    }

    @RequestMapping(value = "/delete/{accountId}", method=RequestMethod.GET)
    public void delete(@PathVariable("accountId") Integer accountId)
            throws ParseException, JsonProcessingException {
        int status = accountRepo.deleteAccountByAccountId( accountId );

    }

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public Account getAccount(  @PathVariable("accountId") int accountId) throws ParseException, JsonProcessingException {
        return accountRepo.findByAccountId( accountId );
    }
    @RequestMapping(value = "/username/{email}", method = RequestMethod.GET)
    public Account getAccount(  @PathVariable("email") String email) throws ParseException, JsonProcessingException {
        return accountRepo.findByEmail( email );
    }

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
}
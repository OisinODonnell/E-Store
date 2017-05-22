package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Cart;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping(value = {"Carts","Cart"} , method=RequestMethod.GET)
public class CartController extends MainController {

    @RequestMapping(value = { "", "/", "/read"}, method= RequestMethod.GET)
    public Collection<Cart> read()    {  return cartRepo.findAll();   }

    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Cart cart)
    {
        cartRepo.save(cart);
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Cart cart)
    {
        cartRepo.save(cart);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Cart cart)
    {
        cartRepo.delete(cart);
    }

    @RequestMapping(value = "/Account/{accountId}", method=RequestMethod.GET)
    public Collection<Cart> getCartsByAccountId(@PathVariable("accountId") int accountId)
            throws ParseException, JsonProcessingException {
        return cartRepo.findAllByAccountId( accountId);
    }

    @RequestMapping(value = "/{cartId}", method=RequestMethod.GET)
    public Cart getCartByCartId(@PathVariable("cartId")  int cartId) {
        return cartRepo.findByCartId( cartId);
    }

}
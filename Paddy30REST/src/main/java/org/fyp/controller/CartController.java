package org.fyp.controller;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Account;
import org.fyp.model.Cart;
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
@RequestMapping(value = "Carts", method=RequestMethod.GET)
public class CartController extends MainController {


    @RequestMapping(value = "/create", method= RequestMethod.GET)
    public void create(Cart cart)
    {
        cartRepo.save(cart);
    }

    @RequestMapping(value = "/read", method=RequestMethod.GET)
    public Collection<Cart> read() throws JsonProcessingException {
//        Collection<Cart> carts = cartRepo.findAll();
//        String jsonInString = mapper.writeValueAsString(carts);

        return cartRepo.findAll();
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
    public Collection<Cart> getCartsByAccountId(int accountId) {
        return cartRepo.findAllByAccountId( accountId);
    }

    @RequestMapping(value = "/{cartId}", method=RequestMethod.GET)
    public Cart getCartByCartId(int cartId) {
        return cartRepo.findByCartId( cartId);
    }

}
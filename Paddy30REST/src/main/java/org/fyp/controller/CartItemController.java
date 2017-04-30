package org.fyp.controller;

import org.fyp.model.CartItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by oisin on 03/04/2017.
 */
@RestController
@RequestMapping(value = "CartItems", method= RequestMethod.GET)
public class CartItemController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(CartItem cartItem)
    {
        cartItemRepo.save(cartItem);
    }

    @RequestMapping(value = "/read", method=RequestMethod.GET)
    public Collection<CartItem> read()
    {
        return cartItemRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(CartItem cartItem)
    {
        cartItemRepo.save(cartItem);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(CartItem cartItem)     {  cartItemRepo.delete(cartItem);    }

}

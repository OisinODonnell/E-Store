package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.CartItem;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 03/04/2017.
 */
@RestController
@RequestMapping(value = {"CartItems","CartItem"}, method= RequestMethod.GET)
public class CartItemController extends MainController {

    @RequestMapping(value = { "", "/", "/read"}, method= RequestMethod.GET)
    public Collection<CartItem> read()    { return cartItemRepo.findAll();  }

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(CartItem cartItem)
    {
        cartItemRepo.save(cartItem);
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(CartItem cartItem)
    {
        cartItemRepo.save(cartItem);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(CartItem cartItem)     {  cartItemRepo.delete(cartItem);    }

    @RequestMapping(value = "/Cart/{cartId}", method = RequestMethod.GET)
    public Collection<CartItem> getCartItemsByCartId(@PathVariable("cartId") int cartId

    ) throws ParseException, JsonProcessingException {
        return cartItemRepo.findAllByCartId( cartId );
    }

    @RequestMapping(value = "/StockItem/{stockItemId}", method = RequestMethod.GET)
    public Collection<CartItem> getCartItemsByStockItemId(@PathVariable("stockItemId") int stockItemId

    ) throws ParseException, JsonProcessingException {
        return cartItemRepo.findAllByStockItemId( stockItemId );
    }


    
}

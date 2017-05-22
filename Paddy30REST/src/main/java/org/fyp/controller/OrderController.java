package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Order;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping(value = {"Orders","Order"}, method= RequestMethod.GET)
public class OrderController extends MainController {

    @RequestMapping(value = {"", "/", "read" } , method=RequestMethod.GET)
    public Collection<Order> read() { return orderRepo.findAll();  }

    @RequestMapping(value = "/{orderId}", method=RequestMethod.GET)
    public Order getOrderByOrderId(Integer orderId) {
        return orderRepo.findByOrderId( orderId);
    }

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Order order)
    {
        orderRepo.save(order);
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(Order order)
    {
        orderRepo.save(order);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(Order order)
    {
        orderRepo.delete(order);
    }


    @RequestMapping(value = "/Account/{accountId}", method=RequestMethod.GET)
    public Collection<Order> getOrdersByAccountId( @PathVariable("accountId") int accountId)
            throws ParseException, JsonProcessingException {
        return orderRepo.findAllByAccountId( accountId);
    }



}
package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.Order;
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
@RequestMapping(value = "Orders", method= RequestMethod.GET)
public class OrderController extends MainController {


    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Order> read()
    {
        return orderRepo.findAll();
    }

    @RequestMapping(value = "/{orderId}", method=RequestMethod.GET)
    public Order getOrderByOrderId(@PathVariable int orderId) {
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

    @RequestMapping(value = "/delete/{orderId}", method=RequestMethod.GET)
    public String deleteById(@PathVariable("orderId") int orderId) throws ParseException {

        if(orderRepo.findByOrderId(orderId)!=null) {
            orderRepo.deleteByOrderId(orderId);
        } else {
            return "OrderID : " + orderId + " does not exist";
        }

        if(orderRepo.findByOrderId(orderId)==null) {
            return "OrderID : " + orderId + " was deleted.";
        } else {
            return null;
        }
    }


    @RequestMapping(value = "/Account/{accountId}", method=RequestMethod.GET)
    public Collection<Order> getOrdersByAccountId(@PathVariable int accountId)
            throws ParseException, JsonProcessingException {
        return orderRepo.findAllByAccountId( accountId);
    }

}
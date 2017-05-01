package org.fyp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.fyp.model.OrderItem;
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
@RequestMapping(value = "OrderItems", method= RequestMethod.GET)
public class OrderItemController extends MainController {

    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(OrderItem orderItem)
    {
        orderItemRepo.save(orderItem);
    }

    @RequestMapping(value = "/read", method=RequestMethod.GET)
    public Collection<OrderItem> read()
    {
        return orderItemRepo.findAll();
    }

    @RequestMapping(value = "/update", method=RequestMethod.GET)
    public void update(OrderItem orderItem)
    {
        orderItemRepo.save(orderItem);
    }

    @RequestMapping(value = "/delete", method=RequestMethod.GET)
    public void delete(OrderItem orderItem)     {  orderItemRepo.delete(orderItem);    }

//    @RequestMapping(value = "/Account/{accountId}", method = RequestMethod.GET)
//    public Collection<OrderItem> getOrderItemsByAccountId(@PathVariable("accountId") int accountId
//
//    ) throws ParseException, JsonProcessingException {
//        return orderItemRepo.findAllByAccountId( accountId );
//    }

    @RequestMapping(value = "/Order/{orderId}", method = RequestMethod.GET)
    public Collection<OrderItem> getOrderItemsByOrderId(@PathVariable("orderId") int orderId

    ) throws ParseException, JsonProcessingException {
        return orderItemRepo.findAllByOrderId( orderId );
    }
}

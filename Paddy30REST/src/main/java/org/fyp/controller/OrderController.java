package org.fyp.controller;

import org.fyp.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by oisin on 30/03/2017.
 */
@RestController
@RequestMapping(value = "Orders", method= RequestMethod.GET)
public class OrderController extends MainController {


    public Collection<Order> getOrders(int accountId) {

        Collection<Order> orders = orderRepo.findAllByAccountId(accountId);

        for(Order order:orders) {
            order.setOrderItems( orderItemRepo.findAllByOrderId( order.getOrderId()) );
        }

        return orders;
    }
    @RequestMapping(value = "/create", method=RequestMethod.GET)
    public void create(Order order)
    {
        orderRepo.save(order);
    }

    @RequestMapping(value = {"", "/", "/read"}, method=RequestMethod.GET)
    public Collection<Order> read()
    {
        return orderRepo.findAll();
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
    public Collection<Order> getOrdersByAccountId(int accountId) {
        return orderRepo.findAllByAccountId( accountId);
    }

    @RequestMapping(value = "/{orderId}", method=RequestMethod.GET)
    public Order getOrderByOrderId(int orderId) {
        return orderRepo.findByOrderId( orderId);
    }


}
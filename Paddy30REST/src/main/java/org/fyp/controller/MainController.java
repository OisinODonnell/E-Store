package org.fyp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fyp.model.*;
import org.fyp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public abstract class MainController {

    @Autowired
    AccountRepository accountRepo;
    @Autowired
    CartItemRepository cartItemRepo;
    @Autowired
    CartRepository cartRepo;
    @Autowired
    OrderRepository orderRepo;
    @Autowired
    OrderItemRepository orderItemRepo;
    @Autowired
    ManufacturerRepository manufacturerRepo;
    @Autowired
    ItemCategoryRepository itemCategoryRepo;
    @Autowired
    SessionRepository sessionRepo;
    @Autowired
    StockItemRepository stockItemRepo;
    @Autowired
    StockReviewRepository stockReviewRepo;

    ObjectMapper mapper = new ObjectMapper();


    Util util = new Util(); // singleton

    @SuppressWarnings("unchecked")
    public <E> void loadData(E item, String file) throws Exception {

        // read csv file into an array or arrays
        List<List<String>> records = util.readCSV(file);

        String className = item.getClass().toString();

        // add records to list
        for (List<String> attributes : records)

            switch (className) {
                case "class org.fyp.model.Cart":
                    cartRepo.save(new Cart(attributes));
                    break;
                case "class org.fyp.model.Account":
                    accountRepo.save(new Account(attributes));
                    break;
                case "class org.fyp.model.CartItem":
                    cartItemRepo.save(new CartItem(attributes));
                    break;
                case "class org.fyp.model.Order":
                    orderRepo.save( new Order(attributes));
                    break;
                case "class org.fyp.model.OrderItem":
                    orderItemRepo.save( new OrderItem(attributes));
                    break;
                case "class org.fyp.model.StockItem":
                    stockItemRepo.save( new StockItem(attributes));
                    break;
                case "class org.fyp.model.Manufacturer":
                    manufacturerRepo.save( new Manufacturer(attributes));
                    break;
                case "class org.fyp.model.ItemCategory":
                    itemCategoryRepo.save( new ItemCategory(attributes));
                    break;
                case "class org.fyp.model.Session":
                    sessionRepo.save( new Session(attributes));
                    break;
                case "class org.fyp.model.StockReview":
                    stockReviewRepo.save( new StockReview(attributes));
                    break;
            }

    }

}
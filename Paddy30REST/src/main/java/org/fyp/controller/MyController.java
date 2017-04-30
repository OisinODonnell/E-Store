package org.fyp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oisin on 23/03/2017.
 */
@RestController
@RequestMapping("estore")
public class MyController {

    @RequestMapping("/index")
    public String index()  { return "Hello, %s!"; }

    @RequestMapping("/index2")
    public String index2()
    {
        return "Hello2, %s!";
    }
}
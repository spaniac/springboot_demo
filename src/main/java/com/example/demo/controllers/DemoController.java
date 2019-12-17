package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.services.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private DemoService service;

    @Autowired
    public DemoController(DemoService service){
        this.service = service;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> list(){
        List<Customer> list = service.listAll();
        logger.info(list.toString());
        return list;
    }
}

package com.example.demo.services;

import com.example.demo.models.Customer;
import com.example.demo.models.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);
    private CustomerRepository repository;

    @Autowired
    public DemoService(CustomerRepository repository){
        this.repository = repository;
    }

    public List<Customer> listAll(){
        List<Customer> list = StreamSupport.stream((this.repository.findAll().spliterator()), false).collect(Collectors.toList());
        logger.info(list.toString());
        return list;
    }
}

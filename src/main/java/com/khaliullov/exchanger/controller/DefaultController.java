package com.khaliullov.exchanger.controller;


import com.khaliullov.exchanger.model.RequestEntity;
import com.khaliullov.exchanger.service.ExchangeService;
import com.khaliullov.exchanger.service.StatService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController {

    @Autowired
    ExchangeService service;

    @Autowired
    StatService statService;


    @GetMapping("/exchanger")
    public Object getApi(@RequestParam(name = "user_id") Long userId, @RequestParam String to, @RequestParam String from, @RequestParam Double amount){
        return service.getApiData(userId, to, from, amount);
    }

    @GetMapping("/stats/exchanges")
    public List<RequestEntity> getAllExchanges(){
        return statService.getAllRequest();
    }

    @GetMapping(value = "/stats/exchanges", params = {"sum", "currency"})
    public List<RequestEntity> getExchangesWhereSumMoreThen(@RequestParam Double sum, @RequestParam String currency){
        return statService.getAllRequestWhereSumMoreThen(sum, currency);
    }

    @GetMapping("/stats/users")
    public List<Long> getCustomers(){
        return statService.getCustomerList();
    }

    @GetMapping("/stats/users/{id}")
    public List<RequestEntity> getExchangesByUSerId(@PathVariable Long id){
        return statService.getRequestByCustomerId(id);
    }




}

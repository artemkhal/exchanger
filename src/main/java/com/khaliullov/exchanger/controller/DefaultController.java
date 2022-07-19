package com.khaliullov.exchanger.controller;


import com.khaliullov.exchanger.model.RequestEntity;
import com.khaliullov.exchanger.service.ExchangeService;
import com.khaliullov.exchanger.service.StatServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class DefaultController {

    @Autowired
    ExchangeService service;

    @Autowired
    StatServiceImpl statService;


    @GetMapping("/exchanger")
    public Object getApiData(@RequestParam(name = "user_id") Long userId, @RequestParam String to, @RequestParam String from, @RequestParam Double amount){
        return service.getApiData(userId, to, from, amount);
    }

    @GetMapping("/stats/exchanges")
    public List<RequestEntity> getAllExchanges(){
        return statService.getAllRequest();
    }

    @GetMapping(value = "/stats/exchanges", params = {"base_sum", "currency"})
    public List<RequestEntity> getExchangesWhereBaseSumMoreThen(@RequestParam(name = "base_sum") Double baseSum, @RequestParam String currency){
        return statService.getAllRequestWhereAmountMoreThen(baseSum, currency);
    }

    @GetMapping("/stats/users")
    public Set<Long> getCustomers(){
        return statService.getCustomerList();
    }

    @GetMapping("/stats/users/{id}")
    public List<RequestEntity> getExchangesByUserId(@PathVariable Long id){
        return statService.getRequestByCustomerId(id);
    }

    @GetMapping("/stats/exchange_rating")
    public ResponseEntity<String> getPopularCurrency(){
        return statService.getPopularCurrency();
    }

}

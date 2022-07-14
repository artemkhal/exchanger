package com.khaliullov.exchanger.service;

import com.khaliullov.exchanger.model.RequestEntity;
import com.khaliullov.exchanger.repository.CustomerRepository;
import com.khaliullov.exchanger.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatService {

    @Autowired
    private ExchangeService exchangeService;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public List<RequestEntity> getAllRequest(){
        List<RequestEntity> entityList = new ArrayList<>();
        requestRepository.findAll().forEach(entityList::add);
        return entityList;
    }


    public List<RequestEntity> getAllRequestWhereSumMoreThen(Double sum, String currency) {
        List<RequestEntity> entityList = new ArrayList<>();
        requestRepository.findAll().forEach(requestEntity -> {
            if (requestEntity.getCurrencyTo() != null
                    && requestEntity.getCurrencyTo().equals(currency)
                    && sum <= requestEntity.getResult()){entityList.add(requestEntity);}
        });
        return entityList;
    }

    public List<Long> getCustomerList(){
        List<Long> customerList = new ArrayList<>();


        customerRepository.findAll().forEach(customer -> {
            customerList.add(customer.getId());
        });

        return customerList;
    }

    public List<RequestEntity> getRequestByCustomerId(Long id) {
        List<RequestEntity> list = new ArrayList<>();
        return customerRepository.findById(id).get().getRequestEntityList();
    }
}

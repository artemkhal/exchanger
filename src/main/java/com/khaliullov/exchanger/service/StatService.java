package com.khaliullov.exchanger.service;

import com.khaliullov.exchanger.model.RequestEntity;

import java.util.List;


public interface StatService {
    List<RequestEntity> getAllRequest();
    List<RequestEntity> getAllRequestWhereAmountMoreThen(Double sum, String currency);
    List<RequestEntity> getRequestByCustomerId(Long id);

}

package com.khaliullov.exchanger.service;

import com.khaliullov.exchanger.model.RequestEntity;
import com.khaliullov.exchanger.repository.RequestRepository;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class StatServiceImpl implements StatService{

    Logger logger = LoggerFactory.getLogger(StatServiceImpl.class);

    @Autowired
    RequestRepository requestRepository;

    @Override
    public List<RequestEntity> getAllRequest() {
        List<RequestEntity> entityList = new ArrayList<>();
        requestRepository.findAll().forEach(requestEntity -> entityList.add(requestEntity));
        return entityList;
    }

    @Override
    public List<RequestEntity> getAllRequestWhereAmountMoreThen(Double sum, String currency) {
        List<RequestEntity> entityList = new ArrayList<>();
        requestRepository.findAll().forEach(requestEntity -> {
            if (!requestEntity.getCurrencyFrom().isEmpty()
                    && requestEntity.getCurrencyFrom().equals(currency)
                    && sum <= requestEntity.getResult()){entityList.add(requestEntity);}
        });
        return entityList;
    }


    public Set<Long> getCustomerList() {
        Set<Long> list = new HashSet<>();
        requestRepository.findAll().forEach(requestEntity -> list.add(requestEntity.getUserId()));
        return list;
    }

    @Override
    public List<RequestEntity> getRequestByCustomerId(Long id) {
        List<RequestEntity> list = new ArrayList<>();
        requestRepository.findAll().forEach(requestEntity -> {
            if (requestEntity.getUserId().equals(id)){
                list.add(requestEntity);
            }
        });
        return list;
    }

    public ResponseEntity<String> getPopularCurrency(){
        Map<String,Integer> map = new HashMap<>();
        Integer defaultNum = 1;
        requestRepository.findAll().forEach(requestEntity -> {
            String key = requestEntity.getCurrencyFrom() + " to " + requestEntity.getCurrencyTo();
            if (map.containsKey(key)){
                map.replace(key, map.get(key).intValue() + 1);
            }else {map.put(key, defaultNum);}
        });

        JSONObject jo = new JSONObject();
        map.forEach((string, integer) -> {
            jo.put(string, integer);
        });
        return new ResponseEntity<>(jo.toString(), HttpStatus.OK);
    }



//    private RequestEntity changeForView(RequestEntity entity){
//        var request = new RequestEntity(
//                entity.getId(),
//                entity.getCurrencyTo(),
//                entity.getCurrencyFrom(),
//                entity.getAmount(),
//                entity.getResult()
//        );
//        return request;
//    }
}

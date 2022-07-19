package com.khaliullov.exchanger.service;

import com.khaliullov.exchanger.model.RequestEntity;
import com.khaliullov.exchanger.repository.RequestRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {

    static final Logger log = LoggerFactory.getLogger(ExchangeService.class);

    @Value("${apikey}")
    private String apikey;

    @Autowired
    private RequestRepository requestRepository;


    public ResponseEntity<String> getApiData(Long userId, String to, String from, Double amount){

        try{
            String uri = "https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("apikey", apikey);

            HttpEntity httpRequest = new HttpEntity(headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    httpRequest,
                    String.class
            );

            RequestEntity entity = new RequestEntity(to, from, amount, Double.parseDouble(getResultFromJson(response)), userId);
            requestRepository.save(entity);
            return response;
        }catch (HttpStatusCodeException e) {
            log.info("Bad Request from user id " + userId + "\n" + e.getResponseBodyAsString());
            return new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }
    }

    private String getResultFromJson(ResponseEntity<String> response){

        JSONObject object = new JSONObject(response.getBody());
        return object.get("result").toString();
    }

}

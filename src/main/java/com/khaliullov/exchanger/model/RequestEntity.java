package com.khaliullov.exchanger.model;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "currency_to")
    private String currencyTo;

    @Column(name = "currency_from")
    private String currencyFrom;

    private Double amount;

    private Double result;

    @Column(name = "user_id")
    private Long userId;

    public RequestEntity() {
    }

    public RequestEntity(int id, String currencyTo, String currencyFrom, Double amount, Double result, Long userId) {
        this.id = id;
        this.currencyTo = currencyTo;
        this.currencyFrom = currencyFrom;
        this.amount = amount;
        this.result = result;
        this.userId = userId;
    }

    public RequestEntity(String currencyTo, String currencyFrom, Double amount, Double result, Long userId) {
        this.currencyTo = currencyTo;
        this.currencyFrom = currencyFrom;
        this.amount = amount;
        this.result = result;
        this.userId = userId;
    }

    public RequestEntity(int id, String currencyTo, String currencyFrom, Double amount, Double result) {
        this.id = id;
        this.currencyTo = currencyTo;
        this.currencyFrom = currencyFrom;
        this.amount = amount;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", currencyTo='" + currencyTo + '\'' +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", amount=" + amount +
                ", result=" + result +
                ", userId=" + userId +
                '}';
    }
}

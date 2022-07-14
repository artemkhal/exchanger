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

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;


    public RequestEntity() {
    }

    public RequestEntity(String currencyTo, String currencyFrom, Double amount, Double result, Customer customer) {
        this.currencyTo = currencyTo;
        this.currencyFrom = currencyFrom;
        this.amount = amount;
        this.result = result;
//        this.customer = customer;
    }

    public RequestEntity(int id, String currencyTo, String currencyFrom, Double amount, Double result) {
        this.id = id;
        this.currencyTo = currencyTo;
        this.currencyFrom = currencyFrom;
        this.amount = amount;
        this.result = result;
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

//    public Customer getCustomer() {
//        return customer;
//    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", currencyTo='" + currencyTo + '\'' +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", amount=" + amount +
                ", result=" + result +
//                ", customer=" + customer +
                '}';
    }
}

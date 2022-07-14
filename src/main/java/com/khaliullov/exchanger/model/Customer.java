package com.khaliullov.exchanger.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Long id;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<RequestEntity> requestEntityList;

    public Customer() {
    }

    public Customer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RequestEntity> getRequestEntityList() {
        return requestEntityList;
    }

    public void setRequestEntityList(List<RequestEntity> requestEntityList) {
        this.requestEntityList = requestEntityList;
    }
}

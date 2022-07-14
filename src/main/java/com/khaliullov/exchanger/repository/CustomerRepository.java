package com.khaliullov.exchanger.repository;

import com.khaliullov.exchanger.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

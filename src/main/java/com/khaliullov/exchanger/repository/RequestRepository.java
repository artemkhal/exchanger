package com.khaliullov.exchanger.repository;

import com.khaliullov.exchanger.model.RequestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<RequestEntity, Integer> {

}

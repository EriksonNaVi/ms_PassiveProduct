package com.api.rest.springboot.webflux.passiveproduct.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.springboot.webflux.passiveproduct.model.PassiveProduct;

import reactor.core.publisher.Flux;

@Repository
public interface PassiveProductRepository extends ReactiveMongoRepository<PassiveProduct, String> {
  
  Flux<PassiveProduct> findByIdClient(String idClient);

}

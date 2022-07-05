package com.api.rest.springboot.webflux.passiveproduct.service;

import com.api.rest.springboot.webflux.passiveproduct.model.PassiveProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PassiveProductService {
  
  public Flux<PassiveProduct> findAll();

  public Mono<PassiveProduct> findById(String id);

  public Mono<PassiveProduct> save(PassiveProduct active);

  public Mono<PassiveProduct> update(PassiveProduct active);

  public Mono<Void> delete(PassiveProduct active);
  
  public Flux<PassiveProduct> byIdClient(String idClient);
  
}

package com.api.rest.springboot.webflux.passiveproduct.service;

import com.api.rest.springboot.webflux.passiveproduct.model.PassiveProduct;
import com.api.rest.springboot.webflux.passiveproduct.util.Crud;

import reactor.core.publisher.Flux;

public interface PassiveProductService extends Crud<PassiveProduct, String>{
  
  public Flux<PassiveProduct> byIdClient(String idClient);
  
}

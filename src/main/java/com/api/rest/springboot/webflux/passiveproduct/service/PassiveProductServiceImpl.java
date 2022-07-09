package com.api.rest.springboot.webflux.passiveproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.springboot.webflux.passiveproduct.model.PassiveProduct;
import com.api.rest.springboot.webflux.passiveproduct.repository.PassiveProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveProductServiceImpl implements PassiveProductService {
  
  @Autowired
  private PassiveProductRepository passivesRepository;

  @Override
  public Flux<PassiveProduct> findAll() {
    
    return passivesRepository.findAll();
  }

  @Override
  public Mono<PassiveProduct> findById(String id) {
    
    return passivesRepository.findById(id);
  }

  @Override
  public Mono<PassiveProduct> save(PassiveProduct passive) {
    
    return passivesRepository.save(passive);
  }

  @Override
  public Mono<Void> delete(PassiveProduct passive) {
    
    return passivesRepository.delete(passive);
  }

  @Override
  public Flux<PassiveProduct> byIdClient(String idClient) {
    
    return passivesRepository.findByIdClient(idClient);
  }

}

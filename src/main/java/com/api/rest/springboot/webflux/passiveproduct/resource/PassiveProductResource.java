package com.api.rest.springboot.webflux.passiveproduct.resource;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.springboot.webflux.passiveproduct.dto.PassiveProductDto;
import com.api.rest.springboot.webflux.passiveproduct.model.PassiveProduct;
import com.api.rest.springboot.webflux.passiveproduct.service.PassiveProductService;
import com.api.rest.springboot.webflux.passiveproduct.util.MapperUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveProductResource extends MapperUtil {

  @Autowired
  PassiveProductService passiveProductService;

  public Flux<PassiveProductDto> findAll() {
    return passiveProductService.findAll().map(x -> map(x, PassiveProductDto.class));
  }

  public Mono<PassiveProductDto> create(PassiveProductDto passiveProductDto) {
    PassiveProduct passiveProduct = map(passiveProductDto, PassiveProduct.class);
    passiveProduct.setId(new ObjectId().toString());
    Mono<PassiveProduct> entity = passiveProductService.save(passiveProduct);
    return entity.map(x -> map(x, PassiveProductDto.class));
  }

  public Mono<PassiveProductDto> findById(String id) {
    return passiveProductService.findById(id).switchIfEmpty(Mono.error(new Exception()))
        .map(x -> map(x, PassiveProductDto.class));
  }

  public Mono<PassiveProductDto> update(PassiveProductDto passiveProductDto, String id) {

    return passiveProductService.findById(id).switchIfEmpty(Mono.error(new Exception())).flatMap(x -> {

      x.setTypeAccount(passiveProductDto.getTypeAccount());
      x.setAccountNumber(passiveProductDto.getAccountNumber());
      x.setStatus(passiveProductDto.getStatus());
      x.setIdClient(passiveProductDto.getIdClient());

      return passiveProductService.save(x).map(y -> map(y, PassiveProductDto.class));
    });

  }

  public Mono<Void> delete(String id) {
    return passiveProductService.findById(id).switchIfEmpty(Mono.error(new Exception()))
        .flatMap(x -> passiveProductService.delete(x));
  }
  
  public Flux<PassiveProductDto> listByIdClient(String idClient) {
    return passiveProductService.byIdClient(idClient).switchIfEmpty(Mono.error(new Exception()))
        .map(x -> map(x, PassiveProductDto.class));
  }

}

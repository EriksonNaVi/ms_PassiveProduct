package com.api.rest.springboot.webflux.passiveproduct.controller;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.passiveproduct.dto.PassiveProductDto;
import com.api.rest.springboot.webflux.passiveproduct.resource.PassiveProductResource;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passive")
public class PassiveProductController {
  
  private static final Logger logger = LoggerFactory.getLogger(PassiveProductController.class);
  
  @Autowired
  private PassiveProductResource passiveProductResource;
  
  @GetMapping
  public Flux<PassiveProductDto> findAll(){
    return passiveProductResource.findAll();
  }
  
  @PostMapping
  public Mono<PassiveProductDto> createPassive(@Valid @RequestBody PassiveProductDto passiveProductDto){
      return passiveProductResource.create(passiveProductDto);
  }
  
  @GetMapping("/{id}")
  public Mono<PassiveProductDto> listById(@PathVariable String id){
    return passiveProductResource.findById(id);
  }
  
  @PutMapping("/{id}")
  public Mono<PassiveProductDto> update(@RequestBody PassiveProductDto passiveProductDto, @PathVariable String id){
    return passiveProductResource.update(passiveProductDto, id);
  }
  
  @DeleteMapping("/{id}")
  public Mono<Void> remove(@PathVariable String id){
    return passiveProductResource.delete(id);
  }
  
  @GetMapping("/clientPassive/{idClient}")
  public Flux<PassiveProductDto> listByIdClient(@PathVariable("idClient") String idClient) {
    return passiveProductResource.listByIdClient(idClient);
  }

}

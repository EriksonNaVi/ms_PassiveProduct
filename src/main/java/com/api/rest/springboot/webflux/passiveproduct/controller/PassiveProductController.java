package com.api.rest.springboot.webflux.passiveproduct.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.springboot.webflux.passiveproduct.model.PassiveProduct;
import com.api.rest.springboot.webflux.passiveproduct.service.PassiveProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passive")
public class PassiveProductController {
  
  @Autowired
  private PassiveProductService passivesService;
  
  @GetMapping
  public Flux<PassiveProduct> toList(){
    return passivesService.findAll();
  }
  
  @PostMapping
  public Mono<PassiveProduct> register(@Valid @RequestBody PassiveProduct passive){
      return passivesService.save(passive);
  }
  
  @GetMapping("/{id}")
  public Mono<ResponseEntity<PassiveProduct>> listById(@PathVariable String id){
    return passivesService.findById(id).map(c -> ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .body(c))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  @PutMapping("/{id}")
  public Mono<ResponseEntity<PassiveProduct>> edit(@RequestBody PassiveProduct passive, @PathVariable String id) {
    return passivesService.findById(id).flatMap(c -> {
      c.setTypeAccount(passive.getTypeAccount());
      c.setAccountNumber(passive.getAccountNumber());
      c.setStatus(passive.getStatus());
      c.setIdClient(passive.getIdClient());
      
      return passivesService.update(c);
    }).map(c -> ResponseEntity.created(URI.create("/api/passive/".concat(c.getId())))
        .contentType(MediaType.APPLICATION_JSON_UTF8).body(c)).defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  @GetMapping("/clientPassive/{idClient}")
  public Flux<PassiveProduct> listByIdClient(@PathVariable("idClient") String idClient){
    return passivesService.byIdClient(idClient);
  }

}

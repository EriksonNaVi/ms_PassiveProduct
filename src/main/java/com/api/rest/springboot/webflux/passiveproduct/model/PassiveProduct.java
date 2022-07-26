package com.api.rest.springboot.webflux.passiveproduct.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "passive_product")
public class PassiveProduct {

  @Id
  private String id;
  
  private String typeAccount;
  
  private String accountNumber;
  
  private String status;
  
  private Float amount;
  
  private String idClient;
}

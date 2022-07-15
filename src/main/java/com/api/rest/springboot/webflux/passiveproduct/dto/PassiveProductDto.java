package com.api.rest.springboot.webflux.passiveproduct.dto;

import lombok.Data;

@Data
public class PassiveProductDto {
  
  private String id;
  private String typeAccount;
  private String accountNumber;
  private String status;
  private String idClient;

}

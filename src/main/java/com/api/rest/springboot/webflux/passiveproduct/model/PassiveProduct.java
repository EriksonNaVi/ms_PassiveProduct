package com.api.rest.springboot.webflux.passiveproduct.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.api.rest.springboot.webflux.passiveproduct.util.ValidationConstants;

import lombok.Data;

@Data
@Document(collection = "passive_product")
public class PassiveProduct {

  @Id
  private String id;
  
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String typeAccount;
  
  @NotNull(message = ValidationConstants.NOT_NULL)
  @Size(min = 13 , max = 14, message = ValidationConstants.SIZE_MIN_MAX)
  private String accountNumber;
  
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  @Size(min = 1)
  private String status;
  
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String idClient;
}

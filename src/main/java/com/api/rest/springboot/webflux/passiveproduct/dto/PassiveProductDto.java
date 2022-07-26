package com.api.rest.springboot.webflux.passiveproduct.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.api.rest.springboot.webflux.passiveproduct.util.ValidationConstants;

import lombok.Data;

@Data
public class PassiveProductDto {
  
  private String id;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String typeAccount;
  @NotNull(message = ValidationConstants.NOT_NULL)
  @Size(min = 13 , max = 14, message = ValidationConstants.SIZE_MIN_MAX)
  private String accountNumber;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String status;
  @NotNull(message = ValidationConstants.NOT_NULL)
  @Min(0)
  private Float amount;
  @NotEmpty(message = ValidationConstants.NOT_EMPTY)
  private String idClient;

}

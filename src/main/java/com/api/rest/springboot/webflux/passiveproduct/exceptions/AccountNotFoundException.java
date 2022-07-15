package com.api.rest.springboot.webflux.passiveproduct.exceptions;

public class AccountNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private static final String MESSAGE = "Account not found";

  public AccountNotFoundException() {
    super(MESSAGE);
  }
}

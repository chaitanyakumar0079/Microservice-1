package com.pk.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.pk.model.customer.Customer;

public class ApiResponse {

  private String status;

  private String message;

  @JsonInclude(value = Include.NON_NULL)
  private String errorType;

  private Customer customer;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }



  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getErrorType() {
    return errorType;
  }

  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ApiErrorResponse [status=");
    builder.append(status);
    builder.append(", message=");
    builder.append(message);
    builder.append(", errorType=");
    builder.append(errorType);
    builder.append("]");
    return builder.toString();
  }

}

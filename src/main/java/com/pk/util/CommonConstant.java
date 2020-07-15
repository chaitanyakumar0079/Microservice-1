package com.pk.util;

public enum CommonConstant {
  TYPE("success", "error");

  private String success;

  private String error;

  private CommonConstant(String success, String error) {
    this.success = success;
    this.error = error;
  }

  public String getSuccess() {
    return success;
  }

  public String getError() {
    return error;
  }


}

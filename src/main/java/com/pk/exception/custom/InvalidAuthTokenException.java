package com.pk.exception.custom;

public class InvalidAuthTokenException extends RuntimeException {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private String msg;

  public InvalidAuthTokenException(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }



}

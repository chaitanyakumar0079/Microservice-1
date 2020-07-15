package com.pk.exception.controlleradvice;


import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pk.response.ApiResponse;
import com.pk.util.CommonConstant;

@RestControllerAdvice
public class ExceptionController {
  Logger logger = LoggerFactory.getLogger(ExceptionController.class);



  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse> validationExceptions(MethodArgumentNotValidException ex) {
    ApiResponse apiErrorResp = new ApiResponse();
    List<String> list = new ArrayList<>();
    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      list.add(fieldError.getField() + ":" + fieldError.getDefaultMessage());
    }
    apiErrorResp.setStatus(CommonConstant.TYPE.getError());
    apiErrorResp.setMessage("Validation Failed:" + list);
    apiErrorResp.setErrorType("MethodArgumentNotValidException");
    logger.info("Response Body:", apiErrorResp);
    return new ResponseEntity<ApiResponse>(apiErrorResp, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(value = KafkaException.class)
  public ResponseEntity<ApiResponse> kafkaExceptions(KafkaException ex) {
    ApiResponse apiErrorResp = new ApiResponse();
    apiErrorResp.setStatus(CommonConstant.TYPE.getError());
    apiErrorResp.setMessage("Kafka Publishing Failed:" + ex.getLocalizedMessage());
    apiErrorResp.setErrorType("KafkaException");
    logger.info("Response Body:", apiErrorResp);
    return new ResponseEntity<ApiResponse>(apiErrorResp, HttpStatus.INTERNAL_SERVER_ERROR);
  }


}

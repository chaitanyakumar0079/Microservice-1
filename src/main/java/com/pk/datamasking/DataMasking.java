package com.pk.datamasking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.pk.kafaproducer.service.KafkaProducer;
import com.pk.model.customer.Customer;

@Service
public class DataMasking {
  Logger logger = LoggerFactory.getLogger(DataMasking.class);
  public Customer maskData(Customer cust) {
    logger.info("Request Body {}", cust);
    Customer customer=new Customer();
    BeanUtils.copyProperties(cust, customer);
     String number=customer.getCustomerNumber() .replaceAll("\\d(?=(?:\\D*\\d){0,4}\\D*$)", "*");
      customer.setCustomerNumber(number);
      String email =customer.getEmail();
      customer.setEmail(maskingForEmail(email));
      String date=customer.getBirthDate();
      customer.setBirthDate(maskingForDate(date));
      logger.info("Response Body {}", cust);
      return customer;
  }
  
  public String maskingForEmail(String data){
    String s="";
    char[] result=data.toCharArray();
    for(int i=0;i<result.length;i++) {
      if(i<4) {
        result[i]='*';
        s=s+result[i];
      }
      else {
        s=s+result[i];
      }
    }
   return s;
 }
  
  public String maskingForDate(String date ) {
  
    String maskedDate="";
    char[] result=date.toCharArray();
    for(int i=0;i<result.length;i++) {
      if(i<result.length-5 && result[i]!='-' ) {
        result[i]='*';
        maskedDate=maskedDate+result[i];
      }
      else {
        maskedDate=maskedDate+result[i];
      }
    }
    return maskedDate;
  
 }
}   
    



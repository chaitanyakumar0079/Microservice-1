package com.pk.kafaproducer.service;

import org.apache.kafka.common.KafkaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.pk.controller.CustomerContoller;
import com.pk.model.customer.Customer;

@Service
public class KafkaProducer {
  Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

  private KafkaTemplate<String, Object> template;

  private static final String TOPIC = "customer";

  public KafkaProducer(KafkaTemplate<String, Object> template) {
    this.template = template;
  }

  public String sendMessage(Customer customer) throws KafkaException {
    logger.info("Request Body {}", customer);
    try {
      if (customer != null) {
        
        template.send(TOPIC, customer);
      } else {
        throw new KafkaException();
      }

    } catch (KafkaException ex) {
      logger.error("Error Message:",ex);
      throw ex;

    }
    return "Data Published SuccessFully";
  }

}

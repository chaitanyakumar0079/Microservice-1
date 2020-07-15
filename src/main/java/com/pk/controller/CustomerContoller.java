package com.pk.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pk.datamasking.DataMasking;
import com.pk.kafaproducer.service.KafkaProducer;
import com.pk.model.customer.Customer;
import com.pk.response.ApiResponse;
import com.pk.util.CommonConstant;

@RestController
public class CustomerContoller {
	Logger logger = LoggerFactory.getLogger(CustomerContoller.class);

	@Autowired
	private KafkaProducer producer;

	@Autowired
	private DataMasking masking;

	public CustomerContoller(KafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping("/customer")
	public ResponseEntity<ApiResponse> publishCustomerDetails(@Valid @RequestBody Customer customer) {
		Customer cust = masking.maskData(customer);
		logger.info("Request Body {}", cust);
		String msg = producer.sendMessage(customer);
		ApiResponse response = new ApiResponse();
		response.setStatus(CommonConstant.TYPE.getSuccess());
		response.setMessage(msg);
		logger.info("Response Body {}", msg);

		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

}

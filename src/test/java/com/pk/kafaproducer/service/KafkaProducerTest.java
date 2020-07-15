package com.pk.kafaproducer.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import org.apache.kafka.common.KafkaException;
import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import com.pk.model.address.CustomerAddress;
import com.pk.model.customer.Customer;
import scala.util.control.Exception;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class KafkaProducerTest {

	@InjectMocks
	private KafkaProducer producer;

	@Mock
	private KafkaTemplate<String, Object> template;
	Customer cust = null;

	@BeforeEach
	public void setUp() {
		CustomerAddress address = new CustomerAddress();
		address.setAddressLine1("Hyd");
		address.setAddressLine2("Hyd");
		address.setPostalCode("50001");
		address.setStreet("Hitech");
		cust = new Customer();
		cust.setCustomerNumber("C081615");
		cust.setFirstName("chaitanya");
		cust.setLastName("kumar");
		cust.setEmail("chaitanya@gmail.com");
		cust.setCountry("India");
		cust.setCountryCode("IN");
		cust.setAddress(address);
	}

	@Test
	public void testSendMessage() {
		String message = "Data Published SuccessFully";
		String msg = producer.sendMessage(cust);
		assertEquals(msg, message);
	}
	
	@Test
	public void testSendMessageForError() {
	 Mockito.doThrow(new KafkaException()).when(template).send(Matchers.anyString(),Matchers.any());
	 KafkaException exception = assertThrows(
        KafkaException.class,
         () -> producer.sendMessage(null));
	
	}


}

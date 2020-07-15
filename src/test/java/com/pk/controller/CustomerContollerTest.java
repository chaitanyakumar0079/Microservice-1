package com.pk.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pk.datamasking.DataMasking;
import com.pk.kafaproducer.service.KafkaProducer;
import com.pk.model.address.CustomerAddress;
import com.pk.model.customer.Customer;
import io.micrometer.core.ipc.http.HttpSender.Response;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerContoller.class)
@AutoConfigureMockMvc(addFilters = false)
class CustomerContollerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserDetailsService service;

  @MockBean
  private KafkaProducer producer;

  @MockBean
  private DataMasking masking;

  @Autowired
  private ObjectMapper objectMapper;

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
  public void testSaveCustomerInfo() throws JsonProcessingException, Exception {
    boolean flag = true;
    when(producer.sendMessage(Matchers.any(Customer.class)))
        .thenReturn("Data Published SuccessFully");
    mockMvc
        .perform(post("/customer").content(objectMapper.writeValueAsString(cust))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().json("{'message':'Data Published SuccessFully'}"));;
  }

  @Test
  public void testInvalidCustomerInfo() throws JsonProcessingException, Exception {
    boolean flag = true;
    cust.setCustomerNumber("819615");
    when(producer.sendMessage(Matchers.any(Customer.class)))
        .thenReturn("Data Published SuccessFully");
    mockMvc.perform(post("/customer").content(objectMapper.writeValueAsString(cust))
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());

  }
}

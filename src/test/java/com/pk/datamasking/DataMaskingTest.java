package com.pk.datamasking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pk.model.address.CustomerAddress;
import com.pk.model.customer.Customer;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class DataMaskingTest {
  
  @InjectMocks
  private DataMasking masking;
  
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
    cust.setBirthDate("26-05-1996");
    cust.setCountry("India");
    cust.setCountryCode("IN");
    cust.setAddress(address);
  }

  @Test
  public void maskData() {
    Customer customer=masking.maskData(cust);
    assertNotNull(customer);
  }

  
}

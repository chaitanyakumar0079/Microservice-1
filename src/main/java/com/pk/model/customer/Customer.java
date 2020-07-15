
package com.pk.model.customer;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pk.model.address.CustomerAddress;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-07-06T11:59:22.813Z")

public class Customer {
  @JsonProperty("customerNumber")
  @Pattern(regexp = "[C][0-9]*")
  @NotEmpty
  @Length(max = 10)
  private String customerNumber = null;

  @JsonProperty("firstName")
  @Length(min = 4, max = 50)
  private String firstName = null;

  @JsonProperty("lastName")
  @Length(min = 4, max = 50)
  private String lastName = null;

  @JsonProperty("birthDate")
  @Pattern(regexp = "[0-9]{1,2}-[0-9]{2}-[0-9]{4}", message = "date should be in  dd-mm-yyyy")
  private String birthDate = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("countryCode")
  @Length(min = 2, max = 2, message = "country code should have 2 charecters")
  private String countryCode = null;

  @JsonProperty("mobileNumber")
  @Pattern(regexp = "^[\\d]{8,20}$",
      message = "Mobilee Number should be digits only. Size between 8, 20.")
  private String mobileNumber = null;

  @JsonProperty("email")
  @NotBlank(message = "Email Required")
  @Email(message = "Invalid Email")
  private String email = null;


  @JsonProperty("customeStatus")
  private String customeStatus = null;

  @JsonProperty("address")
  private CustomerAddress address = null;

  public Customer customerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
    return this;
  }

  /**
   * Get customerNumber
   * 
   * @return customerNumber
   **/


  public String getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * 
   * @return firstName
   **/


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * 
   * @return lastName
   **/



  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Customer birthDate(String birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * 
   * @return birthDate
   **/


  @Valid

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public Customer country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * 
   * @return country
   **/



  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Customer countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * 
   * @return countryCode
   **/


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public Customer mobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  /**
   * Get mobileNumber
   * 
   * @return mobileNumber
   **/


  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * 
   * @return email
   **/


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer customeStatus(String customeStatus) {
    this.customeStatus = customeStatus;
    return this;
  }

  /**
   * Order Status
   * 
   * @return customeStatus
   **/

  public String getCustomeStatus() {
    return customeStatus;
  }

  public void setCustomeStatus(String customeStatus) {
    this.customeStatus = customeStatus;
  }

  public Customer address(CustomerAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * 
   * @return address
   **/


  @Valid

  public CustomerAddress getAddress() {
    return address;
  }

  public void setAddress(CustomerAddress address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerNumber, customer.customerNumber)
        && Objects.equals(this.firstName, customer.firstName)
        && Objects.equals(this.lastName, customer.lastName)
        && Objects.equals(this.birthDate, customer.birthDate)
        && Objects.equals(this.country, customer.country)
        && Objects.equals(this.countryCode, customer.countryCode)
        && Objects.equals(this.mobileNumber, customer.mobileNumber)
        && Objects.equals(this.email, customer.email)
        && Objects.equals(this.customeStatus, customer.customeStatus)
        && Objects.equals(this.address, customer.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerNumber, firstName, lastName, birthDate, country, countryCode,
        mobileNumber, email, customeStatus, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");

    sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customeStatus: ").append(toIndentedString(customeStatus)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


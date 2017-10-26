package com.niit.model;
import java.io.Serializable;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class User implements Serializable
{
    private static final long serialversion =1L;
     
   @Id
   
   private String UserName;
   private String MobileNumber;
   private String Address;
   private String Password;
   private String Role;
   private String City;
   private String EmailId;
   private boolean Enabled;

   public String getMobileNumber() {
	return MobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	MobileNumber = mobileNumber;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public boolean isEnabled() {
	return Enabled;
}
public void setEnabled(boolean enabled) {
	Enabled = enabled;
}
}
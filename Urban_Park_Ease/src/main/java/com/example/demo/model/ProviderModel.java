package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProviderModel {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
    private Long providerId;
	String providerName;
	String address;
	int slotCapacity;
	String mobile;
	
	public Long getProviderId() {
		return providerId;
	}
	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSlotCapacity() {
		return slotCapacity;
	}
	public void setSlotCapacity(int slotCapacity) {
		this.slotCapacity = slotCapacity;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	

}

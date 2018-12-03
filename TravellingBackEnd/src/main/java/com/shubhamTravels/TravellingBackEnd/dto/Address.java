package com.shubhamTravels.TravellingBackEnd.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotBlank(message="Please enter your address")
	@Column(name="Address_Line_One")
	private String addresslineOne;
	@Column(name="Address_Line_Two")
	private String addresslineTwo;
	@NotBlank(message="Please enter your City Name")
	@ManyToOne
	@JoinColumn(name="City_Id")
	private City city;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddresslineOne() {
		return addresslineOne;
	}
	public void setAddresslineOne(String addresslineOne) {
		this.addresslineOne = addresslineOne;
	}
	public String getAddresslineTwo() {
		return addresslineTwo;
	}
	public void setAddresslineTwo(String addresslineTwo) {
		this.addresslineTwo = addresslineTwo;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addresslineOne=" + addresslineOne + ", addresslineTwo=" + addresslineTwo
				+ ", city=" + city + "]";
	}
}

package com.shubhamTravels.TravellingBackEnd.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="City_Id")
	private int city_id;
	@Column(name="City_Name")
	private String city_name;
	@Column(name="State_Name")
	private String state_name;
	@Column(name="Pincode")
	private int pincode;
	@Column(name="is_active")
	private boolean active=true;
	// This field contain particular city Pickup and Drop points
	@OneToMany(mappedBy="city",cascade=CascadeType.PERSIST)
	@JsonIgnore
	private List<Address> Our_Points;
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public List<Address> getOur_Points() {
		return Our_Points;
	}
	public void setOur_Points(List<Address> our_Points) {
		Our_Points = our_Points;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_name=" + city_name + ", state_name=" + state_name + ", pincode="
				+ pincode + ", active=" + active + ", Our_Points=" + Our_Points + "]";
	}
	
}

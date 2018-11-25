package com.shubhamTravels.TravellingBackEnd.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplier_id;
	@Column(name="supplier_name")
	private String name;
	@Column(name="Contact_Number")
	private String contact_number;
	@Column(name="Email")
	private String email;
	@Column(name="Address")
	private String address;
	@OneToMany(mappedBy="supplier")
	private List<Vehicle> vehicleslist;
	
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Vehicle> getVehicleslist() {
		return vehicleslist;
	}
	public void setVehicleslist(List<Vehicle> vehicleslist) {
		this.vehicleslist = vehicleslist;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", name=" + name + ", contact_number=" + contact_number
				+ ", email=" + email + ", address=" + address + ", vehicleslist=" + vehicleslist + "]";
	}
	
}

package com.shubhamTravels.TravellingBackEnd.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="Vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@NotBlank(message = "Please enter the Vehicle Name")
	private String name;
	@NotBlank(message = "Please enter the Vehicle Brand")
	private String brand;
	@JsonIgnore
	@NotBlank(message = "Vehicle Description is requried")
	private String description;
	@Min(value=1,message="Price/Km can't be less than 1")
	@Column(name="charges_perKm")
	private Double rentCharge;
	@Column(name="is_active")
	private boolean active=true;
	private int category_id;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Supplier supplier;
	private int purchases;
	private int views;
	private String fuelType;
	@Min(value=1,message="Mileage can't be less than 1")
	@Column(name="mileage")
	private int mileage;
	@Column(name="is_booked")
	private boolean booked=false;
	@Column(name="registered_with_us_on")
	private Date registeredDate;
	@Column(name="seater")
	private String numberOfSeater;
	
	// For generating unique code for every vehicle 
	public Vehicle() {
		this.code = "VEH-"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}


	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRentCharge() {
		return rentCharge;
	}

	public void setRentCharge(Double rentCharge) {
		this.rentCharge = rentCharge;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getNumberOfSeater() {
		return numberOfSeater;
	}

	public void setNumberOfSeater(String numberOfSeater) {
		this.numberOfSeater = numberOfSeater;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getCategory_id() {
		return category_id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", rentCharge=" + rentCharge + ", active=" + active + ", category_id=" + category_id
				+ ", supplier=" + supplier + ", purchases=" + purchases + ", views=" + views + ", fuelType=" + fuelType
				+ ", mileage=" + mileage + ", booked=" + booked + ", registeredDate=" + registeredDate
				+ ", numberOfSeater=" + numberOfSeater + "]";
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	
}

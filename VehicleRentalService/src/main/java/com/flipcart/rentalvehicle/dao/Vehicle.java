package com.flipcart.rentalvehicle.dao;

public abstract class Vehicle {
	protected String vehicleId;
	protected double pricePerHour;
	protected boolean isBooked;
	
	public Vehicle(String vehicleId, double pricePerHour) {
		this.vehicleId = vehicleId;
		this.pricePerHour = pricePerHour;
		this.isBooked = false;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public boolean isBooked() {
		return isBooked;
	}
	
	public void bookVehicle() {
		this.isBooked = true;
	}
	
	public void releaseVehicle() {
		this.isBooked = false;
	}
	
	@Override
    public String toString() {
        return "\"" + this.getClass().getSimpleName() + "\"" + " for Rs." + pricePerHour;
    }
}

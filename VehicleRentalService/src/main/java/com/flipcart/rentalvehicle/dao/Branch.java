package com.flipcart.rentalvehicle.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Branch {
	private String branchName;
	private Map<String, List<Vehicle>> vehicleInventory;
	
	public Branch(String branchName) {
		this.branchName = branchName;
		vehicleInventory = new HashMap<>();
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void addVehicle(String vehicleType, Vehicle vehicle) {
		vehicleInventory.putIfAbsent(vehicleType, new ArrayList<>());
		vehicleInventory.get(vehicleType).add(vehicle);
	}
	
	public List<Vehicle> getAvailableVehicles(String vehicleType) {
		return vehicleInventory.getOrDefault(vehicleType, Collections.emptyList());
	}
	
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> allVehicles = new ArrayList<>();
		for(List<Vehicle> vehicles : vehicleInventory.values()) {
			allVehicles.addAll(vehicles);
		}
		return allVehicles;
	}
	
	@Override
	public String toString() {
		return "Branch: " + branchName;
	}
}

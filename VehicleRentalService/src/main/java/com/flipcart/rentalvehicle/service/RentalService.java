package com.flipcart.rentalvehicle.service;

import java.util.ArrayList;
import java.util.List;

import com.flipcart.rentalvehicle.dao.Branch;
import com.flipcart.rentalvehicle.dao.Vehicle;

public class RentalService {
	private List<Branch> branches;
	
	public RentalService() {
		branches = new ArrayList<>();
	}
	
	public void addBranch(Branch branch) {
		branches.add(branch);
		System.out.println("Added branch: " + branch.getBranchName());
	}
	
	public void addVehicleToBranch(String branchName, String vehicleType, Vehicle vehicle) {
		for(Branch branch : branches) {
			if(branch.getBranchName().equalsIgnoreCase(branchName)) {
				branch.addVehicle(vehicleType, vehicle);
				System.out.println("Added " + vehicle + " to branch: " + branchName);
				return;
			}
		}
		System.out.println("Branch not found");
	}
	
	public Vehicle bookVehicle(String vrhicleType, int hours) {
		Vehicle chosenVehicle = null;
		for(Branch branch : branches) {
			List<Vehicle> availableVehicles = branch.getAvailableVehicles(vrhicleType);
			for(Vehicle vehicle : availableVehicles) {
				if(!vehicle.isBooked() && (chosenVehicle == null || vehicle.getPricePerHour() < chosenVehicle.getPricePerHour())) {
					chosenVehicle = vehicle;
				}
			}
			if(chosenVehicle != null) {
				chosenVehicle.bookVehicle();
				System.out.println("Booked " + chosenVehicle + " for " + hours + " hours from branch: " + branch.getBranchName());
                return chosenVehicle;
			}
		}
		System.out.println("No availabel vehicles found for booking");
		return null;
	}
	
	public void releaseVehicle(String vehicleId) {
		for(Branch branch : branches) {
			for(Vehicle vehicle : branch.getAllVehicles()) {
				if(vehicle.getVehicleId().equalsIgnoreCase(vehicleId) && vehicle.isBooked()) {
					vehicle.releaseVehicle();
					System.out.println("Released vehicle: " + vehicle);
                    return;
				}
			}
		}
		System.out.println("Vehicle not found or not booked.");
	}
	
	public void systemView() {
		for(Branch branch : branches) {
			System.out.println("\nBranch: " + branch.getBranchName());
			for(Vehicle vehicle : branch.getAllVehicles()) {
				String status = vehicle.isBooked() ? "Booked" : "Available";
				System.out.println(vehicle + " - Ststus " + status);
			}
		}
	}
}

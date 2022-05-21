package com.data;

import java.util.List;

import com.model.Vehicle;

public interface VehicleDAO {
	
public List<Vehicle> getVehicles() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addVehicle(Vehicle vehicle) throws Exception;
	
	public void deleteVehicle(int id) throws Exception;
	
	public List<Vehicle> searchVehicles(String vehicleNumber) throws Exception;
	
	public Vehicle getVehicle(int id) throws Exception;
	
	public void updateVehicle(Vehicle vehicle) throws Exception;

}

package Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.model.Vehicle;
import Main.repository.VehicleRepository;

@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    // Add new vehicle
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    
    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    
    // Get vehicle by number
    public Vehicle getVehicleByNumber(String vehicleNumber) {
        return vehicleRepository.findByVehicleNumber(vehicleNumber);
    }
    
    // Get vehicle by ID
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }
    
    // Update vehicle status (AVAILABLE, ON_TRIP, MAINTENANCE)
    public Vehicle updateVehicleStatus(String vehicleNumber, String status) {
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicle != null) {
            vehicle.setStatus(status);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }
    
    // Update vehicle location
    public Vehicle updateVehicleLocation(String vehicleNumber, String location) {
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicle != null) {
            vehicle.setCurrentLocation(location);
            return vehicleRepository.save(vehicle);
        }
        return null;
    }
    
    // Update complete vehicle details
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    
    // Get available vehicles (status = AVAILABLE)
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByStatus("AVAILABLE");
    }
    
    // Get vehicles by status
    public List<Vehicle> getVehiclesByStatus(String status) {
        return vehicleRepository.findByStatus(status);
    }
    
    // Delete vehicle by ID
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
    
    // Delete vehicle by number
    public void deleteVehicleByNumber(String vehicleNumber) {
        Vehicle vehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicle != null) {
            vehicleRepository.delete(vehicle);
        }
    }
    
    // Count total vehicles
    public long getTotalVehicles() {
        return vehicleRepository.count();
    }
    
    // Count available vehicles
    public long getAvailableVehiclesCount() {
        return vehicleRepository.findByStatus("AVAILABLE").size();
    }
    
    // Check if vehicle exists
    public boolean vehicleExists(String vehicleNumber) {
        return vehicleRepository.findByVehicleNumber(vehicleNumber) != null;
    }
}
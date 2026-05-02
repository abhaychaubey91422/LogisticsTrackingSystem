package Main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String vehicleNumber;
    
    private String driverName;
    private String driverPhone;
    private String status; // AVAILABLE, ON_TRIP, MAINTENANCE
    private String currentLocation;
    
    public Vehicle() {
        this.status = "AVAILABLE";
    }
    
    // Getters
    public Long getId() { return id; }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getDriverName() { return driverName; }
    public String getDriverPhone() { return driverPhone; }
    public String getStatus() { return status; }
    public String getCurrentLocation() { return currentLocation; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public void setDriverPhone(String driverPhone) { this.driverPhone = driverPhone; }
    public void setStatus(String status) { this.status = status; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
}
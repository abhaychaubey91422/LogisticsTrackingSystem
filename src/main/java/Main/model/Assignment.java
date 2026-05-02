package Main.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String shipmentId;
    private String vehicleNumber;
    private LocalDate assignedDate;
    private String status; // ACTIVE, COMPLETED
    
    public Assignment() {
        this.assignedDate = LocalDate.now();
        this.status = "ACTIVE";
    }
    
    // Getters
    public Long getId() { return id; }
    public String getShipmentId() { return shipmentId; }
    public String getVehicleNumber() { return vehicleNumber; }
    public LocalDate getAssignedDate() { return assignedDate; }
    public String getStatus() { return status; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setShipmentId(String shipmentId) { this.shipmentId = shipmentId; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public void setAssignedDate(LocalDate assignedDate) { this.assignedDate = assignedDate; }
    public void setStatus(String status) { this.status = status; }
}

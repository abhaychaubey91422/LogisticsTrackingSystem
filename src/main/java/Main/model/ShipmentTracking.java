package Main.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipment_tracking")
public class ShipmentTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String shipmentId;
    private String location;
    private String status;
    private String remarks;
    private LocalDateTime timestamp;
    
    public ShipmentTracking() {
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters
    public Long getId() { return id; }
    public String getShipmentId() { return shipmentId; }
    public String getLocation() { return location; }
    public String getStatus() { return status; }
    public String getRemarks() { return remarks; }
    public LocalDateTime getTimestamp() { return timestamp; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setShipmentId(String shipmentId) { this.shipmentId = shipmentId; }
    public void setLocation(String location) { this.location = location; }
    public void setStatus(String status) { this.status = status; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
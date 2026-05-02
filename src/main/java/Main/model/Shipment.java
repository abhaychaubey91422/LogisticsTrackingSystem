package Main.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String shipmentId;
    
    private String customerName;
    private String origin;
    private String destination;
    private String status;
    private LocalDateTime createdDate;
    
    public Shipment() {
        this.createdDate = LocalDateTime.now();
        this.status = "PENDING";
    }
    
    // Getters
    public Long getId() { return id; }
    public String getShipmentId() { return shipmentId; }
    public String getCustomerName() { return customerName; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    
    // Setters
    public void setId(Long id) { this.id = id; }
    public void setShipmentId(String shipmentId) { this.shipmentId = shipmentId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setOrigin(String origin) { this.origin = origin; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setStatus(String status) { this.status = status; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
}
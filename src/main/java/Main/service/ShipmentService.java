package Main.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.model.Shipment;
import Main.repository.ShipmentRepository;

@Service
public class ShipmentService {
    
    @Autowired
    private ShipmentRepository shipmentRepository;
    
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
    
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
    
    public Shipment getShipmentById(String shipmentId) {
        return shipmentRepository.findByShipmentId(shipmentId);
    }
    
    public Shipment updateShipmentStatus(String shipmentId, String status) {
        Shipment shipment = shipmentRepository.findByShipmentId(shipmentId);
        if (shipment != null) {
            shipment.setStatus(status);
            return shipmentRepository.save(shipment);
        }
        return null;
    }
    
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
    
    public List<Shipment> getShipmentsByStatus(String status) {
        return shipmentRepository.findByStatus(status);
    }
}

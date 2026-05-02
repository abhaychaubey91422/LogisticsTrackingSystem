package Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.model.ShipmentTracking;
import Main.repository.TrackingRepository;

@Service
public class TrackingService {
    
    @Autowired
    private TrackingRepository trackingRepository;
    
    public ShipmentTracking addTracking(ShipmentTracking tracking) {
        return trackingRepository.save(tracking);
    }
    
    public List<ShipmentTracking> getTrackingHistory(String shipmentId) {
        return trackingRepository.findByShipmentIdOrderByTimestampDesc(shipmentId);
    }
}
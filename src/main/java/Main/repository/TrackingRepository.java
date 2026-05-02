package Main.repository;

import Main.model.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrackingRepository extends JpaRepository<ShipmentTracking, Long> {
    List<ShipmentTracking> findByShipmentIdOrderByTimestampDesc(String shipmentId);
}

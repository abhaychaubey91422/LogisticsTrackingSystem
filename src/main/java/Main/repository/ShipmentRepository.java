package Main.repository;

import Main.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Shipment findByShipmentId(String shipmentId);
    List<Shipment> findByStatus(String status);
    List<Shipment> findByCustomerNameContaining(String customerName);
}
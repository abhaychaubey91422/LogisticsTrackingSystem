package Main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Main.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Assignment findByShipmentId(String shipmentId);
    List<Assignment> findByVehicleNumber(String vehicleNumber);
    List<Assignment> findByStatus(String status);
}
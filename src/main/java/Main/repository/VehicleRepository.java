package Main.repository;

import Main.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByVehicleNumber(String vehicleNumber);
    List<Vehicle> findByStatus(String status);
}

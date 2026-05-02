package Main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.model.Assignment;
import Main.repository.AssignmentRepository;

@Service
public class AssignmentService {
    
    @Autowired
    private AssignmentRepository assignmentRepository;
    
    public Assignment assignVehicle(Assignment assignment) {
        assignment.setStatus("ACTIVE");
        return assignmentRepository.save(assignment);
    }
    
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }
    
    public Assignment getAssignmentByShipmentId(String shipmentId) {
        return assignmentRepository.findByShipmentId(shipmentId);
    }
    
    public void completeAssignment(Long id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment != null) {
            assignment.setStatus("COMPLETED");
            assignmentRepository.save(assignment);
        }
    }
    
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
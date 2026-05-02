package Main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Main.model.Assignment;
import Main.service.AssignmentService;
import Main.service.ShipmentService;
import Main.service.VehicleService;

@Controller
public class AssignmentController {
    
    @Autowired
    private AssignmentService assignmentService;
    
    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private ShipmentService shipmentService;
    
    @GetMapping("/assignments")
    public String viewAssignments(Model model) {
        model.addAttribute("assignments", assignmentService.getAllAssignments());
        return "assignments";
    }
    
    @GetMapping("/assignForm")
    public String assignForm(Model model) {
        model.addAttribute("assignment", new Assignment());
        model.addAttribute("vehicles", vehicleService.getAvailableVehicles());
        model.addAttribute("shipments", shipmentService.getAllShipments());
        return "assign_form";
    }
    
    @PostMapping("/assignVehicle")
    public String assignVehicle(@ModelAttribute Assignment assignment) {
        assignmentService.assignVehicle(assignment);
        
        // Update vehicle status to ON_TRIP
        vehicleService.updateVehicleStatus(assignment.getVehicleNumber(), "ON_TRIP");
        
        // Update shipment status to IN_TRANSIT
        shipmentService.updateShipmentStatus(assignment.getShipmentId(), "IN_TRANSIT");
        
        return "redirect:/assignments";
    }
    
    @GetMapping("/completeAssignment/{id}")
    public String completeAssignment(@PathVariable Long id) {
        Assignment assignment = assignmentService.getAssignmentByShipmentId(
            assignmentService.getAllAssignments().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get().getShipmentId()
        );
        
        if (assignment != null) {
            // Update vehicle status back to AVAILABLE
            vehicleService.updateVehicleStatus(assignment.getVehicleNumber(), "AVAILABLE");
            
            // Update shipment status to DELIVERED
            shipmentService.updateShipmentStatus(assignment.getShipmentId(), "DELIVERED");
            
            // Complete assignment
            assignmentService.completeAssignment(id);
        }
        
        return "redirect:/assignments";
    }
    
    @GetMapping("/deleteAssignment/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return "redirect:/assignments";
    }
}
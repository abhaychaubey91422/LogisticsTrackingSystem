package Main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Main.model.Vehicle;
import Main.service.VehicleService;

@Controller
public class VehicleController {
    
    @Autowired
    private VehicleService vehicleService;
    
    @GetMapping("/vehicles")
    public String viewVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicles";
    }
    
    @GetMapping("/addVehicleForm")
    public String addVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "add_vehicle";
    }
    
    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return "redirect:/vehicles";
    }
    
    @GetMapping("/updateVehicleStatus/{vehicleNumber}")
    public String updateVehicleStatusForm(@PathVariable String vehicleNumber, Model model) {
        model.addAttribute("vehicle", vehicleService.getVehicleByNumber(vehicleNumber));
        return "update_vehicle_status";
    }
    
    @PostMapping("/updateVehicleStatus")
    public String updateVehicleStatus(@RequestParam String vehicleNumber, @RequestParam String status) {
        vehicleService.updateVehicleStatus(vehicleNumber, status);
        return "redirect:/vehicles";
    }
}
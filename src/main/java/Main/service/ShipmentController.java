package Main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Main.model.Shipment;

@Controller
public class ShipmentController {
    
    @Autowired
    private ShipmentService shipmentService;
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("shipments", shipmentService.getAllShipments());
        model.addAttribute("totalShipments", shipmentService.getAllShipments().size());
        return "dashboard";
    }
    
    @GetMapping("/addShipmentForm")
    public String addShipmentForm(Model model) {
        model.addAttribute("shipment", new Shipment());
        return "add_shipment";
    }
    
    @PostMapping("/addShipment")
    public String addShipment(@ModelAttribute Shipment shipment) {
        shipmentService.createShipment(shipment);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/updateStatus/{shipmentId}")
    public String updateStatusForm(@PathVariable String shipmentId, Model model) {
        model.addAttribute("shipment", shipmentService.getShipmentById(shipmentId));
        return "update_status";
    }
    
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam String shipmentId, @RequestParam String status) {
        shipmentService.updateShipmentStatus(shipmentId, status);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/deleteShipment/{id}")
    public String deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
        return "redirect:/dashboard";
    }
}

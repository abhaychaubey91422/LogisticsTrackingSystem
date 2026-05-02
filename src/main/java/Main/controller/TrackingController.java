package Main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Main.model.ShipmentTracking;
import Main.service.ShipmentService;
import Main.service.TrackingService;

@Controller
public class TrackingController {
    
    @Autowired
    private TrackingService trackingService;
    
    @Autowired
    private ShipmentService shipmentService;
    
    @GetMapping("/track")
    public String trackForm() {
        return "track";
    }
    
    @PostMapping("/trackShipment")
    public String trackShipment(@RequestParam String shipmentId, Model model) {
        model.addAttribute("shipment", shipmentService.getShipmentById(shipmentId));
        model.addAttribute("trackingHistory", trackingService.getTrackingHistory(shipmentId));
        return "track_result";
    }
    
    @GetMapping("/addTrackingForm/{shipmentId}")
    public String addTrackingForm(@PathVariable String shipmentId, Model model) {
        ShipmentTracking tracking = new ShipmentTracking();
        tracking.setShipmentId(shipmentId);
        model.addAttribute("tracking", tracking);
        model.addAttribute("shipmentId", shipmentId);
        return "add_tracking";
    }
    
    @PostMapping("/addTracking")
    public String addTracking(@ModelAttribute ShipmentTracking tracking) {
        trackingService.addTracking(tracking);
        return "redirect:/dashboard";
    }
}
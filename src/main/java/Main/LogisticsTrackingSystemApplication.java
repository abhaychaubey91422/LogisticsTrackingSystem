package Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogisticsTrackingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsTrackingSystemApplication.class, args);
        System.out.println("========================================");
        System.out.println("🚚 Logistics Tracking System Started!");
        System.out.println("📱 URL: http://localhost:8080");
        System.out.println("========================================");
    }
}
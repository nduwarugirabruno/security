package io.links.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/example")
public class ExampleController {

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasAuthority('ADMIN_SUDO')")
    public ResponseEntity<String> adminDashboard() {
        try {
            return ResponseEntity.ok("Admin Dashboard");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/pools/manage")
    @PreAuthorize("hasAnyAuthority('ADMIN_SUDO_POOLS', 'ADMIN_POOL')")
    public ResponseEntity<String> managePools() {
        return ResponseEntity.ok("Manage Pools");
    }

    @GetMapping("/transactions/manage")
    @PreAuthorize("hasAuthority('MANAGER_TRANSACTIONS')")
    public ResponseEntity<String> manageTransactions() {
        return ResponseEntity.ok("Manage Transactions");
    }

    @GetMapping("/client/manage")
    @PreAuthorize("hasAuthority('SERVICE_CLIENT')")
    public ResponseEntity<String> manageClients() {
        return ResponseEntity.ok("Manage Clients");
    }
}
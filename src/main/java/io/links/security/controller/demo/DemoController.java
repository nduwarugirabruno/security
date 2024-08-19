package io.links.security.controller.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/demo")
public class DemoController {

    @GetMapping()
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/user/test")
    @PreAuthorize("hasAuthority('SERVICE_CLIENT')")
    public ResponseEntity<String> testUserRoute() {
        return ResponseEntity.ok("Access granted for USER_SUDO");
    }

    @GetMapping("/admin/test")
    @PreAuthorize("hasAuthority('ADMIN_SUDO')")
    public ResponseEntity<String> testAdminRoute() {
        return ResponseEntity.ok("Access granted for ADMIN_SUDO");
    }
}

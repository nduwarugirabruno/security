/*
 * Copyright (c) 2025, Bruno NDUWARUGIRA.
 */

package io.links.security.controller.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/admin")
@PreAuthorize("hasRole('ADMIN_SUDO')")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAuthority('admin::read')")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("ADMIN::GET controller");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin::update')")
    public ResponseEntity<String> put() {
        return ResponseEntity.ok().body("ADMIN::PUT controller");
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin::delete')")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok().body("ADMIN::DELETE controller");
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin::create')")
    public ResponseEntity<String> post() {
        return ResponseEntity.ok().body("ADMIN::POST controller");
    }

    @PatchMapping
    @PreAuthorize("hasAuthority('admin::read')")
    public ResponseEntity<String> patch() {
        return ResponseEntity.ok().body("ADMIN::PATCH controller");
    }

    @GetMapping("get/options")
    @PreAuthorize("hasAuthority('admin.sudo::options')")
    public ResponseEntity<String> options() {
        return ResponseEntity.ok().body("ADMIN_SUDO::OPTIONS controller");
    }

    @GetMapping("get/trace")
    @PreAuthorize("hasAuthority('admin.sudo::trace')")
    public ResponseEntity<String> trace() {
        return ResponseEntity.ok().body("ADMIN_SUDO::TRACE controller");
    }

}

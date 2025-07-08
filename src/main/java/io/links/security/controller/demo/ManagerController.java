/*
 * Copyright (c) 2025, Bruno NDUWARUGIRA.
 */

package io.links.security.controller.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('MANAGER_USERS')")
@RestController
@RequestMapping(path = "api/v1/manager")
public class ManagerController {

    @PreAuthorize("hasAuthority('manager.users::read')")
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok().body("MANAGER_USERS::GET controller");
    }

    @PreAuthorize("hasAuthority('manager.users::update')")
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok().body("MANAGER_USERS::PUT controller");
    }

    @PreAuthorize("hasAuthority('manager.users::delete')")
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok().body("MANAGER_USERS::DELETE controller");
    }

    @PreAuthorize("hasAuthority('manager.users::create')")
    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok().body("MANAGER_USERS::POST controller");
    }

    @PreAuthorize("hasAuthority('manager.users::read')")
    @PatchMapping
    public ResponseEntity<String> patch() {
        return ResponseEntity.ok().body("MANAGER_USERS::PATCH controller");
    }

}

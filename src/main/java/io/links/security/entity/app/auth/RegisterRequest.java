package io.links.security.entity.app.auth;

import io.links.security.entity.app.enums.Role;

public record RegisterRequest(String firstName, String lastName, String email, String password, Role role) {
}

package io.links.security.service;

import io.links.security.entity.app.auth.AuthenticationRequest;
import io.links.security.entity.app.auth.AuthenticationResponse;
import io.links.security.entity.app.auth.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}

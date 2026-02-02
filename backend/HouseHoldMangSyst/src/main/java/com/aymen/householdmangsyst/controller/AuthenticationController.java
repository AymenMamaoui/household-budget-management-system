package com.aymen.householdmangsyst.controller;

import com.aymen.householdmangsyst.auth.AuthenticationRequest;
import com.aymen.householdmangsyst.auth.AuthenticationResponse;
import com.aymen.householdmangsyst.auth.AuthenticationService;
import com.aymen.householdmangsyst.auth.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Pour que la requete venant du front ne soit pas bloqué
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

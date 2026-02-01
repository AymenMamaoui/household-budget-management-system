package com.aymen.householdmangsyst.auth;

import com.aymen.householdmangsyst.entity.Role;

public record RegisterRequest(
        String firstname,
        String lastname,
        String email,
        String password,
        Role role
) {}

package com.aymen.householdmangsyst.controller;

import com.aymen.householdmangsyst.entity.User;
import com.aymen.householdmangsyst.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/household")
public class HouseholdController {

    private final UserRepository userRepository;

    public HouseholdController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Voir tous les membres d'une famille
    @GetMapping("/members/{householdId}")
    public List<User> getMembers(@PathVariable String householdId) {
        return userRepository.findByHouseholdId(householdId);
    }

    // Rejoindre un foyer existant ou créer un nouveau groupe
    @PostMapping("/join/{userId}/{householdId}")
    public ResponseEntity<User> joinHousehold(
            @PathVariable Long userId,
            @PathVariable String householdId
    ) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setHouseholdId(householdId);
                    return ResponseEntity.ok(userRepository.save(user));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
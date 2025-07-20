package com.gameflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        boolean created = userService.register(user);
        if (created) {
            return ResponseEntity.ok().body("{\"message\": \"User registered successfully\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"message\": \"Username already exists\"}");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean success = userService.authenticate(user);
        if (success) {
            return ResponseEntity.ok().body("{\"message\": \"Login successful\"}");
        } else {
            return ResponseEntity.status(401).body("{\"message\": \"Invalid username or password\"}");
        }
    }
}
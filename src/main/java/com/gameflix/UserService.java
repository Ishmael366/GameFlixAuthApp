package com.gameflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public boolean register(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            return false;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return true;
    }

    public boolean authenticate(User user) {
        return repository.findByUsername(user.getUsername())
                .map(existing -> encoder.matches(user.getPassword(), existing.getPassword()))
                .orElse(false);
    }
}
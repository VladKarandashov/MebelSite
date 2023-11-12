package com.example.mebelsite.controller;

import com.example.mebelsite.model.dto.LoginRequest;
import com.example.mebelsite.model.entity.UserEntity;
import com.example.mebelsite.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthRestController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody LoginRequest loginRequest) {
        if (userRepository.existsByLogin(loginRequest.getLogin())) return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        var user = userRepository.save(new UserEntity(
                loginRequest.getLogin(),
                passwordEncoder.encode(loginRequest.getPassword())
        ));
        return ResponseEntity.ok(user.getLogin());
    }
}
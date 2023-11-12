package com.example.mebelsite.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.mebelsite.model.entity.UserEntity.ROLE_USER;

@Slf4j
@RestController
public class CheckLoginController {

    @GetMapping("/checkLogin")
    public ResponseEntity<Boolean> checkLogin() {
        var context = SecurityContextHolder.getContext();
        var authentication = context.getAuthentication();
        var authorities = authentication.getAuthorities();
        var isAuthenticated = authorities.contains(ROLE_USER);
        return ResponseEntity.ok(isAuthenticated);
    }
}

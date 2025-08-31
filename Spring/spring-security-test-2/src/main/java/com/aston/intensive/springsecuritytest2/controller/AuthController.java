package com.aston.intensive.springsecuritytest2.controller;

import com.aston.intensive.springsecuritytest2.dto.AuthDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/auth")
    public ResponseEntity<String> auth(@RequestBody AuthDTO authDTO) {
        return null;
    }
}

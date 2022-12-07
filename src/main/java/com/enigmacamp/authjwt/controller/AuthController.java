package com.enigmacamp.authjwt.controller;

import com.enigmacamp.authjwt.model.UserCredential;
import com.enigmacamp.authjwt.service.IAuthService;
import com.enigmacamp.authjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlMappings.AUTH_URL)
public class AuthController {
    @Autowired
    IAuthService authService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity authValidate(@RequestBody UserCredential user){
       String token = authService.login(user);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/token-validate")
    public ResponseEntity tokenValidate(@RequestParam String token) {
        if (authService.validaterToken(token)) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity doLogout(@RequestParam String token){
        if (authService.logout(token)) {
            return ResponseEntity.ok("Logout success");
        }else {
            return ResponseEntity.ok("Token not found");
        }
    }
}

package com.somu.LoginSystem.Controller;


import com.somu.LoginSystem.Service.LoginRequest;
import com.somu.LoginSystem.Service.UserService;
import com.somu.LoginSystem.Repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63343")
public class AuthController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest request) {
        String result = userService.register(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        try {
            String token = userService.login(request.getEmail(), request.getPassword());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            Map<String, String> error = new HashMap<>();
            error.put("error", ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }

    @PostMapping("/hello")
    public String hello(){
        return "Hello from the Secured Endpoint";
    }
}
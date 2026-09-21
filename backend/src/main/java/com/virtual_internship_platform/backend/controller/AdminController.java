package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Admin;
import com.virtual_internship_platform.backend.security.JwtService;
import com.virtual_internship_platform.backend.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final JwtService jwtService;

    public AdminController(AdminService adminService,
                           JwtService jwtService) {
        this.adminService = adminService;
        this.jwtService = jwtService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(
            @Valid @RequestBody Admin admin) {

        return ResponseEntity.ok(
                adminService.createAdmin(admin)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginAdmin(
            @RequestBody LoginRequest loginRequest) {

        Admin admin = adminService.loginAdmin(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        String token = jwtService.generateToken(admin.getEmail());

        return ResponseEntity.ok(
                new LoginResponse(
                        admin.getId(),
                        admin.getEmail(),
                        token
                )
        );
    }

    public static class LoginRequest {

        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {

        private Long id;
        private String email;
        private String token;

        public LoginResponse(Long id, String email, String token) {
            this.id = id;
            this.email = email;
            this.token = token;
        }

        public Long getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getToken() {
            return token;
        }
    }
}

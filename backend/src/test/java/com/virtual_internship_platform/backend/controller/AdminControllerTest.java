package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Admin;
import com.virtual_internship_platform.backend.response.ApiResponse;
import com.virtual_internship_platform.backend.security.JwtService;
import com.virtual_internship_platform.backend.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAdminSuccessfully() {

        Admin admin = new Admin(
                "admin@test.com",
                "Admin@123"
        );

        when(adminService.createAdmin(any(Admin.class)))
                .thenReturn(admin);

        ResponseEntity<ApiResponse<Admin>> response =
                adminController.createAdmin(admin);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Admin created successfully",
                response.getBody().getMessage()
        );

        verify(adminService).createAdmin(admin);
    }

    @Test
    void loginAdminSuccessfully() {

        Admin admin = new Admin(
                "admin@test.com",
                "Admin@123"
        );

        when(adminService.loginAdmin(
                "admin@test.com",
                "Admin@123"
        )).thenReturn(admin);

        when(jwtService.generateToken("admin@test.com"))
                .thenReturn("test-jwt-token");

        AdminController.LoginRequest loginRequest =
                new AdminController.LoginRequest();

        loginRequest.setEmail("admin@test.com");
        loginRequest.setPassword("Admin@123");

        ResponseEntity<ApiResponse<AdminController.LoginResponse>> response =
                adminController.loginAdmin(loginRequest);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Admin login successful",
                response.getBody().getMessage()
        );

        assertNotNull(response.getBody().getData());
        assertEquals(
                "admin@test.com",
                response.getBody().getData().getEmail()
        );
        assertEquals(
                "test-jwt-token",
                response.getBody().getData().getToken()
        );

        verify(adminService).loginAdmin(
                "admin@test.com",
                "Admin@123"
        );

        verify(jwtService).generateToken("admin@test.com");
    }
}
package com.virtual_internship_platform.backend.service;

import com.virtual_internship_platform.backend.entity.Admin;
import com.virtual_internship_platform.backend.repository.AdminRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(AdminRepository adminRepository,
                        PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin createAdmin(Admin admin) {

        if (adminRepository.existsByEmail(admin.getEmail())) {
            throw new RuntimeException("Admin email already registered");
        }

        admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        return adminRepository.save(admin);
    }

    public Admin loginAdmin(String email, String password) {

        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return admin;
    }
}
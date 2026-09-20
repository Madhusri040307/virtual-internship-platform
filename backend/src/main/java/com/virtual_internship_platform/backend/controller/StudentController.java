package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Student;
import com.virtual_internship_platform.backend.security.JwtService;
import com.virtual_internship_platform.backend.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final JwtService jwtService;

    public StudentController(StudentService studentService,
                             JwtService jwtService) {
        this.studentService = studentService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.registerStudent(student));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginStudent(
            @RequestBody LoginRequest loginRequest) {

        Student student = studentService.loginStudent(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        String token = jwtService.generateToken(student.getEmail());

        return ResponseEntity.ok(
                new LoginResponse(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
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
        private String name;
        private String email;
        private String token;

        public LoginResponse(Long id, String name, String email, String token) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.token = token;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getToken() {
            return token;
        }
    }
}
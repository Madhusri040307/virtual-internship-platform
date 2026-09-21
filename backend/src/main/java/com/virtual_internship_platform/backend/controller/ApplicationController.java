package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Application;
import com.virtual_internship_platform.backend.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> applyForInternship(
            @RequestBody Application application) {

        return ResponseEntity.ok(
                applicationService.applyForInternship(application)
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Application>> getStudentApplications(
            @PathVariable Long studentId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByStudent(studentId)
        );
    }

    @GetMapping("/internship/{internshipId}")
    public ResponseEntity<List<Application>> getInternshipApplications(
            @PathVariable Long internshipId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByInternship(internshipId)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Application> updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                applicationService.updateApplicationStatus(id, status)
        );
    }
}
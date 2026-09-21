package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Application;
import com.virtual_internship_platform.backend.response.ApiResponse;
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
    public ResponseEntity<ApiResponse<Application>> applyForInternship(
            @RequestBody Application application) {

        Application savedApplication =
                applicationService.applyForInternship(application);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Application submitted successfully",
                        savedApplication
                )
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ApiResponse<List<Application>>> getStudentApplications(
            @PathVariable Long studentId) {

        List<Application> applications =
                applicationService.getApplicationsByStudent(studentId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Student applications retrieved successfully",
                        applications
                )
        );
    }

    @GetMapping("/internship/{internshipId}")
    public ResponseEntity<ApiResponse<List<Application>>> getInternshipApplications(
            @PathVariable Long internshipId) {

        List<Application> applications =
                applicationService.getApplicationsByInternship(internshipId);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internship applications retrieved successfully",
                        applications
                )
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Application>> updateApplicationStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Application updatedApplication =
                applicationService.updateApplicationStatus(id, status);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Application status updated successfully",
                        updatedApplication
                )
        );
    }
}

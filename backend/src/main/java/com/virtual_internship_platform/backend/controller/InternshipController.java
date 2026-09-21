package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Internship;
import com.virtual_internship_platform.backend.response.ApiResponse;
import com.virtual_internship_platform.backend.service.InternshipService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    private final InternshipService internshipService;

    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Internship>> createInternship(
            @Valid @RequestBody Internship internship) {

        Internship savedInternship =
                internshipService.createInternship(internship);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internship created successfully",
                        savedInternship
                )
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Internship>>> getAllInternships() {

        List<Internship> internships =
                internshipService.getAllInternships();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internships retrieved successfully",
                        internships
                )
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Page<Internship>>> searchInternships(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Internship> internships =
                internshipService.searchInternships(title, page, size);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internships searched successfully",
                        internships
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Internship>> getInternshipById(
            @PathVariable Long id) {

        Internship internship =
                internshipService.getInternshipById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internship retrieved successfully",
                        internship
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Internship>> updateInternship(
            @PathVariable Long id,
            @Valid @RequestBody Internship internship) {

        Internship updatedInternship =
                internshipService.updateInternship(id, internship);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internship updated successfully",
                        updatedInternship
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteInternship(
            @PathVariable Long id) {

        internshipService.deleteInternship(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Internship deleted successfully",
                        null
                )
        );
    }
}
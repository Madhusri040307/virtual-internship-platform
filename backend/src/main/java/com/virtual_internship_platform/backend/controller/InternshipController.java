package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Internship;
import com.virtual_internship_platform.backend.service.InternshipService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Internship> createInternship(
            @Valid @RequestBody Internship internship) {

        return ResponseEntity.ok(
                internshipService.createInternship(internship)
        );
    }

    @GetMapping
    public ResponseEntity<List<Internship>> getAllInternships() {
        return ResponseEntity.ok(
                internshipService.getAllInternships()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Internship> getInternshipById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                internshipService.getInternshipById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Internship> updateInternship(
            @PathVariable Long id,
            @Valid @RequestBody Internship internship) {

        return ResponseEntity.ok(
                internshipService.updateInternship(id, internship)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInternship(
            @PathVariable Long id) {

        internshipService.deleteInternship(id);

        return ResponseEntity.ok(
                "Internship deleted successfully"
        );
    }
}

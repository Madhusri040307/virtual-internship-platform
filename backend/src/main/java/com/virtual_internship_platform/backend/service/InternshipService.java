package com.virtual_internship_platform.backend.service;

import com.virtual_internship_platform.backend.entity.Internship;
import com.virtual_internship_platform.backend.repository.InternshipRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;

    public InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    public Internship createInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));
    }

    public Internship updateInternship(Long id, Internship internship) {
        Internship existing = getInternshipById(id);

        existing.setTitle(internship.getTitle());
        existing.setCompany(internship.getCompany());
        existing.setLocation(internship.getLocation());
        existing.setDescription(internship.getDescription());
        existing.setDuration(internship.getDuration());

        return internshipRepository.save(existing);
    }

    public void deleteInternship(Long id) {
        Internship internship = getInternshipById(id);
        internshipRepository.delete(internship);
    }

    public Page<Internship> searchInternships(
            String title,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return internshipRepository
                .findByTitleContainingIgnoreCase(title, pageable);
    }
}
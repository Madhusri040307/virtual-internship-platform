package com.virtual_internship_platform.backend.service;

import com.virtual_internship_platform.backend.entity.Application;
import com.virtual_internship_platform.backend.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application applyForInternship(Application application) {

        if (applicationRepository.existsByStudentIdAndInternshipId(
                application.getStudentId(),
                application.getInternshipId())) {

            throw new RuntimeException("Student already applied for this internship");
        }

        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }

    public List<Application> getApplicationsByStudent(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }

    public List<Application> getApplicationsByInternship(Long internshipId) {
        return applicationRepository.findByInternshipId(internshipId);
    }

    public Application updateApplicationStatus(Long id, String status) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        application.setStatus(status);

        return applicationRepository.save(application);
    }
}
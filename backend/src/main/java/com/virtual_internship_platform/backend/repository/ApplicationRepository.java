package com.virtual_internship_platform.backend.repository;

import com.virtual_internship_platform.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudentId(Long studentId);

    List<Application> findByInternshipId(Long internshipId);

    boolean existsByStudentIdAndInternshipId(Long studentId, Long internshipId);
}
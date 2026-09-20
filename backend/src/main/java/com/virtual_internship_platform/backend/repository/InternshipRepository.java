package com.virtual_internship_platform.backend.repository;

import com.virtual_internship_platform.backend.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
}
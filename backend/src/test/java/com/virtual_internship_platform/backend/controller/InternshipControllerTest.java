package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Internship;
import com.virtual_internship_platform.backend.response.ApiResponse;
import com.virtual_internship_platform.backend.service.InternshipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InternshipControllerTest {

    @Mock
    private InternshipService internshipService;

    @InjectMocks
    private InternshipController internshipController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createInternshipSuccessfully() {

        Internship internship = new Internship(
                "Java Backend Intern",
                "ABC Technologies",
                "Chennai",
                "Learn Java and Spring Boot",
                "3 Months"
        );

        when(internshipService.createInternship(any(Internship.class)))
                .thenReturn(internship);

        ResponseEntity<ApiResponse<Internship>> response =
                internshipController.createInternship(internship);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Internship created successfully",
                response.getBody().getMessage()
        );

        verify(internshipService).createInternship(internship);
    }

    @Test
    void getAllInternshipsSuccessfully() {

        Internship internship = new Internship(
                "Java Backend Intern",
                "ABC Technologies",
                "Chennai",
                "Learn Java and Spring Boot",
                "3 Months"
        );

        when(internshipService.getAllInternships())
                .thenReturn(List.of(internship));

        ResponseEntity<ApiResponse<List<Internship>>> response =
                internshipController.getAllInternships();

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Internships retrieved successfully",
                response.getBody().getMessage()
        );
        assertNotNull(response.getBody().getData());
        assertEquals(1, response.getBody().getData().size());
    }

    @Test
    void getInternshipByIdSuccessfully() {

        Internship internship = new Internship(
                "Java Backend Intern",
                "ABC Technologies",
                "Chennai",
                "Learn Java and Spring Boot",
                "3 Months"
        );

        when(internshipService.getInternshipById(1L))
                .thenReturn(internship);

        ResponseEntity<ApiResponse<Internship>> response =
                internshipController.getInternshipById(1L);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Internship retrieved successfully",
                response.getBody().getMessage()
        );

        verify(internshipService).getInternshipById(1L);
    }
}
package com.virtual_internship_platform.backend.controller;

import com.virtual_internship_platform.backend.entity.Application;
import com.virtual_internship_platform.backend.response.ApiResponse;
import com.virtual_internship_platform.backend.service.ApplicationService;
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

class ApplicationControllerTest {

    @Mock
    private ApplicationService applicationService;

    @InjectMocks
    private ApplicationController applicationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void applyForInternshipSuccessfully() {

        Application application =
                new Application(1L, 2L, "APPLIED");

        when(applicationService.applyForInternship(any(Application.class)))
                .thenReturn(application);

        ResponseEntity<ApiResponse<Application>> response =
                applicationController.applyForInternship(application);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Application submitted successfully",
                response.getBody().getMessage()
        );

        verify(applicationService).applyForInternship(application);
    }

    @Test
    void getStudentApplicationsSuccessfully() {

        Application application =
                new Application(1L, 2L, "APPLIED");

        when(applicationService.getApplicationsByStudent(1L))
                .thenReturn(List.of(application));

        ResponseEntity<ApiResponse<List<Application>>> response =
                applicationController.getStudentApplications(1L);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Student applications retrieved successfully",
                response.getBody().getMessage()
        );
        assertEquals(1, response.getBody().getData().size());

        verify(applicationService).getApplicationsByStudent(1L);
    }

    @Test
    void getInternshipApplicationsSuccessfully() {

        Application application =
                new Application(1L, 2L, "APPLIED");

        when(applicationService.getApplicationsByInternship(2L))
                .thenReturn(List.of(application));

        ResponseEntity<ApiResponse<List<Application>>> response =
                applicationController.getInternshipApplications(2L);

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Internship applications retrieved successfully",
                response.getBody().getMessage()
        );
        assertEquals(1, response.getBody().getData().size());

        verify(applicationService).getApplicationsByInternship(2L);
    }

    @Test
    void updateApplicationStatusSuccessfully() {

        Application application =
                new Application(1L, 2L, "ACCEPTED");

        when(applicationService.updateApplicationStatus(1L, "ACCEPTED"))
                .thenReturn(application);

        ResponseEntity<ApiResponse<Application>> response =
                applicationController.updateApplicationStatus(
                        1L,
                        "ACCEPTED"
                );

        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().isSuccess());
        assertEquals(
                "Application status updated successfully",
                response.getBody().getMessage()
        );
        assertEquals(
                "ACCEPTED",
                response.getBody().getData().getStatus()
        );

        verify(applicationService)
                .updateApplicationStatus(1L, "ACCEPTED");
    }
}
package com.virtual_internship_platform.backend.service;

import com.virtual_internship_platform.backend.entity.Student;
import com.virtual_internship_platform.backend.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        student = new Student(
                "Madhu",
                "madhu@test.com",
                "Test@123"
        );
    }

    @Test
    void registerStudentSuccessfully() {

        when(studentRepository.existsByEmail(student.getEmail()))
                .thenReturn(false);

        when(passwordEncoder.encode("Test@123"))
                .thenReturn("encodedPassword");

        when(studentRepository.save(student))
                .thenReturn(student);

        Student result = studentService.registerStudent(student);

        assertNotNull(result);
        assertEquals("encodedPassword", result.getPassword());

        verify(studentRepository).save(student);
        verify(passwordEncoder).encode("Test@123");
    }

    @Test
    void registerStudentWithExistingEmail() {

        when(studentRepository.existsByEmail(student.getEmail()))
                .thenReturn(true);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> studentService.registerStudent(student)
        );

        assertEquals(
                "Email already registered",
                exception.getMessage()
        );

        verify(studentRepository, never()).save(student);
    }

    @Test
    void loginStudentSuccessfully() {

        student.setPassword("encodedPassword");

        when(studentRepository.findByEmail(student.getEmail()))
                .thenReturn(Optional.of(student));

        when(passwordEncoder.matches(
                "Test@123",
                "encodedPassword"
        )).thenReturn(true);

        Student result = studentService.loginStudent(
                "madhu@test.com",
                "Test@123"
        );

        assertNotNull(result);
        assertEquals("madhu@test.com", result.getEmail());
    }

    @Test
    void loginStudentWithInvalidEmail() {

        when(studentRepository.findByEmail("wrong@test.com"))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> studentService.loginStudent(
                        "wrong@test.com",
                        "Test@123"
                )
        );

        assertEquals(
                "Invalid email or password",
                exception.getMessage()
        );
    }

    @Test
    void loginStudentWithInvalidPassword() {

        student.setPassword("encodedPassword");

        when(studentRepository.findByEmail(student.getEmail()))
                .thenReturn(Optional.of(student));

        when(passwordEncoder.matches(
                "Wrong@123",
                "encodedPassword"
        )).thenReturn(false);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> studentService.loginStudent(
                        "madhu@test.com",
                        "Wrong@123"
                )
        );

        assertEquals(
                "Invalid email or password",
                exception.getMessage()
        );
    }
}
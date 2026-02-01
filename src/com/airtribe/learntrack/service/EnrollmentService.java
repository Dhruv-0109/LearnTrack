package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository enrollmentRepo;
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(EnrollmentRepository enrollmentRepo,
                             StudentService studentService,
                             CourseService courseService) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void addEnrollment(int studentId, int courseId) {
        // validate student exists
        studentService.findStudentById(studentId);

        // validate course exists
        courseService.findCourseById(courseId);

        int id = IdGenerator.getEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId);
        enrollmentRepo.addEnrollment(enrollment);
    }

    public void updateEnrollmentStatus(int enrollmentId, EnrollmentStatus status) {
        Enrollment enrollment = getEnrollmentOrThrow(enrollmentId);
        enrollment.setStatus(status);
    }

    public List<Enrollment> findEnrollmentsByStudentId(int studentId) {
        return enrollmentRepo.findByStudentId(studentId);
    }

    public List<Enrollment> findEnrollmentsByCourseId(int courseId) {
        return enrollmentRepo.findByCourseId(courseId);
    }

    private Enrollment getEnrollmentOrThrow(int id) {
        Enrollment enrollment = enrollmentRepo.findById(id);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with id: " + id);
        }
        return enrollment;
    }

    public List<Enrollment> getAllEnrollments()
    {
        return enrollmentRepo.findAll();
    }
}



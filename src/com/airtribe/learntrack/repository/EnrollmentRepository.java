package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnrollmentRepository {

    List<Enrollment> enrollments;

    public EnrollmentRepository()
    {
        enrollments = new ArrayList<>();
    }
    public void addEnrollment(Enrollment enrollment) { enrollments.add(enrollment);}
    public void removeEnrollmentById(int id)
    {
        Iterator<Enrollment> iterator = enrollments.iterator();
        while(iterator.hasNext())
        {
            Enrollment enrollment = iterator.next();
            if(enrollment.getId() == id)
            {
                iterator.remove();
                return;
            }
        }
    }
    public Enrollment findById(int id)
    {
        for(Enrollment enrollment : enrollments)
        {
            if(enrollment.getId() == id)
            {
                return enrollment;
            }
        }
        return null;
    }
    public List<Enrollment> findAll() { return enrollments;}

    public List<Enrollment> findByStudentId(int studentId) {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                result.add(enrollment);
            }
        }

        return result;
    }

    public List<Enrollment> findByCourseId(int courseId)
    {
        List<Enrollment> result = new ArrayList<>();

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getCourseId() == courseId) {
                result.add(enrollment);
            }
        }

        return result;
    }
}

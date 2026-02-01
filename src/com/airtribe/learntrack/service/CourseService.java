package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class CourseService {
    private CourseRepository repo;

    public CourseService(CourseRepository repo)
    {
        this.repo = repo;
    }

    public void addCourse(String courseName, String description,int durationInWeeks)
    {
        int id = IdGenerator.getCourseId();
        Course course = new Course(id, courseName, description,durationInWeeks);
        repo.addCourse(course);
    }
    public void deactivateCourse(int id)
    {
        Course course = getCourseOrThrow(id);
        course.setActive(false);
    }
    public List<Course> getAllCourses() { return repo.findAll();}
    public List<Course> getActiveCourses() { return repo.findActiveCourses();}
    public List<Course> getInactiveCourses() {return repo.findInactiveCourses();}

    public void updateCourseName(int id, String courseName)
    {
        Course course = getCourseOrThrow(id);
        course.setCourseName(courseName);
    }
    public void updateDescription(int id, String description)
    {
        Course course = getCourseOrThrow(id);
        course.setDescription(description);
    }
    public void updateDurationInWeeks(int id, int durationInWeeks)
    {
        Course course = getCourseOrThrow(id);
        course.setDurationInWeeks(durationInWeeks);
    }

    public Course findCourseById(int id) {
        return getCourseOrThrow(id);
    }
    private Course getCourseOrThrow(int id) {
        Course course = repo.findById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with id: " + id);
        }
        return course;
    }


}

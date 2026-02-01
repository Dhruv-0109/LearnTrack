package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseRepository {
    List<Course> courses;

    public CourseRepository()
    {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) { courses.add(course); }
    public void removeCourseById(int id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if (course.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    public List<Course> findAll()
    {
        return courses;
    }
    public Course findById(int id)
    {
        for(Course course: courses)
        {
            if(course.getId() == id)
                return course;
        }
        return null;
    }

    public List<Course> findActiveCourses()
    {
        List<Course> result = new ArrayList<>();
        for(Course course: courses)
        {
            if(course.isActive())
                result.add(course);
        }
        return result;
    }

    public List<Course> findInactiveCourses()
    {
        List<Course> result = new ArrayList<>();
        for(Course course: courses)
        {
            if(!course.isActive())
                result.add(course);
        }
        return result;

    }
}

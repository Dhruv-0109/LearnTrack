package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentRepository {
    List<Student> students;

    public StudentRepository() { this.students = new ArrayList<>(); }

    public List<Student> findAll()
    {
        return students;
    }

    public Student findById(int id)
    {
        for(Student student: students)
        {
            if(student.getId()==id)
                return student;
        }
        return null;
    }
    public Student findByEmail(String email)
    {
        for(Student student: students)
        {
            if(email.equals(student.getEmail()))
                return student;
        }
        return null;
    }
    public List<Student> findByFirstName(String firstName)
    {
        List<Student> result = new ArrayList<>();
        for(Student student: students)
        {
            if(firstName.equals(student.getFirstName()))
                result.add(student);
        }
        return result;
    }
    public List<Student> findByLastName(String lastName)
    {
        List<Student> result = new ArrayList<>();
        for(Student student: students)
        {
            if(lastName.equals(student.getLastName()))
                result.add(student);
        }
        return result;
    }
    public void addStudent(Student student)
    {
        students.add(student);
    }
    public void removeStudentById(int id)
    {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

}

package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo) { this.repo = repo; }
    public void addStudent(String firstName, String lastName, String email, int batch) throws InvalidInputException
    {
        int id = IdGenerator.getStudentId();
        if(!isEmailUnique(email))
            throw new InvalidInputException("Email already exists");
        Student student = new Student(id, firstName,lastName,email,batch);
        repo.addStudent(student);
    }
    public void addStudent(String firstName, String lastName, int batch)
    {
        int id = IdGenerator.getStudentId();
        Student student = new Student(id, firstName,lastName,batch);
        repo.addStudent(student);
    }
    public List<Student> getAllStudents() { return repo.findAll(); }

    public void updateFirstName(int id, String firstName)
    {
        Student student = getStudentOrThrow(id);
        student.setFirstName(firstName);
    }
    public void updateLastName(int id, String lastName)
    {
        Student student = getStudentOrThrow(id);
        student.setLastName(lastName);
    }
    public boolean isEmailUnique(String email)
    {
        List<Student> students = repo.findAll();
        for(Student student: students)
        {
            if( email.equals(student.getEmail()) )
                return false;
        }
        return true;
    }
    public void updateEmail(int id, String email)
    {
        Student student = getStudentOrThrow(id);
       if(!isEmailUnique(email))
           throw new InvalidInputException("Email id already exists");
        student.setEmail(email);
    }
    public void deactivateStudent(int id)
    {
        Student student = getStudentOrThrow(id);
        student.setStatus(false);
    }
    public Student findStudentById(int id) {
        return getStudentOrThrow(id);
    }
    public List<Student> findByFirstName(String firstName)
    {
        return repo.findByFirstName(firstName);
    }
    public List<Student> findByLastName(String lastName)
    {
        return repo.findByLastName(lastName);
    }

    private Student getStudentOrThrow(int id) {
        Student student = repo.findById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with id: " + id);
        }
        return student;
    }
}

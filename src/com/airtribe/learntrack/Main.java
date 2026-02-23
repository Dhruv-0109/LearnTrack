package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {

            // repositories
            StudentRepository studentRepository = new StudentRepository();
            CourseRepository courseRepository = new CourseRepository();
            EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

            // services
            StudentService studentService = new StudentService(studentRepository);
            CourseService courseService = new CourseService(courseRepository);
            EnrollmentService enrollmentService =
                    new EnrollmentService(enrollmentRepository, studentService, courseService);

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Student");
                System.out.println("2. Course");
                System.out.println("3. Enrollment");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");

                try {
                    int input = sc.nextInt();
                    sc.nextLine(); // consume newline

                    switch (input) {
                        case 1:
                            studentMenuOptions(studentService);
                            break;
                        case 2:
                            courseMenuOptions(courseService);
                            break;
                        case 3:
                            enrollmentMenuOptions(enrollmentService);
                            break;
                        case 4:
                            System.out.println("Exiting application...");
                            return;
                        default:
                            System.out.println("Invalid option");
                    }

                } catch (InvalidInputException | EntityNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.nextLine();
                }
            }
        }

    public static void studentMenuOptions(StudentService studentService) {
        while (true) {
            System.out.println("Student Options: ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Deactivate Student");
            System.out.println("4. Find student by Id");
            System.out.println("5. Return to main menu");


            System.out.print("Enter your choice: ");
            try {
                Scanner sc = new Scanner(System.in);
                int input = sc.nextInt();
                sc.nextLine();
                switch (input) {
                    case 1: {
                        System.out.println("Enter first name: ");
                        String firstName = sc.next();

                        System.out.println("Enter last name: ");
                        String lastName = sc.next();

                        System.out.println("Enter batch: ");
                        int batch = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter email (press Enter to skip): ");
                        String email = sc.nextLine();
                        if (email.isEmpty())
                            studentService.addStudent(
                                    firstName, lastName, batch
                            );
                        else
                            studentService.addStudent(
                                    firstName, lastName, email, batch
                            );
                        System.out.println("Student added successfully");
                        break;
                    }
                    case 2: {
                        List<Student> students = studentService.getAllStudents();
                        if (students.isEmpty())
                            System.out.println("No students added yet");
                        else {
                            for (Student student : students) {
                                System.out.println(student.toString());
                            }
                        }
                        break;
                    }
                    case 3:
                        System.out.println("Enter the student id to deactivate: ");
                        int studentId = sc.nextInt();
                        sc.nextLine();
                        studentService.deactivateStudent(studentId);
                        System.out.println("Student with id: " + studentId + "deactivated Successfully");
                        break;
                    case 4: {
                        System.out.print("Enter student id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        Student student = studentService.findStudentById(id);
                        System.out.println(student.toString());
                        break;
                    }
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } catch (InvalidInputException | EntityNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("invalid Input. Please try again");
            }
        }
    }
    public static void courseMenuOptions( CourseService courseService) {
        while(true){
        System.out.println("Course Options: ");
        System.out.println("1. Add Course");
        System.out.println("2. View Course");
        System.out.println("3. Deactivate Course");
        System.out.println("4. Find Course by Id");
        System.out.println("5. Return to main menu");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");

        try{
            int input = sc.nextInt(); sc.nextLine();
            switch(input)
            {
                case 1: {
                    System.out.print("Enter the Course Name: ");
                    String courseName = sc.nextLine();

                    System.out.print("Enter the Course Description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter the Course Duration(in weeks): ");
                    int durationInWeeks = sc.nextInt(); sc.nextLine();

                    courseService.addCourse(courseName, description, durationInWeeks);
                    System.out.println("Course added Successfully!");

                }
                case 2:{
                    List<Course> courses = courseService.getAllCourses();
                    for(Course course: courses)
                        System.out.println(course.toString());
                    break;
                }
                case 3:{
                    System.out.print("Enter the course Id to deactivate it: ");
                    int courseId = sc.nextInt(); sc.nextLine();
                    courseService.deactivateCourse(courseId);
                    System.out.println("Course deactivated successfully");
                    break;
                }
                case 4:{
                    System.out.print("Enter the course Id: ");
                    int courseId = sc.nextInt(); sc.nextLine();
                    Course course = courseService.findCourseById(courseId);
                    System.out.println(course.toString());
                    break;
                }
                case 5: return;
            }
        }
        catch(InvalidInputException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("invalid Input. Please try again");
            sc.nextLine();
        }
}

    }
    public static void enrollmentMenuOptions(EnrollmentService enrollmentService) {
        while (true) {
            System.out.println("Enrollment Options: ");
            System.out.println("1. Add Enrollment");
            System.out.println("2. View All Enrollments");
            System.out.println("3. Update Enrollment Status");
            System.out.println("4. Find Enrollments By Course Id");
            System.out.println("5. Find Enrollments By Student Id");
            System.out.println("6. Go back to main menu");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice: ");

            try {
                int input = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (input) {
                    case 1: {
                        System.out.print("Enter student id: ");
                        int studentId = sc.nextInt(); sc.nextLine();

                        System.out.print("Enter course id: ");
                        int courseId = sc.nextInt(); 
                        sc.nextLine();

                        enrollmentService.addEnrollment(studentId, courseId);
                        System.out.println("Enrollment added successfully");
                        break;
                    }

                    case 2: {
                        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
                        if (enrollments.isEmpty()) {
                            System.out.println("No enrollments found");
                        } else {
                            for (Enrollment e : enrollments) {
                                System.out.println(e);
                            }
                        }
                        break;
                    }

                    case 3: {
                        System.out.print("Enter enrollment id: ");
                        int enrollmentId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Select status:");
                        System.out.println("1. ACTIVE");
                        System.out.println("2. COMPLETED");
                        System.out.println("3. CANCELLED");

                        int statusChoice = sc.nextInt();
                        sc.nextLine();

                        EnrollmentStatus status = null;
                        switch (statusChoice) {
                            case 1: status = EnrollmentStatus.ACTIVE; break;
                            case 2: status = EnrollmentStatus.COMPLETED; break;
                            case 3: status = EnrollmentStatus.CANCELLED; break;
                            default:
                                System.out.println("Invalid status");
                                break;
                        }

                        enrollmentService.updateEnrollmentStatus(enrollmentId, status);
                        System.out.println("Enrollment status updated");
                        break;
                    }

                    case 4: {
                        System.out.print("Enter course id: ");
                        int courseId = sc.nextInt();
                        sc.nextLine();

                        List<Enrollment> enrollments =
                                enrollmentService.findEnrollmentsByCourseId(courseId);

                        if (enrollments.isEmpty()) {
                            System.out.println("No enrollments found for this course");
                        } else {
                            for (Enrollment e : enrollments) {
                                System.out.println(e);
                            }
                        }
                        break;
                    }

                    case 5: {
                        System.out.print("Enter student id: ");
                        int studentId = sc.nextInt();
                        sc.nextLine();

                        List<Enrollment> enrollments =
                                enrollmentService.findEnrollmentsByStudentId(studentId);

                        if (enrollments.isEmpty()) {
                            System.out.println("No enrollments found for this student");
                        } else {
                            for (Enrollment e : enrollments) {
                                System.out.println(e);
                            }
                        }
                        break;
                    }

                    case 6:
                        return;

                    default:
                        System.out.println("Invalid option");
                }

            } catch (InvalidInputException | EntityNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again");
                sc.nextLine();
            }
        }
    }

}

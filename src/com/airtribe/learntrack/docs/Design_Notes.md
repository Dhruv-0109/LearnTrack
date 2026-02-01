1. Why you used ArrayList instead of array?
   The number of students, courses, and enrollments is not known in advance and 
   can change at runtime. Arrays in Java have a fixed size and do not support 
   dynamic resizing, which makes insertions and deletions cumbersome.
   This makes ArrayList suitable for managing in-memory collections in this application.
   ArrayList was chosen because it:
      1. Supports dynamic resizing 
      2. Allows easy addition and removal of elements 
      3. Provides built-in methods for iteration and searching
----------------------------------------------------------------------------------------
2. Where you used static members and why?
   Static members were used in the IdGenerator utility class to maintain 
   unique ID counters for Student, Course, and Enrollment.
    
    The ID counters(studentId, courseId, enrollmentId) and their corresponding methods are static 
    because:
    1. they represent shared behavior
    2. IDs must have globally unique values 
    
    Entity classes do not use static IDs, to ensure each object maintains its 
    own identity while ID generation logic is centralised and consistent.
----------------------------------------------------------------------------------------  
3. Where you used inheritance and what you gained from it?
   Inheritance was used by introducing a base class Person, which contains common 
   attributes such as firstName, lastName, and email. The Student class extends Person 
   and adds student-specific properties like id, batch, and status.
   This helps in:
   1. Code reusability
   2. Easier to add additional classes like Trainer in the future
   3. Avoid duplication of common fields
----------------------------------------------------------------------------------------
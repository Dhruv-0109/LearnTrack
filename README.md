# LearnTrack – Student & Course Management System

## Project Description

LearnTrack is a console-based Student and Course Management System built using Core Java.  
The application allows administrators to manage Students, Courses, and Enrollments through a menu-driven command-line interface.

The program uses Object-Oriented Programming (OOP) principles such as Encapsulation, Inheritance, and basic Polymorphism.  
It follows a layered architecture with clear separation between entities, repositories, services, and the user interface.

All data is stored in memory using collections, and the system supports operations such as adding, viewing, deactivating entities, and managing enrollments.

---

## How to Compile and Run

### Option 1: Using IntelliJ IDEA

1. Clone the repository from GitHub.
2. Open the project in IntelliJ IDEA.
3. Go to **File → Project Structure → Project** and ensure the Project SDK is set to: Homebrew OpenJDK 22.0.2
4. Navigate to: src/com/airtribe/learntrack/Main.java
5. Right-click on `Main.java` and select **Run**.

The console-based menu will start and prompt for user input.

---

### Option 2: Using Terminal

1. Navigate to the project’s `src` directory: cd src
2. Compile the application: javac com/airtribe/learntrack/Main.java
3. Run the application: java com.airtribe.learntrack.Main

The menu-driven application will start in the terminal.


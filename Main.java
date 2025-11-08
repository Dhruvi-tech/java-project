/*
 * Student Management System - Main Class
 * Author: Dhruvi
 * Last edited: November 2025
 * 
 * HOW TO RUN:
 * 1. Compile: javac Person.java Student.java Teacher.java CustomException.java DataValidator.java StudentData.java Main.java
 * 2. Run: java Main
 * 
 * This program demonstrates:
 * - Classes and Inheritance (Person -> Student/Teacher)
 * - Exception Handling (CustomException)
 * - File I/O (StudentData)
 * - Data Validation (DataValidator)
 * - Pass/Fail functionality for students
 */
public class Main {
    public static void main(String[] args) {
        try {
            String[] names = {"Alice Brown", "Andrew Davis", "Anna Garcia", "Anthony Howard", "Benjamin Lee", 
                            "Charlotte Cook", "Christopher Reed", "Daniel Sanchez", "David Wilson", "Emily Wood", 
                            "Emma Rodriguez", "Ethan Miller", "Grace Taylor", "Harper Kelly", "Isabella Ramirez", 
                            "James Anderson", "Jane Smith", "John Doe", "Joshua Bailey", "Kevin Gonzalez", 
                            "Lisa Davis", "Matthew Torres", "Mia Flores", "Michael Johnson", "Olivia Hernandez", 
                            "Ryan Lopez", "Sarah Martinez", "Sophia Perez", "Steven Richardson", "William Moore"};
            
            System.out.println("\n╔═══════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                                  STUDENTS RECORD                                 ║");
            System.out.println("╠══════╦══════════════════════╦═══════╦═══════════╦═══════╦═══════════════════════╣");
            System.out.println("║ No.  ║ Name                 ║ Age   ║ ID        ║ Marks ║ Status                ║");
            System.out.println("╠══════╬══════════════════════╬═══════╬═══════════╬═══════╬═══════════════════════╣");
            
            for (int i = 0; i < 30; i++) {
                Student student = new Student(names[i], 18 + (i % 4), "STU" + String.format("%03d", i + 1), 30 + (i * 2.5) % 70);
                DataValidator.isValidStudentId(student.getStudentId());
                StudentData.saveStudent(student);
                
                System.out.printf("║ %-4d ║ %-20s ║ %-5d ║ %-9s ║ %-5.0f ║ %-21s ║%n", 
                    i + 1, student.getName(), student.getAge(), student.getStudentId(), 
                    student.getMarks(), student.getStatus());
            }
            System.out.println("╚══════╩══════════════════════╩═══════╩═══════════╩═══════╩═══════════════════════╝");
            
            String[] teacherNames = {"Dr. Anderson", "Prof. Brown", "Ms. Davis", "Dr. Garcia", "Mr. Johnson", 
                                   "Prof. Miller", "Ms. Rodriguez", "Dr. Smith", "Mr. Taylor", "Prof. Wilson"};
            String[] subjects = {"Biology", "Chemistry", "Computer Science", "Economics", "English", 
                               "Geography", "History", "Mathematics", "Physics", "Psychology"};
            
            System.out.println("\n╔═══════════════════════════════════════════════════════════════════╗");
            System.out.println("║                              TEACHERS RECORD                              ║");
            System.out.println("╠══════╦══════════════════════╦═══════╦═══════════════════════════════╣");
            System.out.println("║ No.  ║ Name                 ║ Age   ║ Subject                       ║");
            System.out.println("╠══════╬══════════════════════╬═══════╬═══════════════════════════════╣");
            
            for (int i = 0; i < 10; i++) {
                Teacher teacher = new Teacher(teacherNames[i], 30 + (i * 3), subjects[i]);
                System.out.printf("║ %-4d ║ %-20s ║ %-5d ║ %-29s ║%n", 
                    i + 1, teacher.getName(), teacher.getAge(), teacher.getSubject());
            }
            System.out.println("╚══════╩══════════════════════╩═══════╩═══════════════════════════════╝");
            
        } catch (CustomException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
/*
 * How to run this program:
 * 1. Compile: javac Student.java
 * 2. Run: java Student
 * 
 * Last updated: November 2025
 * Contributor: Dhruvi
 */
public class Student extends Person {
    private String studentID;
    private double marks;
    
    public Student(String name, int age, String studentID, double marks) {
        super(name, age);
        this.studentID = studentID;
        this.marks = marks;
    }
    
    public String getStudentID() {
        return studentID;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
    
    public boolean hasPassed() {
        return marks >= 50;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %3d %-10s %6.2f %2s", name, age, studentID, marks, getGrade());
    }
    
    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice Johnson", 19, "S001", 92.0),
            new Student("Bob Wilson", 17, "S002", 67.5),
            new Student("David Garcia", 19, "S003", 63.5),
            new Student("Emma Davis", 18, "S004", 78.0),
            new Student("James Taylor", 17, "S005", 72.5),
            new Student("John Smith", 18, "S006", 85.5),
            new Student("Lisa Anderson", 18, "S007", 88.0),
            new Student("Maria Rodriguez", 19, "S008", 58.0),
            new Student("Mike Brown", 19, "S009", 95.0),
            new Student("Sarah Miller", 17, "S010", 45.0)
        };
        
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("==========================");
        System.out.printf("%-20s %3s %-10s %6s %2s%n", "Name", "Age", "StudentID", "Marks", "Grade");
        System.out.println("----------------------------------------------");
        
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------------");
        System.out.println("Total Students: " + students.length);
    }
}
/*
 * Student.java - Student class extending Person
 * Author: Dhruvi
 * Date: November 2025
 */

public class Student extends Person {
    private String studentID;
    private double marks;
    private boolean isPassed;
    
    public Student(String name, int age, String studentID, double marks) {
        super(name, age);
        this.studentID = studentID;
        this.marks = marks;
        this.isPassed = marks >= 50;
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
        this.isPassed = marks >= 50;
    }
    
    public boolean isPassed() {
        return isPassed;
    }
    
    public String getGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 85) return "A";
        if (marks >= 80) return "B+";
        if (marks >= 75) return "B";
        if (marks >= 70) return "C+";
        if (marks >= 65) return "C";
        if (marks >= 60) return "D+";
        if (marks >= 50) return "D";
        return "F";
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentID + ", Marks: " + marks + ", Grade: " + getGrade() + ", Status: " + (isPassed ? "Pass" : "Fail"));
    }
}
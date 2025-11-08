/*
 * Student Class - Extends Person, adds student ID and marks
 * Author: Dhruvi
 * Last edited: November 2025
 */
public class Student extends Person {
    private String studentId;
    private double marks;
    
    public Student(String name, int age, String studentId, double marks) throws CustomException {
        super(name, age);
        if (age < 18 || age > 21) {
            throw new CustomException("Student age must be between 18-21 years");
        }
        this.studentId = studentId;
        this.marks = marks;
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public String getStatus() {
        return marks >= 50 ? "Pass" : "Fail";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", ID: " + studentId + ", Marks: " + marks + ", Status: " + getStatus();
    }
}

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
    
    @Override
    public String toString() {
        return String.format("%-20s %3d %-10s %6.2f", name, age, studentID, marks);
    }
    
    public static void main(String[] args) {
        Student[] students = {
            new Student("John Smith", 18, "S001", 85.5),
            new Student("Alice Johnson", 19, "S002", 92.0),
            new Student("Bob Wilson", 17, "S003", 67.5),
            new Student("Emma Davis", 18, "S004", 88.0),
            new Student("Mike Brown", 19, "S005", 91.5),
            new Student("Sarah Miller", 17, "S006", 56.0),
            new Student("David Garcia", 19, "S007", 89.5),
            new Student("Lisa Anderson", 18, "S008", 94.0),
            new Student("James Taylor", 17, "S009", 72.5),
            new Student("Maria Rodriguez", 19, "S010", 87.0)
        };
        
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("==========================");
        System.out.printf("%-20s %3s %-10s %6s%n", "Name", "Age", "StudentID", "Marks");
        System.out.println("------------------------------------------");
        
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("------------------------------------------");
        System.out.println("Total Students: " + students.length);
    }
}
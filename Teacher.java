/*
 * How to run this program:
 * 1. Compile: javac Teacher.java
 * 2. Run: java Teacher
 * 
 * Last updated: November 2025
 * Contributor: Dhruvi
 */
public class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %3d %-15s", name, age, subject);
    }
    
    public static void main(String[] args) {
        Teacher[] teachers = {
            new Teacher("Ms. Alice Johnson", 28, "English"),
            new Teacher("Mr. Bob Wilson", 32, "Physics"),
            new Teacher("Mr. David Anderson", 38, "Science"),
            new Teacher("Ms. Emma Davis", 30, "Chemistry"),
            new Teacher("Mr. James Rodriguez", 34, "Social Studies"),
            new Teacher("Mr. John Smith", 35, "Mathematics"),
            new Teacher("Ms. Lisa Taylor", 26, "Geography"),
            new Teacher("Ms. Maria Miller", 40, "Economics"),
            new Teacher("Mr. Mike Brown", 25, "Biology"),
            new Teacher("Ms. Sarah Garcia", 29, "History")
        };
        
        System.out.println("TEACHER MANAGEMENT SYSTEM");
        System.out.println("==========================");
        System.out.printf("%-20s %3s %-15s%n", "Name", "Age", "Subject");
        System.out.println("----------------------------------------");
        
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        System.out.println("----------------------------------------");
        System.out.println("Total Teachers: " + teachers.length);
    }
}
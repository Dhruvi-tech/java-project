/*
 * Teacher Class - Extends Person, adds subject
 * Author: Dhruvi
 * Last edited: November 2025
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
    
    @Override
    public String toString() {
        return super.toString() + ", Subject: " + subject;
    }
}

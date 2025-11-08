/*
 * DataValidator.java - Data validation utilities
 * Author: Dhruvi
 * Date: November 2025
 */

public class DataValidator {
    
    public static boolean isValidStudentID(String studentID) throws CustomException {
        if (studentID == null || studentID.trim().isEmpty()) {
            throw new CustomException("Student ID cannot be null or empty");
        }
        
        if (!studentID.matches("STU\\d{4}")) {
            throw new CustomException("Invalid Student ID format. Expected format: STU####");
        }
        
        return true;
    }
    
    public static boolean isValidAge(int age) throws CustomException {
        if (age < 18 || age > 21) {
            throw new CustomException("Student age must be between 18 and 21");
        }
        return true;
    }
    
    public static boolean isValidMarks(double marks) throws CustomException {
        if (marks < 0 || marks > 100) {
            throw new CustomException("Marks must be between 0 and 100");
        }
        return true;
    }
}
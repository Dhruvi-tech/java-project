/*
 * DataValidator Class - Validates student data
 * Author: Dhruvi
 * Last edited: November 2025
 */
public class DataValidator {
    public static boolean isValidStudentId(String studentId) throws CustomException {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new CustomException("Student ID cannot be empty");
        }
        if (studentId.length() < 3) {
            throw new CustomException("Student ID must be at least 3 characters");
        }
        return true;
    }
}

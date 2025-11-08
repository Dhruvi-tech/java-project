/**
 * DataValidator class - Validates student data
 * Demonstrates exception handling and data validation
 */
public class DataValidator {
    
    /**
     * Validates student ID format and throws custom exception if invalid
     * @param studentId - The student ID to validate
     * @return true if valid
     * @throws CustomException if validation fails
     */
    public static boolean isValidStudentId(String studentId) throws CustomException {
        // Check if student ID is null or empty
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new CustomException("Student ID cannot be null or empty");
        }
        
        // Check if student ID has minimum length
        if (studentId.length() < 3) {
            throw new CustomException("Student ID must be at least 3 characters long");
        }
        
        return true;  // Return true if all validations pass
    }
}

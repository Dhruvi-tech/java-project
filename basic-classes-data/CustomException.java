/*
 * CustomException Class - Simple custom exception
 * Author: Dhruvi
 * Last edited: November 2025
 */
import java.time.LocalDateTime;

public class CustomException extends Exception {
    private String timestamp;
    
    public CustomException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now().toString();
    }
    
    @Override
    public String getMessage() {
        return super.getMessage() + " [" + timestamp + "]";
    }
}

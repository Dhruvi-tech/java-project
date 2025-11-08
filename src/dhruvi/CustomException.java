/*
 * CustomException.java - Custom exception with timestamp
 * Author: Dhruvi
 * Date: November 2025
 */

import java.time.LocalDateTime;

public class CustomException extends Exception {
    private LocalDateTime timestamp;
    
    public CustomException(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String getMessage() {
        return "[" + timestamp + "] " + super.getMessage();
    }
}
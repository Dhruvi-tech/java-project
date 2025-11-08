/*
 * StudentData Class - Handles file I/O operations
 * Author: Dhruvi
 * Last edited: November 2025
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class StudentData {
    private static final String FILE_NAME = "students.txt";
    
    public static void saveStudent(Student student) throws CustomException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(student.getName() + "," + student.getAge() + "," + 
                          student.getStudentId() + "," + student.getMarks() + "," + LocalDateTime.now());
        } catch (IOException e) {
            throw new CustomException("Error saving data: " + e.getMessage());
        }
    }
    
    public static List<Student> loadStudents() throws CustomException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    students.add(new Student(parts[0], Integer.parseInt(parts[1]), 
                                           parts[2], Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            throw new CustomException("Error loading data: " + e.getMessage());
        }
        return students;
    }
}
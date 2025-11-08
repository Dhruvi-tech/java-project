/*
 * StudentData.java - File I/O operations for student data
 * Author: Dhruvi
 * Date: November 2025
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private static final String FILE_NAME = "students.txt";
    
    public static void saveStudents(List<Student> students) throws CustomException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getAge() + "," + 
                             student.getStudentID() + "," + student.getMarks());
            }
        } catch (IOException e) {
            throw new CustomException("Error saving student data: " + e.getMessage());
        }
    }
    
    public static List<Student> loadStudents() throws CustomException {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            return students;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String studentID = parts[2];
                    double marks = Double.parseDouble(parts[3]);
                    students.add(new Student(name, age, studentID, marks));
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new CustomException("Error loading student data: " + e.getMessage());
        }
        
        return students;
    }
    
    public static void clearData() throws CustomException {
        File file = new File(FILE_NAME);
        if (file.exists() && !file.delete()) {
            throw new CustomException("Error clearing student data file");
        }
    }
}
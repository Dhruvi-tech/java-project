/*
 * StudentSearch.java - Provides search functionalities for students.
 * Part of Module 4: Collections.
 * Author: Archana
 * Date: November 2025
 */

package Archana;

import Dhruvi.Student;
import java.util.List;
import java.util.Optional;

public class StudentSearch {

    /**
     * Searches for a student by their name.
     * @param students The list of students to search in.
     * @param name The name to search for.
     * @return An Optional containing the found Student, or an empty Optional.
     */
    public static Optional<Student> findStudentByName(List<Student> students, String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    /**
     * Searches for a student by their ID.
     */
    public static Optional<Student> findStudentByID(List<Student> students, String studentID) {
        return students.stream()
                .filter(s -> s.getStudentID().equals(studentID))
                .findFirst();
    }
}
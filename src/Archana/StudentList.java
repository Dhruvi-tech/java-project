/*
 * StudentList.java - Manages a collection of students.
 * Part of Module 4: Collections.
 * Author: Archana
 * Date: November 2025
 */

package Archana;

import Dhruvi.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getStudents() {
        // Return a copy to prevent external modification of the internal list
        return new ArrayList<>(students);
    }

    public void displayStudents() {
        System.out.println("--- Displaying All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        }
        students.forEach(Student::displayInfo);
        System.out.println("-----------------------------");
    }
}
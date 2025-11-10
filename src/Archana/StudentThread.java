/*
 * StudentThread.java - A simple thread to process students.
 * Part of Module 3: Multithreading.
 * Author: Archana
 * Date: November 2025
 */

package Archana;

import Dhruvi.Student;
import java.util.List;

public class StudentThread extends Thread {
    private final List<Student> students;

    public StudentThread(String name, List<Student> students) {
        super(name);
        this.students = students;
    }

    @Override
    public void run() {
        System.out.println("Thread '" + getName() + "' started processing " + students.size() + " students.");
        for (Student s : students) {
            System.out.println(getName() + ": Student " + s.getName() + " has status: " + (s.isPassed() ? "Pass" : "Fail"));
        }
        System.out.println("Thread '" + getName() + "' finished.");
    }
}
/*
 * ThreadDemo.java - A basic threading example.
 * Part of Module 3: Multithreading.
 * Author: Archana
 * Date: November 2025
 */

package Archana;

import Dhruvi.Student;
import java.util.ArrayList;
import java.util.List;

public class ThreadDemo {
    public static void main(String[] args) {
        // Create two lists of students to be processed by different threads
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("Alice", 18, "STU0001", 92.0));
        list1.add(new Student("Bob", 19, "STU0002", 78.0));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("Charlie", 20, "STU0003", 65.0));
        list2.add(new Student("Diana", 21, "STU0004", 88.0));

        // Create two threads to process the student lists
        Thread t1 = new StudentThread("Processor-1", list1);
        Thread t2 = new StudentThread("Processor-2", list2);

        // Start the threads
        t1.start();
        t2.start();
    }
}
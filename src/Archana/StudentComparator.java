/*
 * StudentComparator.java - A custom comparator for sorting students.
 * Part of Module 4: Collections.
 * Author: Archana
 * Date: November 2025
 */

package Archana;

import Dhruvi.Student;
import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}
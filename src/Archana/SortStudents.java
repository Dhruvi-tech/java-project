/*
 * SortStudents.java - Uses lambda expressions to sort students.
 * Part of Module 4: Lambda Expressions.
 * Author: Archana
 * Date: November 2025
 */

package Archana;

import Dhruvi.Student;
import java.util.Comparator;
import java.util.List;

public class SortStudents {

    /**
     * Sorts a list of students by marks in descending order using a lambda expression.
     */
    public static void sortByMarks(List<Student> students) {
        students.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
    }

    /**
     * Sorts a list of students by name in alphabetical order using a method reference.
     */
    public static void sortByName(List<Student> students) {
        students.sort(Comparator.comparing(Student::getName));
    }
}
/*
 * Student Management System - Module 1
 * Basic Classes & Data Foundation Layer
 * 
 * Author: Dhruvi
 * Date: November 2025
 * 
 * HOW TO RUN:
 * 1. cd dhruvi
 * 2. javac *.java
 * 3. java Main
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        // Student Data
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack",
                "Kate", "Liam", "Mia", "Noah", "Olivia", "Paul", "Quinn", "Ruby", "Sam", "Tina",
                "Uma", "Victor", "Wendy", "Xavier", "Yara", "Zoe", "Adam", "Bella", "Carl", "Dora"};

        double[] marks = {92, 78, 65, 88, 45, 73, 91, 56, 82, 67,
                75, 89, 43, 95, 71, 58, 86, 62, 77, 48,
                84, 69, 93, 52, 79, 66, 87, 74, 41, 96};

        for (int i = 0; i < names.length; i++) {
            String id = "STU" + String.format("%04d", i + 1);
            int age = 18 + (i % 4);
            students.add(new Student(names[i], age, id, marks[i]));
        }

        // Sort Students Alphabetically
        students.sort(Comparator.comparing(Student::getName));

        // Teacher Data
        String[] teacherNames = {"Dr. Smith", "Prof. Johnson", "Ms. Williams", "Mr. Brown", "Dr. Davis",
                "Prof. Miller", "Ms. Wilson", "Mr. Moore", "Dr. Taylor", "Prof. Anderson"};
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "Biology", "English",
                "History", "Geography", "Computer Science", "Economics", "Psychology"};

        for (int i = 0; i < teacherNames.length; i++) {
            teachers.add(new Teacher(teacherNames[i], 30 + i * 2, subjects[i]));
        }

        // Sort Teachers Alphabetically
        teachers.sort(Comparator.comparing(Teacher::getName));

        // Display Tables
        displayTables(students, teachers);
    }

    private static void displayTables(List<Student> students, List<Teacher> teachers) {

        // =================== STUDENT DATA TABLE ===================
        printCenteredTitle(61, "STUDENT DATA TABLE");
        System.out.println("+---------------+-----+----------+--------+--------+--------+");
        System.out.println("| Name          | Age | ID       | Marks  | Grade  | Status |");
        System.out.println("+---------------+-----+----------+--------+--------+--------+");
        for (Student s : students) {
            System.out.printf("| %-13s | %-3d | %-8s | %-6.1f | %-6s | %-6s |%n",
                    s.getName(), s.getAge(), s.getStudentID(), s.getMarks(), s.getGrade(),
                    s.isPassed() ? "Pass" : "Fail");
        }
        System.out.println("+---------------+-----+----------+--------+--------+--------+");

        printSectionBreak();

        // =================== TEACHER DATA TABLE ===================
        printCenteredTitle(61, "TEACHER DATA TABLE");
        System.out.println("+--------------------+-----+--------------------+------------+");
        System.out.println("| Name               | Age | Subject            | Experience |");
        System.out.println("+--------------------+-----+--------------------+------------+");
        for (Teacher t : teachers) {
            int exp = t.getAge() - 25;
            System.out.printf("| %-18s | %-3d | %-18s | %-10d |%n",
                    t.getName(), t.getAge(), t.getSubject(), exp);
        }
        System.out.println("+--------------------+-----+--------------------+------------+");

        printSectionBreak();

        // =================== GRADE DISTRIBUTION ===================
        int[] gradeCount = new int[9];
        String[] grades = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
        int pass = 0;
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE, totalMarks = 0;

        for (Student s : students) {
            if (s.isPassed()) pass++;
            double m = s.getMarks();
            totalMarks += m;
            min = Math.min(min, m);
            max = Math.max(max, m);
            for (int i = 0; i < grades.length; i++)
                if (s.getGrade().equals(grades[i])) gradeCount[i]++;
        }

        printCenteredTitle(39, "GRADE DISTRIBUTION");
        System.out.println("+-------+---------------+--------------+");
        System.out.println("| Grade | Students      | Percentage   |");
        System.out.println("+-------+---------------+--------------+");
        for (int i = 0; i < grades.length; i++) {
            if (gradeCount[i] > 0) {
                double perc = (gradeCount[i] * 100.0 / students.size());
                System.out.printf("| %-5s | %-13s | %-11.1f%% |%n",
                        grades[i], gradeCount[i] + " students", perc);
            }
        }
        System.out.println("+-------+---------------+--------------+");

        printSectionBreak();

        // =================== STATISTICS SUMMARY ===================
        double avgMarks = totalMarks / students.size();

        printCenteredTitle(47, "STATISTICS SUMMARY");
        System.out.println("+-------------------+--------------------------+");
        System.out.println("| Metric            | Value                    |");
        System.out.println("+-------------------+--------------------------+");
        System.out.printf("| %-17s | %-24s |%n", "Pass Rate",
                String.format("%.1f%% (%d students)", pass * 100.0 / students.size(), pass));
        System.out.printf("| %-17s | %-24s |%n", "Fail Rate",
                String.format("%.1f%% (%d students)", (students.size() - pass) * 100.0 / students.size(),
                        students.size() - pass));
        System.out.printf("| %-17s | %-24.1f |%n", "Average Marks", avgMarks);
        System.out.printf("| %-17s | %-24.1f |%n", "Minimum Marks", min);
        System.out.printf("| %-17s | %-24.1f |%n", "Maximum Marks", max);
        System.out.println("+-------------------+--------------------------+");

        printSectionBreak();

        // =================== TOP PERFORMERS ===================
        printCenteredTitle(47, "TOP PERFORMERS (85+ marks)");
        System.out.println("+---------------+------------------------------+");
        System.out.println("| Name          | Marks (Grade)                |");
        System.out.println("+---------------+------------------------------+");
        students.stream()
                .filter(s -> s.getMarks() >= 85)
                .forEach(s -> System.out.printf("| %-13s | %-28s |%n",
                        s.getName(), String.format("%.1f (%s)", s.getMarks(), s.getGrade())));
        System.out.println("+---------------+------------------------------+");

        printSectionBreak();

        // =================== SUMMARY FOOTER ===================
        System.out.printf("Summary: Total Students = %d | Total Teachers = %d%n",
                students.size(), teachers.size());
        System.out.println("=".repeat(61));
    }

    // ---------------- Helper Methods ----------------
    private static void printCenteredTitle(int width, String title) {
        String border = "+" + "-".repeat(width - 2) + "+";
        int padding = (width - 2 - title.length()) / 2;
        String line = "|" + " ".repeat(padding) + title + " ".repeat(width - 2 - padding - title.length()) + "|";
        System.out.println(border);
        System.out.println(line);
        System.out.println(border);
    }

    private static void printSectionBreak() {
        System.out.println("\n" + "=".repeat(61) + "\n");
    }
}



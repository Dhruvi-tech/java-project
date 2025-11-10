/*
 * DataViewerWindow.java - A generic window to display tables of data.
 * Consolidates ViewStudentsWindow and ViewTeachersWindow.
 * Author: Bimala
 * Date: November 2025
 */

package Bimala;

import Archana.StudentList;
import Dhruvi.Student;
import Dhruvi.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DataViewerWindow extends JDialog {

    public DataViewerWindow(JFrame owner, StudentList studentList) {
        super(owner, "All Students", true);
        initComponents(studentList.getStudents(), null);
    }

    public DataViewerWindow(JFrame owner, List<Teacher> teacherList) {
        super(owner, "All Teachers", true);
        initComponents(null, teacherList);
    }

    private void initComponents(List<Student> students, List<Teacher> teachers) {
        setSize(600, 400);
        setLocationRelativeTo(getParent());

        DefaultTableModel model;

        if (students != null) {
            String[] columnNames = {"Name", "Age", "Student ID", "Marks", "Grade"};
            model = new DefaultTableModel(columnNames, 0);
            for (Student s : students) {
                model.addRow(new Object[]{s.getName(), s.getAge(), s.getStudentID(), s.getMarks(), s.getGrade()});
            }
        } else { // teachers must not be null
            String[] columnNames = {"Name", "Age", "Subject", "Experience (Years)"};
            model = new DefaultTableModel(columnNames, 0);
            for (Teacher t : teachers) {
                model.addRow(new Object[]{t.getName(), t.getAge(), t.getSubject(), t.getAge() - 25});
            }
        }

        JTable table = new JTable(model);
        styleTable(table);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void styleTable(JTable table) {
        table.setRowHeight(25);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        // Setting background might not work on all Look and Feels (e.g., macOS)
        // table.getTableHeader().setBackground(new Color(240, 240, 240));
    }
}
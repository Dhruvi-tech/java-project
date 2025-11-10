/*
 * ButtonHandler.java - Handles button clicks for the GUI.
 * Part of Module 5: Event Handling.
 * Author: Bimala
 * Date: November 2025
 */

package Bimala;

import Archana.StudentList;
import Archana.StudentSearch;
import Dhruvi.CustomException;
import Dhruvi.Student;
import Dhruvi.Teacher;
import Dhruvi.StudentData;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.List;

public class ButtonHandler {
    private StudentList studentList;
    private List<Teacher> teacherList;
    private JFrame owner;

    public ButtonHandler(StudentList studentList, List<Teacher> teacherList, JFrame owner) {
        this.studentList = studentList;
        this.teacherList = teacherList;
        this.owner = owner;
    }

    public void openAddStudentForm() {
        AddStudentForm addForm = new AddStudentForm(studentList, owner);
        addForm.setVisible(true);
    }

    public void openViewStudentsWindow() {
        DataViewerWindow viewWindow = new DataViewerWindow(owner, studentList);
        viewWindow.setVisible(true);
    }

    public void openViewTeachersWindow() {
        DataViewerWindow viewWindow = new DataViewerWindow(owner, teacherList);
        viewWindow.setVisible(true);
    }

    public void openAboutDialog() {
        AboutDialog aboutDialog = new AboutDialog(owner);
        aboutDialog.setVisible(true);
    }

    public void saveStudentData() {
        try {
            StudentData.saveStudents(studentList.getStudents());
            showInfo("Success", "Student data saved successfully to students.txt");
        } catch (CustomException e) {
            showError("Save Error", "Could not save student data: " + e.getMessage());
        }
    }

    public void loadStudentData() {
        try {
            List<Student> loadedStudents = StudentData.loadStudents();
            studentList.getStudents().clear(); // Clear current list
            loadedStudents.forEach(studentList::addStudent); // Add loaded students
            showInfo("Success", "Student data loaded successfully from students.txt");
        } catch (CustomException e) {
            showError("Load Error", "Could not load student data: " + e.getMessage());
        }
    }

    public void openSearchStudentDialog() {
        String initialInput = JOptionPane.showInputDialog(owner, "Enter Student Name or ID:", "Search Student", JOptionPane.QUESTION_MESSAGE);

        if (initialInput == null || initialInput.trim().isEmpty()) {
            return; // User cancelled or entered nothing
        }

        final String searchTerm = initialInput.trim(); // This variable is now effectively final

        // First, try searching by ID, then by name
        Student foundStudent = StudentSearch.findStudentByID(studentList.getStudents(), searchTerm)
                .orElseGet(() -> StudentSearch.findStudentByName(studentList.getStudents(), searchTerm)
                        .orElse(null));

        if (foundStudent != null) {
            // For a visually appealing result, we use HTML formatting in a JOptionPane.
            String title = "Search Result";
            String message = "<html>"
                    + "<body>"
                    + "<h2>Student Found!</h2>"
                    + "<table width='300' border='0'>"
                    + "<tr><td><b>Name:</b></td><td>" + foundStudent.getName() + "</td></tr>"
                    + "<tr><td><b>Age:</b></td><td>" + foundStudent.getAge() + "</td></tr>"
                    + "<tr><td><b>Student ID:</b></td><td>" + foundStudent.getStudentID() + "</td></tr>"
                    + "<tr><td><b>Marks:</b></td><td>" + foundStudent.getMarks() + "</td></tr>"
                    + "<tr><td><b>Grade:</b></td><td><b>" + foundStudent.getGrade() + "</b></td></tr>"
                    + "<tr><td><b>Status:</b></td><td>" + (foundStudent.isPassed() ? "Pass" : "Fail") + "</td></tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>";

            JOptionPane.showMessageDialog(owner, message, title, JOptionPane.INFORMATION_MESSAGE);
        } else {
            showError("Not Found", "No student found with the name or ID: '" + searchTerm + "'");
        }
    }

    public void openReportsWindow() {
        ReportsWindow reportsWindow = new ReportsWindow(studentList, owner);
        reportsWindow.setVisible(true);
    }

    // --- Private Helper Methods for Alerts (replaces AlertDialog.java) ---
    private void showInfo(String title, String message) {
        JOptionPane.showMessageDialog(owner, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void showError(String title, String message) {
        JOptionPane.showMessageDialog(owner, message, title, JOptionPane.ERROR_MESSAGE);
    }
}

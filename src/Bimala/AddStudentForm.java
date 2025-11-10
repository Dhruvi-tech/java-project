/*
 * AddStudentForm.java - Form to add a new student.
 * Part of Module 5: JavaFX.
 * Author: Bimala
 * Date: November 2025
 */

package Bimala;

import Archana.StudentList;
import Dhruvi.CustomException;
import Dhruvi.Student;
import Dhruvi.DataValidator;
import javax.swing.*;
import java.awt.*;

public class AddStudentForm extends JDialog {
    private StudentList studentList;

    public AddStudentForm(StudentList studentList, JFrame owner) {
        super(owner, "Add New Student", true); // true for modal
        this.studentList = studentList;
        initComponents();
    }

    private void initComponents() {
        setSize(350, 250);
        setLocationRelativeTo(getParent());
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Form fields
        JTextField nameField = new JTextField(15);
        JTextField ageField = new JTextField(15);
        JTextField idField = new JTextField(15);
        JTextField marksField = new JTextField(15);

        gbc.gridx = 0; gbc.gridy = 0; formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; formPanel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; formPanel.add(new JLabel("Age:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; formPanel.add(ageField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; formPanel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; formPanel.add(idField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; formPanel.add(new JLabel("Marks:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; formPanel.add(marksField, gbc);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String id = idField.getText();
                double marks = Double.parseDouble(marksField.getText());

                // Use Dhruvi's DataValidator
                DataValidator.isValidAge(age);
                DataValidator.isValidStudentID(id);
                DataValidator.isValidMarks(marks);

                Student newStudent = new Student(name, age, id, marks);
                studentList.addStudent(newStudent);

                JOptionPane.showMessageDialog(this, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close the dialog
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please check age and marks.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (CustomException ex) {
                JOptionPane.showMessageDialog(this, "Validation Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
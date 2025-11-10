/*
 * AddStudentForm.java - Form to add new students
 * Author: Bimala
 * Date: November 2025
 */

package Bimala;

import Dhruvi.*;
import Archana.StudentList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddStudentForm {
    private StudentList studentList = new StudentList();

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Add New Student");

        TextField nameField = new TextField();
        TextField ageField = new TextField();
        TextField idField = new TextField();
        TextField marksField = new TextField();

        Button saveBtn = new Button("Save Student");

        saveBtn.setOnAction(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String id = idField.getText();
                double marks = Double.parseDouble(marksField.getText());

                if (DataValidator.isValidStudentID(id) && DataValidator.isValidAge(age) && DataValidator.isValidMarks(marks)) {
                    Student student = new Student(name, age, id, marks);
                    studentList.addStudent(student);
                    AlertDialog.showInfo("Success", "Student added successfully!");
                    stage.close();
                }
            } catch (CustomException ce) {
                AlertDialog.showError("Validation Error", ce.getMessage());
            } catch (Exception ex) {
                AlertDialog.showError("Error", "Invalid input format.");
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-padding: 20;");

        grid.addRow(0, new Label("Name:"), nameField);
        grid.addRow(1, new Label("Age:"), ageField);
        grid.addRow(2, new Label("Student ID:"), idField);
        grid.addRow(3, new Label("Marks:"), marksField);
        grid.addRow(4, saveBtn);

        stage.setScene(new Scene(grid, 350, 250));
        stage.show();
    }
}

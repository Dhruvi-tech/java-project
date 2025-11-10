/*
 * AboutDialog.java - Displays information about the application and contributors.
 * Date: November 2025
 */

package Bimala;

import javax.swing.*;
import java.awt.*;

public class AboutDialog extends JDialog {

    public AboutDialog(JFrame owner) {
        super(owner, "About Student Management System", true);
        setSize(550, 450);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        String aboutText = "<html>"
                + "<body style='font-family: Segoe UI, sans-serif; font-size: 12px; padding: 15px;'>"
                + "<h1>Student Management System</h1>"
                + "<p>This application is a collaborative project designed to manage student and teacher data.</p>"
                + "<hr>"
                
                + "<h2>Module Contributions:</h2>"
                
                + "<h3 style='color: #4682B4;'>MEMBER 1: Dhruvi (Data Foundation & Analytics)</h3>"
                + "<p><b>Dhruvi's work is the core engine of this application.</b> She was responsible for:</p>"
                + "<ul>"
                + "<li><b>Base Classes:</b> Creating the fundamental <code>Person</code>, <code>Student</code>, and <code>Teacher</code> classes.</li>"
                + "<li><b>Data Validation:</b> Building the robust <code>DataValidator</code> to ensure data integrity.</li>"
                + "<li><b>File I/O:</b> Implementing the <code>StudentData</code> class to save and load all student information.</li>"
                + "<li><b>Core Analytics:</b> Developing all the data analysis logic, including:"
                + "<ul><li>Statistics Summary (pass/fail rates, averages)</li>"
                + "<li>Grade Distribution Reports</li>"
                + "<li>Top Performer calculations</li></ul></li>"
                + "<li><b>Custom Exceptions:</b> Creating a custom exception handler for the application.</li>"
                + "</ul>"
                
                + "<h3 style='color: #32CD32;'>MEMBER 2: Archana (Collections & Threading)</h3>"
                + "<p>Archana was responsible for advanced data handling and processing:</p>"
                + "<ul>"
                + "<li><b>Collections:</b> Managing student data in memory using <code>ArrayList</code> via the <code>StudentList</code> class.</li>"
                + "<li><b>Lambda & Sorting:</b> Implementing modern sorting features using lambda expressions.</li>"
                + "<li><b>Search Functionality:</b> Creating the efficient <code>StudentSearch</code> utility.</li>"
                + "<li><b>Multithreading:</b> Introducing basic threading concepts with <code>StudentThread</code>.</li>"
                + "</ul>"

                + "<h3 style='color: #FF6347;'>MEMBER 3: Bimala (GUI & Event Handling)</h3>"
                + "<p>Bimala was responsible for creating the user interface and integrating all modules:</p>"
                + "<ul>"
                + "<li><b>GUI Development:</b> Building the entire Swing-based graphical user interface.</li>"
                + "<li><b>Event Handling:</b> Managing all button clicks and user interactions.</li>"
                + "<li><b>Module Integration:</b> Connecting the backend logic from Dhruvi and Archana to the frontend GUI.</li>"
                + "</ul>"

                + "</body></html>";

        JEditorPane editorPane = new JEditorPane("text/html", aboutText);
        editorPane.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(editorPane);
        add(scrollPane, BorderLayout.CENTER);
    }
}
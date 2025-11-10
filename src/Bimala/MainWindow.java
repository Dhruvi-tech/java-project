/*
 * MainWindow.java - Main JavaFX window.
 * Part of Module 5: JavaFX.
 * Author: Bimala
 * Date: November 2025
 */

package Bimala;

import Archana.StudentList;
import Dhruvi.Student;
import Dhruvi.Teacher;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainWindow extends JFrame {
    // Use a static StudentList to share data across different windows.
    private static StudentList studentList = new StudentList();
    private static List<Teacher> teacherList = new ArrayList<>();

    public MainWindow() {
        super("Student Management System");
        // Load initial data when the application starts
        loadInitialStudentData();
        loadInitialTeacherData();
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        // --- Title Panel ---
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(70, 130, 180)); // SteelBlue
        JLabel titleLabel = new JLabel("Student Management System");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Create MenuBar
        setJMenuBar(createAppMenuBar());

        // Create main content area with buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.WHITE);

        // Create styled buttons with icons
        JButton btnAdd = createStyledButton("Add Student", "icons/add.png");
        JButton btnView = createStyledButton("View Students", "icons/view.png");
        JButton btnSearch = createStyledButton("Search Students", "icons/search.png");
        JButton btnViewTeachers = createStyledButton("View Teachers", "icons/teacher.png"); 
        JButton btnReports = createStyledButton("View Reports", "icons/stats.png");

        // Set button actions using a handler
        ButtonHandler handler = new ButtonHandler(studentList, teacherList, this);
        btnAdd.addActionListener(e -> handler.openAddStudentForm());
        btnView.addActionListener(e -> handler.openViewStudentsWindow());
        btnSearch.addActionListener(e -> handler.openSearchStudentDialog());
        btnViewTeachers.addActionListener(e -> handler.openViewTeachersWindow());
        btnReports.addActionListener(e -> handler.openReportsWindow()); // This button now opens the tabbed window

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnView);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnViewTeachers);
        buttonPanel.add(btnReports);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setIcon(new ImageIcon(iconPath));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setFocusPainted(false);
        return button;
    }

    private JMenuBar createAppMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        ButtonHandler handler = new ButtonHandler(studentList, teacherList, this);

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveItem = new JMenuItem("Save Student Data", new ImageIcon("icons/save.png"));
        JMenuItem loadItem = new JMenuItem("Load Student Data", new ImageIcon("icons/load.png"));
        JMenuItem exitItem = new JMenuItem("Exit");
        saveItem.addActionListener(e -> handler.saveStudentData());
        loadItem.addActionListener(e -> handler.loadStudentData());
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Student Menu
        JMenu studentMenu = new JMenu("Student");
        JMenuItem addItem = new JMenuItem("Add Student");
        addItem.addActionListener(e -> handler.openAddStudentForm());
        JMenuItem viewItem = new JMenuItem("View Students");
        viewItem.addActionListener(e -> handler.openViewStudentsWindow());
        JMenuItem searchItem = new JMenuItem("Search Students");
        searchItem.addActionListener(e -> handler.openSearchStudentDialog());
        studentMenu.add(addItem);
        studentMenu.add(viewItem);
        studentMenu.add(searchItem);

        // Reports Menu
        JMenu reportsMenu = new JMenu("Reports");
        JMenuItem reportsItem = new JMenuItem("View All Reports", new ImageIcon("icons/stats.png"));
        reportsItem.addActionListener(e -> handler.openReportsWindow());
        reportsMenu.add(reportsItem);

        // Teacher Menu
        JMenu teacherMenu = new JMenu("Teacher");
        JMenuItem viewTeachersItem = new JMenuItem("View Teachers");
        viewTeachersItem.addActionListener(e -> handler.openViewTeachersWindow());
        teacherMenu.add(viewTeachersItem);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About This Application");
        aboutItem.addActionListener(e -> handler.openAboutDialog());
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu); // Correctly add menus
        menuBar.add(studentMenu); // ...
        menuBar.add(reportsMenu); // ...
        menuBar.add(teacherMenu); // ...
        menuBar.add(helpMenu); // ...
        return menuBar;
    }

    /**
     * Populates the student list with initial data.
     * This integrates the data from Dhruvi's module into the GUI.
     */
    private void loadInitialStudentData() {
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Henry", "Ivy", "Jack",
                "Kate", "Liam", "Mia", "Noah", "Olivia", "Paul", "Quinn", "Ruby", "Sam", "Tina",
                "Uma", "Victor", "Wendy", "Xavier", "Yara", "Zoe", "Adam", "Bella", "Carl", "Dora"};

        double[] marks = {92, 78, 65, 88, 45, 73, 91, 56, 82, 67,
                75, 89, 43, 95, 71, 58, 86, 62, 77, 48,
                84, 69, 93, 52, 79, 66, 87, 74, 41, 96};

        for (int i = 0; i < names.length; i++) {
            String id = "STU" + String.format("%04d", i + 1);
            studentList.addStudent(new Student(names[i], 18 + (i % 4), id, marks[i]));
        }
    }

    /**
     * Populates the teacher list with initial data from Dhruvi's module.
     */
    private void loadInitialTeacherData() {
        String[] teacherNames = {"Dr. Smith", "Prof. Johnson", "Ms. Williams", "Mr. Brown", "Dr. Davis",
                "Prof. Miller", "Ms. Wilson", "Mr. Moore", "Dr. Taylor", "Prof. Anderson"};
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "Biology", "English",
                "History", "Geography", "Computer Science", "Economics", "Psychology"};

        for (int i = 0; i < teacherNames.length; i++) {
            teacherList.add(new Teacher(teacherNames[i], 30 + i * 2, subjects[i]));
        }

        // Sort Teachers Alphabetically, like in Dhruvi's demo
        teacherList.sort(Comparator.comparing(Teacher::getName));
    }
}
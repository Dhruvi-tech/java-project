/*
 * ReportsWindow.java - Displays all analytical reports in a tabbed view.
 * Consolidates multiple features from Dhruvi's module.
 * Author: Bimala
 * Date: November 2025
 */

package Bimala;

import Archana.StudentList;
import Dhruvi.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportsWindow extends JDialog {

    private StudentList studentList;

    public ReportsWindow(StudentList studentList, JFrame owner) {
        super(owner, "Analytical Reports", true);
        this.studentList = studentList;
        initComponents();
    }

    private void initComponents() {
        setSize(650, 450);
        setLocationRelativeTo(getParent());
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Add each report as a tab
        tabbedPane.addTab("Statistics Summary", createStatisticsPanel());
        tabbedPane.addTab("Top Performers", createTopPerformersPanel());
        tabbedPane.addTab("Grade Distribution", createGradeDistributionPanel());

        add(tabbedPane);
    }

    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        List<Student> students = studentList.getStudents();

        if (students.isEmpty()) {
            panel.add(new JLabel("No student data available."));
            return panel;
        }

        long passCount = students.stream().filter(Student::isPassed).count();
        double passRate = (double) passCount * 100.0 / students.size();
        double averageMarks = students.stream().mapToDouble(Student::getMarks).average().orElse(0.0);
        double minMarks = students.stream().mapToDouble(Student::getMarks).min().orElse(0.0);
        double maxMarks = students.stream().mapToDouble(Student::getMarks).max().orElse(0.0);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 15, 8, 15);
        gbc.anchor = GridBagConstraints.WEST;

        addStat(panel, gbc, 0, "Total Students:", String.valueOf(students.size()));
        addStat(panel, gbc, 1, "Pass Rate:", String.format("%.1f%% (%d students)", passRate, passCount));
        addStat(panel, gbc, 2, "Average Marks:", String.format("%.1f", averageMarks));
        addStat(panel, gbc, 3, "Minimum Marks:", String.format("%.1f", minMarks));
        addStat(panel, gbc, 4, "Maximum Marks:", String.format("%.1f", maxMarks));

        return panel;
    }

    private JScrollPane createTopPerformersPanel() {
        List<Student> topPerformers = studentList.getStudents().stream()
                .filter(s -> s.getMarks() >= 85)
                .collect(Collectors.toList());

        String[] columnNames = {"Name", "Student ID", "Marks", "Grade"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Student s : topPerformers) {
            model.addRow(new Object[]{s.getName(), s.getStudentID(), s.getMarks(), s.getGrade()});
        }

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        return new JScrollPane(table);
    }

    private JScrollPane createGradeDistributionPanel() {
        Map<String, Long> gradeCounts = studentList.getStudents().stream()
                .collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));

        String[] columnNames = {"Grade", "Number of Students", "Percentage"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        String[] gradeOrder = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
        long totalStudents = studentList.getStudents().size();

        for (String grade : gradeOrder) {
            if (gradeCounts.containsKey(grade)) {
                long count = gradeCounts.get(grade);
                double percentage = (double) count * 100.0 / totalStudents;
                model.addRow(new Object[]{grade, count, String.format("%.1f%%", percentage)});
            }
        }

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        return new JScrollPane(table);
    }

    private void addStat(JPanel panel, GridBagConstraints gbc, int y, String label, String value) {
        gbc.gridx = 0;
        gbc.gridy = y;
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(labelComponent, gbc);

        gbc.gridx = 1;
        gbc.gridy = y;
        JLabel valueComponent = new JLabel(value);
        valueComponent.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(valueComponent, gbc);
    }
}

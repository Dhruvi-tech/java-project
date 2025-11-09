/*
 * StudentApp.java - Main entry point for the Student Management System.
 * This file launches the Swing GUI application.
 * All modules (Dhruvi, Archana, Bimala) are integrated here.
 */

import Bimala.MainWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JWindow;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.*;

public class StudentApp {

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure GUI updates are done on the Event Dispatch Thread
        try {
            // Set system look and feel for a modern appearance
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Show splash screen
        JWindow splash = createSplashScreen();
        splash.setVisible(true);

        // Load main window in the background
        SwingUtilities.invokeLater(() -> {
            try {
                // Pause for a few seconds to make splash visible
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            splash.dispose(); // Close splash screen
            new MainWindow().setVisible(true);
        });
    }

    private static JWindow createSplashScreen() {
        JWindow splash = new JWindow();
        splash.setSize(450, 300);
        splash.setLocationRelativeTo(null);

        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 3));

        JLabel title = new JLabel("Student Management System", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        content.add(title, BorderLayout.CENTER);

        JPanel creditPanel = new JPanel(new GridLayout(1, 1));
        creditPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel loadingLabel = new JLabel("Loading application...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        creditPanel.add(loadingLabel);
        content.add(creditPanel, BorderLayout.SOUTH);
        splash.setContentPane(content);
        return splash;
    }
}
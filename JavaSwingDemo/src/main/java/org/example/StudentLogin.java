package org.example;

import javax.swing.*;
import java.awt.*;

public class StudentLogin {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentLogin::createAndShow);
    }

    private static void createAndShow() {
        // Step 1: window + heading (NORTH)
        JFrame frame = new JFrame("Campus Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(12, 12));

        JLabel heading = new JLabel("Campus Student Portal", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 20));
        heading.setForeground(new Color(25, 55, 109));
        heading.setBorder(BorderFactory.createEmptyBorder(16, 12, 8, 12));
        frame.add(heading, BorderLayout.NORTH);

        // Step 2: form with GridLayout(3, 2)
        JPanel form = new JPanel(new GridLayout(3, 2, 16, 18));
        form.setBorder(BorderFactory.createEmptyBorder(12, 24, 24, 24));

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton login = new JButton("Log in");

        form.add(new JLabel("Username"));
        form.add(username);
        form.add(new JLabel("Password"));
        form.add(password);
        form.add(new JLabel(""));
        form.add(login);

        frame.add(form, BorderLayout.CENTER);

        // Step 3: Login click listener
        login.addActionListener(e -> {
            String user = username.getText().trim();
            String pass = new String(password.getPassword());
            boolean ok = user.equals("student") && pass.equals("demo123");

            JOptionPane.showMessageDialog(
                    frame,
                    ok ? "Welcome, student!" : "Invalid login. Try again."
            );
        });

        frame.setSize(420, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

package org.example;

import javax.swing.*;

/**
 * Slide 10 — First mini program: one window, one button, one click message.
 */
public class FirstButton {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hello");
            JButton button = new JButton("Click me");

            button.addActionListener(e ->
                    JOptionPane.showMessageDialog(frame, "Hello from Java!"));

            frame.add(button);
            frame.setSize(350, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

package org.example.labsheet;

/**
 * Lab Q02 — EmailNotification implements Notification
 * Use: Notification email = new EmailNotification();
 *      email.send("Your results are available.");
 */
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

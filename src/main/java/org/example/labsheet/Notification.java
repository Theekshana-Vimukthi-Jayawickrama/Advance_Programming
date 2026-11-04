package org.example.labsheet;

/**
 * Lab Q02 — Interface (contract)
 * Use: Notification n = new EmailNotification();
 *      n.send("Your results are available.");
 */
public interface Notification {
    void send(String message);
}

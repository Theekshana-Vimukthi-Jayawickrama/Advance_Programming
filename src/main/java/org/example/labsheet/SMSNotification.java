package org.example.labsheet;

/**
 * Lab Q02 — SMSNotification implements Notification
 * Use: Notification sms = new SMSNotification();
 *      sms.send("Your results are available.");
 */
public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

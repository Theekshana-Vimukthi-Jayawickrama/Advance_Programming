package org.example.labsheet;

/**
 * Lab Q02 entry — Send Different Types of Notifications
 * Call from Main: InterfaceDemo.run();
 */
public class InterfaceDemo {

    public static void run() {
        // object: email — Notification as Email
        Notification email = new EmailNotification();
        email.send("Your results are available.");

        // object: sms — Notification as SMS
        Notification sms = new SMSNotification();
        sms.send("Your results are available.");
    }
}

package org.example.interfaces;

/**
 * Concept: implements an interface
 * Lecture idea: EmailSender keeps the MessageSender promise.
 *
 * Use: MessageSender email = new EmailSender();
 *      email.send("Meeting at 10");
 *
 * Note: send() must stay public (interface methods are public).
 */
public class EmailSender implements MessageSender {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

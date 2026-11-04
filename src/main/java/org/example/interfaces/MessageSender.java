package org.example.interfaces;

/**
 * Concept: Interface (contract / promise)
 * Lecture idea: Any MessageSender MUST provide send(message).
 *
 * Use: MessageSender sender = new EmailSender();  // or SmsSender
 *      sender.send("Hello");
 */
public interface MessageSender {
    void send(String message);
}

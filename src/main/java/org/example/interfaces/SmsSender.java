package org.example.interfaces;

/**
 * Concept: Same interface, different implementation
 * Lecture idea: SmsSender also follows MessageSender, but prints SMS style.
 *
 * Use: MessageSender sms = new SmsSender();
 *      sms.send("Event starts at 10");
 *
 * Tip: Later you can swap SmsSender ↔ EmailSender without changing call code.
 */
public class SmsSender implements MessageSender {

    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

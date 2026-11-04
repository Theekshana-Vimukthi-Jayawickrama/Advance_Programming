package org.example.multithreading;

/**
 * Concept: Create a thread by implementing Runnable (interface)
 * Lecture idea: Runnable = contract for the task; Thread = runner that executes it.
 *
 * Use: PrintTask task = new PrintTask();
 *      Thread t = new Thread(task);
 *      t.start();
 *
 * Link: This connects interfaces + multithreading (slide 29).
 */
public class PrintTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Task is running");
    }
}

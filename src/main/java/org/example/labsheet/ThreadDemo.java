package org.example.labsheet;

/**
 * Lab Q03 entry — Run Two Tasks at the Same Time
 * Call from Main: ThreadDemo.run();
 */
public class ThreadDemo {

    public static void run() throws InterruptedException {
        // object: t1 — runs PrintTask "Task A"
        Thread t1 = new Thread(new PrintTask("Task A"));
        // object: t2 — runs PrintTask "Task B"
        Thread t2 = new Thread(new PrintTask("Task B"));

        t1.start();
        t2.start();

        t1.join(); // wait until Task A finishes
        t2.join(); // wait until Task B finishes

        System.out.println("Finished");
    }
}

package org.example.multithreading;


public class JoinDemo {

    public static void runDemo() throws InterruptedException {
        // object: worker thread that prints when finished
        Thread t = new Thread(() -> System.out.println("Task finished"));

        t.start(); // start worker
        t.join();  // wait until worker ends
        System.out.println("All done");
    }
}

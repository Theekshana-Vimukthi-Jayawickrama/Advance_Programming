package org.example.multithreading;

/**
 * Concept: Thread.sleep() — pause the current thread
 * Lecture idea: Useful for demos; does NOT guarantee print order between threads.
 *
 * Use: Thread t = new Thread(new PauseTask());
 *      t.start();
 *
 * Note: sleep throws InterruptedException — restore interrupt flag if caught.
 */
public class PauseTask implements Runnable {

    @Override
    public void run() {
//        try {
//            Thread.sleep(500); // pause 0.5 second
//            System.out.println("After pause");
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        System.out.println("Task completed");
    }
}

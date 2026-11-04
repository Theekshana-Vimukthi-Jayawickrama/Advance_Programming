package org.example.labsheet;

/**
 * Lab Q03 — PrintTask implements Runnable
 * Use: Thread t = new Thread(new PrintTask("Task A"));
 *      t.start();
 */
public class PrintTask implements Runnable {

    private final String taskName;

    public PrintTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println(taskName + ": " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

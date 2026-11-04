package org.example.multithreading;

/**
 * Concept: Shared data / race condition + synchronized
 * Lecture idea: Two threads updating counter++ can lose updates without protection.
 *
 * Use: RaceCounter counter = new RaceCounter();
 *      counter.runUnsafeDemo();   // may lose updates
 *      counter.runSafeDemo();     // synchronized — safer
 *
 * Today: understand the risk; deeper sync comes later in the course.
 */
public class RaceCounter {

    private int counter = 0;

    // Unsafe: two threads can interleave and lose updates
    public void incrementUnsafe() {
        counter++;
    }

    // Safer: only one thread at a time enters this critical section
    public synchronized void incrementSafe() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public void reset() {
        counter = 0;
    }

    public void runUnsafeDemo() throws InterruptedException {
        reset();
        Runnable job = () -> {
            for (int i = 0; i < 10000; i++) {
                incrementUnsafe();
            }
        };

        Thread t1 = new Thread(job); // object: first worker
        Thread t2 = new Thread(job); // object: second worker
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Unsafe counter (expect 20000): " + getCounter());
    }

    public void runSafeDemo() throws InterruptedException {
        reset();
        Runnable job = () -> {
            for (int i = 0; i < 10000; i++) {
                incrementSafe();
            }
        };

        Thread t1 = new Thread(job); // object: first worker (safe)
        Thread t2 = new Thread(job); // object: second worker (safe)
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Safe counter (expect 20000): " + getCounter());
    }
}

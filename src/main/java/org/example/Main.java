package org.example;

import org.example.abstraction.Bus;
import org.example.abstraction.CampusTransport;
import org.example.abstraction.Van;
import org.example.interfaces.CampusPrinter;
import org.example.interfaces.EmailSender;
import org.example.interfaces.MessageSender;
import org.example.interfaces.Printable;
import org.example.interfaces.Scannable;
import org.example.interfaces.SmsSender;
import org.example.labsheet.AbstractDemo;
import org.example.labsheet.InterfaceDemo;
import org.example.labsheet.ThreadDemo;
import org.example.multithreading.JoinDemo;
import org.example.multithreading.PauseTask;
import org.example.multithreading.PrintTask;
import org.example.multithreading.RaceCounter;
import org.example.multithreading.Worker;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        // =========================================================
        // LAB SHEET 3 — Abstraction | Interfaces | Multithreading
        // =========================================================

        // ----- Lab Q01: Abstract Classes (Shape / Circle / Rectangle) -----
        // System.out.println("=== Lab Q01: AbstractDemo ===");
        // AbstractDemo.run();

        // ----- Lab Q02: Interfaces (Notification / Email / SMS) -----
        // System.out.println("=== Lab Q02: InterfaceDemo ===");
        // InterfaceDemo.run();

        // ----- Lab Q03: Multithreading (PrintTask + join) -----
        // System.out.println("=== Lab Q03: ThreadDemo ===");
        // ThreadDemo.run();


        // =========================================================
        // LECTURE SLIDES — Abstraction | Interfaces | Multithreading
        // =========================================================

        // ----- Lecture 1: Abstract class (CampusTransport / Bus / Van) -----
//         System.out.println("=== Lecture 1: Abstract class ===");
//         CampusTransport bus = new Bus();   // object: bus
//         bus.showPurpose();
//         bus.move();
//         CampusTransport van = new Van();   // object: van
//         van.showPurpose();
//         van.move();

        // ----- Lecture 2: Interface (MessageSender / Email / SMS) -----
        // System.out.println("=== Lecture 2: Interface MessageSender ===");
        // MessageSender email = new EmailSender(); // object: email
        // email.send("Meeting at 10");
        // MessageSender sms = new SmsSender();     // object: sms
        // sms.send("Event starts at 10");

        // ----- Lecture 3: Multiple interfaces (CampusPrinter) -----
        // System.out.println("=== Lecture 3: Multiple interfaces ===");
        // CampusPrinter printer = new CampusPrinter(); // object: printer
        // printer.print();
        // printer.scan();
        // Printable printable = printer;   // object as Printable
        // Scannable scannable = printer;   // object as Scannable
        // printable.print();
        // scannable.scan();

        // ----- Lecture 4: Extend Thread (Worker) -----
//         System.out.println("=== Lecture 4: Extend Thread ===");
//         Worker worker = new Worker(); // object: worker
//         worker.start();               // use start(), not run()

        // ----- Lecture 5: Implement Runnable (PrintTask) -----
//         System.out.println("=== Lecture 5: Runnable PrintTask ===");
//         PrintTask task = new PrintTask();           // object: task
//         Thread taskThread = new Thread(task);       // object: taskThread
//         taskThread.start();

        // ----- Lecture 6: Output order not guaranteed -----
        // System.out.println("=== Lecture 6: Order not guaranteed ===");
//         Thread orderWorker = new Thread(() -> System.out.println("Worker")); // object: orderWorker
//         orderWorker.start();
//         // Thread.sleep(100); //addtional
//         System.out.println("Main");

        // ----- Lecture 7: Thread.sleep() (PauseTask) -----
        // System.out.println("=== Lecture 7: sleep() ===");
//         Thread pauseThread = new Thread(new PauseTask()); // object: pauseThread
//         pauseThread.start();
//         pauseThread.join();
//        System.out.println("Main thread completed");

        // ----- Lecture 8: join() -----
        // System.out.println("=== Lecture 8: join() ===");
        // JoinDemo.runDemo();

        // ----- Lecture 9: Race condition vs synchronized -----
        // System.out.println("=== Lecture 9: Race / synchronized ===");
         RaceCounter counter = new RaceCounter(); // object: counter
         counter.runUnsafeDemo();
         counter.runSafeDemo();


    }
}

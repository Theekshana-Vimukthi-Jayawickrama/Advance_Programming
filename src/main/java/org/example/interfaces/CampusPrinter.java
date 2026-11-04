package org.example.interfaces;

/**
 * Concept: One class implements multiple interfaces
 * Lecture idea: A device can have more than one capability.
 *
 * Use: CampusPrinter printer = new CampusPrinter();
 *      printer.print();
 *      printer.scan();
 *
 * Or via interface types:
 *      Printable printable = printer;
 *      Scannable scannable = printer;
 */
public class CampusPrinter implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}

package org.example.abstraction;

/**
 * Concept: Another concrete subclass (same abstract parent, different move)
 * Lecture idea: Bus and Van share transport details, but move their own way.
 *
 * Use: CampusTransport v = new Van();
 *      v.showPurpose();
 *      v.move();
 */
public class Van extends CampusTransport {

    @Override
    public void move() {
        System.out.println("Van drives");
    }
}

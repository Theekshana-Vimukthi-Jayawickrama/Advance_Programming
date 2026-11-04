package org.example.abstraction;

/**
 * Concept: Concrete subclass with extends
 * Lecture idea: Bus completes the CampusTransport blueprint.
 *
 * Use: CampusTransport t = new Bus();
 *      t.showPurpose();
 *      t.move();
 */
public class Bus extends CampusTransport {

    @Override
    public void move() {
        System.out.println("Bus drives");
    }
}

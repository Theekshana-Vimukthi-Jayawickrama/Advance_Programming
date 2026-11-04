package org.example.labsheet;

/**
 * Lab Q01 entry — Calculate the Area of Shapes
 * Call from Main: AbstractDemo.run();
 */
public class AbstractDemo {

    public static void run() {
        // object: shape1 — Circle via abstract Shape reference
        Shape shape1 = new Circle(3);
        shape1.showArea();

        // object: shape2 — Rectangle via abstract Shape reference
        Shape shape2 = new Rectangle(4, 5);
        shape2.showArea();
    }
}

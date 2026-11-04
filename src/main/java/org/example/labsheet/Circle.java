package org.example.labsheet;

/**
 * Lab Q01 — Circle extends Shape
 * Use: Shape shape1 = new Circle(3);
 *      shape1.showArea();  // Area: 28.27
 */
public class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

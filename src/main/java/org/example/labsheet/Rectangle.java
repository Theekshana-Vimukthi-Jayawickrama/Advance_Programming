package org.example.labsheet;

/**
 * Lab Q01 — Rectangle extends Shape
 * Use: Shape shape2 = new Rectangle(4, 5);
 *      shape2.showArea();  // Area: 20.00
 */
public class Rectangle extends Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

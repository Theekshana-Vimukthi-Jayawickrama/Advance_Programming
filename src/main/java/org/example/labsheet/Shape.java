package org.example.labsheet;

/**
 * Lab Q01 — Abstract class
 * Use: Shape s = new Circle(3);  OR  Shape s = new Rectangle(4, 5);
 *      s.showArea();
 */
public abstract class Shape {

    public abstract double area();

    public void showArea() {
        System.out.printf("Area: %.2f%n", area());
    }
}

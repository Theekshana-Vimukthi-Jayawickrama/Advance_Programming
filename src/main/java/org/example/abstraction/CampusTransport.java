package org.example.abstraction;

/**
 * Concept: Abstract Class (Abstraction)
 * Lecture idea: Campus transport blueprint — WHAT is shared, HOW can differ.
 *
 * Use: Do NOT create with "new CampusTransport()".
 *      Create a concrete subclass like Bus or Van, then call methods.
 */
public abstract class CampusTransport {

    // Concrete method — shared by every subclass (common code)
    public void showPurpose() {
        System.out.println("Campus travel");
    }

    // Abstract method — no body here; each subclass must implement HOW it moves
    public abstract void move();
}

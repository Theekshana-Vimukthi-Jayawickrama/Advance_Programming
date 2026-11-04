public class AgeCheck {
    static void validateAge(int age)
            throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException(
                    "Age must be at least 18");
        }
    }
    public static void main(String[] args) {
        try { validateAge(16); }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }}
}

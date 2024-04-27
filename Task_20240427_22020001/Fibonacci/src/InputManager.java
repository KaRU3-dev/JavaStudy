import java.util.Scanner;

public class InputManager {

    /**
     * Get a number from the user
     * @return int
     */
    public int Number() {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Read user input (with input validation)
        int number = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a number: ");
            try {
                number = scanner.nextInt();

                if (number > 3) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number greater than 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        // Close the Scanner object
        scanner.close();

        return number;
    }
}

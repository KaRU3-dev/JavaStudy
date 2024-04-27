import java.util.Scanner;

public class Input {
    /**
     * Request method
     * @param times   Number of times to request
     * @param stdIn   Scanner class
     * @param numbers Array of input numbers
     */
    public void Request(int times, Scanner stdIn, int[] numbers) {
        System.out.println("Please enter " + times + " numbers");
        for (int i = 0; i < times; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = stdIn.nextInt();
        }
    }
}

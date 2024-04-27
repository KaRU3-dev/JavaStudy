import java.util.Random;
import java.util.Scanner;

public class Index {

    /**
     * Random class
     */
    private Random random = new Random();
    /**
     * Scanner class
     */
    private Scanner stdIn = new Scanner(System.in);

    /**
     * Input class
     */
    private Input input = new Input();
    /**
     * Generator class
     */
    private Generator generator = new Generator();
    /**
     * Checker class
     */
    private Checker checker = new Checker();

    /**
     * Array of input numbers
     */
    public int[] Numbers = new int[5];
    /**
     * Random number
     */
    public int RandomNumber = 0;

    public void Run() {
        // Request 5 numbers
        input.Request(5, stdIn, Numbers);

        // Generate a random number
        RandomNumber = generator.RandomInt(random, 1, 100);

        // Check if the random number is in the array
        checker.SameNumber(Numbers, RandomNumber);
    }
}

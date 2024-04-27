public class Index {

    /**
     * InputManager class
     */
    private InputManager inputManager = new InputManager();

    /**
     * Number of elements in Fibonacci Array
     */
    public int ArrayIndexNumber = 3;

    /**
     * Fibonacci Array
     */
    public int FibonacciArray[];

    /**
     * Run the application
     * @param args
     */
    public void Run(String[] args) {
        // Input Array index number
        ArrayIndexNumber = inputManager.Number();

        // Create Fibonacci Array
        FibonacciArray = new int[ArrayIndexNumber];

        // Set first 2 elements of Fibonacci Array
        FibonacciArray[0] = 1;
        FibonacciArray[1] = 1;

        // Calculate Fibonacci Array elements
        for (int i = 2; i < ArrayIndexNumber; i++) {
            FibonacciArray[i] = FibonacciArray[i - 1] + FibonacciArray[i - 2];
        }

        // Display Fibonacci Array
        for (int i = 0; i < ArrayIndexNumber; i++) {
            System.out.println(FibonacciArray[i]);
        }
    }
}

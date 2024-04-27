public class Checker {
    /**
     * Check if the random number is in the array
     * @param numbers     Array of input numbers
     * @param randomNumber Random number
     */
    public void SameNumber(int[] numbers, int randomNumber) {
        // Check if the random number is in the array
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == randomNumber) {
                System.out.println("The random number " + randomNumber + " is in the array");
                return;
            }
        }
        System.out.println("The random number " + randomNumber + " is not in the array");
    }
}

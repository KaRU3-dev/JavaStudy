import java.util.Random;

public class Generator {
    /**
     * Generate a random integer
     * @param rnd Random class
     * @param min Minimum value
     * @param max Maximum value
     * @return Random number
     */
    public int RandomInt(Random rnd, int min, int max) {
        // Generate a random number
        return rnd.nextInt(min, max) + 1;
    }
}

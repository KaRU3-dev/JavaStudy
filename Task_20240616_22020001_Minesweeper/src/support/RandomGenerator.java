package support;

import java.util.Random;

public class RandomGenerator {

    public static Random random = new Random();

    public static int randomInt(int min, int max) {
        return random.nextInt(min, max);
    }
}

package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Data {
    /**
     * Generate random
     */
    public static Random random   = new Random();
    /**
     * Input scanner
     */
    public static Scanner scanner = new Scanner(System.in);
    /**
     * Game director
     */
    public static Director director  = new Director();
    /**
     * Player list (now only one)
     */
    public static List<Players> players     = new ArrayList<Players>();
    public static List<Players> winedPlayers = new ArrayList<Players>();

    /**
     * Game start flag
     */
    public static boolean isStart = false;

    /**
     * These numbers are already picked
     */
    public static List<Integer> pickedNumbers = new ArrayList<Integer>();

    /**
     * Bingo card width
     */
    public static int cardWidth  = 7;
    /**
     * Bingo card height
     */
    public static int cardHeight = 7;

    /**
     * Number of pickable minimum number
     */
    public static int cardMinimumNumber = 1;
    /**
     * Number of pickable maximum number
     */
    public static int cardMaximumNumber = 99;
    /**
     * Hitted number cell flag
     */
    public static int hittedNumber = 0;
}

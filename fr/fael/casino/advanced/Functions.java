package fr.fael.casino.advanced;

import java.util.Random;
import java.util.Set;

public class Functions {

    private static final Set<Integer> rougeValue = Set.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);
    private static final Random random = new Random();

    public static int getRandomInt(int maxInt) {
        return random.nextInt(maxInt);
    }
    
    public static String getColor(int number) {
        return number == 0 ? "Vert" : (rougeValue.contains(number) ? "Rouge" : "Noir");
    }

    public static int roulette() {
        return getColor(getRandomInt(37)).equals("Noir") ? 1 : 0;
    }

    public static double getTime(int games) {
        return (games * 140) / 3600.0;
    }

    public static void log(String message) {
        System.out.println(message);
    }

    public static String roulette2() {
        int number = getRandomInt(37);
        return number + " " + getColor(number);
    }
}

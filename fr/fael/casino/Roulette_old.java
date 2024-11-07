package fr.fael.learn;

import java.util.Set;
import java.util.Random;

public class Learning {

    static double wallet = 128;
    static double mise = 10.42;
    static double benefice = 16;
    static double baseWallet = wallet;
    
    static double final_benefice = ((wallet * benefice) / 100) + wallet;

    static final Set<Integer> rougeValue = Set.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);
    static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        start();
    }

    private static void log(String message) {
        System.out.println(message);
    }

    private static String getColor(int number) {
        return number == 0 ? "Vert" : (rougeValue.contains(number) ? "Rouge" : "Noir");
    }

    public static void start() throws InterruptedException {
        Thread.sleep(1000);

        double actualMise = mise;
        double miseMax = mise;
        double sommeMax = wallet;
        int miseMaxIteration = 0;

        for (int value = 0; wallet > 0 && wallet < final_benefice; value++) {
            if (wallet < actualMise) {
                break;
            }
            
            wallet -= actualMise;
            int number = random.nextInt(36);
            String color = getColor(number);

            log("Tour: " + value + " | " + color + " - " + number + " | Mise: " + actualMise + "€ | Monnaie: " + wallet + "€");

            if ("Noir".equalsIgnoreCase(color)) {
                wallet += actualMise * 2;
                sommeMax = Math.max(sommeMax, wallet);
                actualMise = mise;
            } else {
                actualMise *= 2;
                if (actualMise > miseMax) {
                    miseMax = actualMise;
                    miseMaxIteration = value + 1;
                }
            }
        }
        
        if (wallet >= final_benefice) {
            log("Victoire !");
        } else {
            log("Vous avez perdu !");
        }

        log("-----------------------");
        log("Mise Max: " + miseMax + "€ | Itération: " + miseMaxIteration);
        log("Somme Max: " + sommeMax + "€");
        log("Bénéfice: " + (sommeMax - baseWallet) + "€");
        log("-----------------------");

        wallet = sommeMax;
    }
}


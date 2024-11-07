package fr.fael.casino.advanced;

import fr.fael.casino.nodes.Nodes1;
import fr.fael.casino.nodes.Nodes2;

public class Main {
    
    public static double wallet = 128;
    public static double mise = 1;
    public static double benefice = 1000; // en %
    
    public static double final_benefice = ((wallet * benefice) / 100) + wallet;
    
    public static void main(String[] args) throws InterruptedException {
        double winrate = Nodes1.N1();
        double totalMise = 0;
        int iterations = 0;
        double previousAverage = 0;
        int stableIterations = 0;
        final int stabilityThreshold = 50;
        final double precisionThreshold = 0.0001;

        while (stableIterations < stabilityThreshold) {
            iterations++;
            totalMise += Nodes2.N2(winrate);
            
            double currentAverage = totalMise / iterations;
            
            if (Math.abs(currentAverage - previousAverage) < (previousAverage * precisionThreshold)) {
                stableIterations++;
            } else {
                stableIterations = 0;
            }

            previousAverage = currentAverage;

            if (iterations % 100 == 0) {
                Functions.log("Tour: " + iterations + ", Mise moyenne actuelle: " + currentAverage + "€");
            }
        }
        
        double finalAverageMise = totalMise / iterations;
        Functions.log("Mise optimale moyenne pour le bénéfice choisi après " + iterations + " itérations: " + finalAverageMise + "€");
        Functions.log("Avec un winrate potentiel à " + winrate + "%");
    }
}

package fr.fael.casino.advanced;

import fr.fael.casino.nodes.Nodes1;

public class Main {

    public static double wallet = 1000;
    public static double mise = 1; // Mise initiale faible
    public static double benefice = 50; // en %

    public static double final_benefice = ((wallet * benefice) / 100) + wallet;
    public static double mise_max = 75000;

    public static void main(String[] args) throws InterruptedException {
    	Functions.log("Resultat: " + Nodes1.N1());
        /*double winrate = Nodes1.N1();
        double totalBestMise = 0;
        int iterations = 0;
        double previousAverage = 0;
        int stableIterations = 0;
        final int stabilityThreshold = 50;
        final double precisionThreshold = 0.0001;

        while (stableIterations < stabilityThreshold) {
            iterations++;
            double bestMise = Nodes2.N2(winrate, mise);
            totalBestMise += bestMise;

            double currentAverage = totalBestMise / iterations;

            if (Math.abs(currentAverage - previousAverage) < (previousAverage * precisionThreshold)) {
                stableIterations++;
            } else {
                stableIterations = 0;
            }

            previousAverage = currentAverage;
            Functions.log("Tour: " + iterations + ", Mise moyenne actuelle: " + currentAverage + "€");
        }

        double finalAverageMise = totalBestMise / iterations;
        Functions.log("Mise optimale moyenne pour le bénéfice choisi après " + iterations + " itérations: " + finalAverageMise + "€");
        Functions.log("Avec un winrate potentiel à " + winrate + "%");*/
    }
}

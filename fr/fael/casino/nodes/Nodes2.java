package fr.fael.casino.nodes;

import fr.fael.casino.advanced.Main;
import fr.fael.casino.advanced.strats.Martingale;

public class Nodes2 {
    
    static double wallet = Main.wallet;
    static double benefice = Main.final_benefice;
    
    public static double N2(double winrate, double initialMise) { // Ajout d'un paramètre pour la mise initiale
        double bestMise = 0;
        double highestSuccessRate = 0;
        
        for (double mise = initialMise; mise <= 200; mise += 10) { // Utilisation de la mise de départ
            int successfulRuns = 0;
            
            for (int j = 0; j < 100; j++) {
                double currentMise = mise;
                double tempWallet = wallet;
                
                while (tempWallet > currentMise && tempWallet < benefice) {
                    int result = Martingale.martingale(tempWallet, currentMise, benefice);
                    if (result == 1) {
                        successfulRuns++;
                        break;
                    } else {
                        currentMise *= 2;
                        if (currentMise > tempWallet) break;
                    }
                }
            }
            
            double currentSuccessRate = (double) successfulRuns / 100;
            
            if (currentSuccessRate > highestSuccessRate) {
                highestSuccessRate = currentSuccessRate;
                bestMise = mise;
            }
        }
        return bestMise;
    }

    public static double moyenneMeilleureMise(double winrate, int iterations, double initialMise) {
        double totalBestMise = 0;
        
        for (int i = 0; i < iterations; i++) {
            double bestMiseForRun = N2(winrate, initialMise);
            totalBestMise += bestMiseForRun;
        }
        
        return totalBestMise / iterations;
    }
}

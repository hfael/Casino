package fr.fael.casino.nodes;

import fr.fael.casino.advanced.Main;
import fr.fael.casino.advanced.strats.Martingale;

public class Nodes2 {
    
    static double wallet = Main.wallet;
    static double benefice = Main.final_benefice;
    
    public static double N2(double winrate) {
        double bestMise = 0;
        double highestSuccessRate = 0;
        
        for (double initialMise = 10; initialMise <= 200; initialMise += 10) {
            int successfulRuns = 0;
            
            for (int j = 0; j < 100; j++) {
                double mise = initialMise;
                double tempWallet = wallet;
                
                while (tempWallet > mise && tempWallet < benefice) {
                    int result = Martingale.martingale(tempWallet, mise, benefice);
                    if (result == 1) {
                        successfulRuns++;
                        break;
                    } else {
                        mise *= 2;
                        if (mise > tempWallet) break;
                    }
                }
            }
            
            double currentSuccessRate = (double) successfulRuns / 100;
            
            if (currentSuccessRate > highestSuccessRate) {
                highestSuccessRate = currentSuccessRate;
                bestMise = initialMise;
            }
        }
        return bestMise;
    }

    public static double moyenneMeilleureMise(double winrate, int iterations) {
        double totalBestMise = 0;
        
        for (int i = 0; i < iterations; i++) {
            double bestMiseForRun = N2(winrate);
            totalBestMise += bestMiseForRun;
        }
        
        double averageBestMise = totalBestMise / iterations;
        return averageBestMise;
    }
}

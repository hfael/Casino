package fr.fael.casino.advanced.strats;

import fr.fael.casino.advanced.Functions;
import fr.fael.casino.advanced.Main;

public class Martingale {

    private static final double baseBenefice = Main.final_benefice;

    public static int martingale(double wallet, double mise, double benefice) {
        double actualMise = mise;

        while (wallet < baseBenefice && wallet > actualMise) {
            wallet -= actualMise;
            
            if (actualMise > Main.mise_max) {
                return 0;
            }

            int rouletteResult = Functions.roulette();
            if (rouletteResult == 1) {
                wallet += actualMise * 2;
                actualMise = mise;
            } else {
                actualMise *= 2;
            }
        }
        return 0;
    }
}

package fr.fael.casino.advanced.strats;

import fr.fael.casino.advanced.Functions;
import fr.fael.casino.advanced.Main;

public class Martingale {

    private static final double baseWallet = Main.wallet;
    private static final double baseBenefice = Main.final_benefice;

    public static int martingale(double wallet, double mise, double benefice) {
        double walletMax = wallet;
        double actualMise = mise;


        while (wallet < baseBenefice) {
            wallet -= actualMise;
            int roulette = Functions.roulette();


            if (roulette == 1) {
                wallet += actualMise * 2;
                actualMise = mise;
            } else {
                actualMise *= 2;
            }

            walletMax = Math.max(walletMax, wallet);

            if (wallet <= 0) {
                return 0;
            }
        }
        return (wallet > baseWallet) ? 1 : 0;
    }
}

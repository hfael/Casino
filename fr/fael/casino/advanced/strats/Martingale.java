package fr.fael.casino.advanced.strats;

import fr.fael.casino.advanced.AdvancedMain;
import fr.fael.casino.advanced.Functions;

public class Martingale {

    public static void martingale(double wallet, double mise, double walletMax) {
        int iteration = 0;
        int win = 0;
        int loose = 0;
        double wallet_max = wallet;
        double actual_mise = mise;
        for(int i = 0; i != 100; i++) {
	        while (wallet < walletMax) {
	            int roulette = Functions.roulette();
	            iteration++;
	            wallet -= actual_mise;
	            
	            if (roulette == 1) {
	            	win += 1;
	                wallet += actual_mise * 2;
	                actual_mise = mise;
	            } else {
	            	loose += 1;
	                actual_mise *= 2;
	            }
	            
	            if (wallet > wallet_max) {
	                wallet_max = wallet;
	            }
	        }
	    }
        double winRate = (double) win / (win + loose) * 100;
        Functions.log("-----------------------------------");
        Functions.log(" ");
        Functions.log(iteration + "T | " + win + "W | " + loose + "L. | "+ winRate + "%.");
        Functions.log("Wallet maximum atteint : " + wallet_max + "€");
        double base_wallet = AdvancedMain.wallet;
        double benefice = wallet_max - base_wallet;
        Functions.log("Bénéfice: " + benefice + "€");
        Functions.log("Temps: " + Functions.getTime(iteration) + "h");
        Functions.log(" ");
        Functions.log("-----------------------------------");
        //return winRate;
    }
}

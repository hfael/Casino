package fr.fael.casino;

public class AdvancedCasino {

    public static void martingale(double wallet, double mise) {
        int iteration = 0;
        int win = 0;
        int loose = 0;
        double wallet_max = wallet;
        double actual_mise = mise;
        for(int i = 0; i != 100; i++) {
	        while (wallet > actual_mise) {
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
	            
	            //Functions.log(iteration + " | Mise: " + actual_mise + "€ | Wallet: " + wallet + "€");
	        }
	    }
        double winRate = (double) win / (win + loose) * 100;
        Functions.log("-----------------------------------");
        Functions.log(" ");
        Functions.log(iteration + "T | " + win + "W | " + loose + "L. | "+ winRate + "%.");
        Functions.log("Wallet maximum atteint : " + wallet_max + "€");
        Functions.log("Temps: " + Functions.getTime(iteration) + "h");
        Functions.log(" ");
        Functions.log("-----------------------------------");
    }
}

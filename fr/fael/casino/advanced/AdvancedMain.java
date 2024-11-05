package fr.fael.casino.advanced;

public class AdvancedMain {
	
	static double wallet = 15000;
	static double mise = 1;
	static double benefice = 2200;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		double final_benef = wallet + benefice;
		AdvancedCasino.martingale(wallet, mise, final_benef);
		/*double finalWR = 0;
		int iteration = 0;
		double winRate = 0;
		for(int i = 0; i != 100; i++) {	
			iteration++;
			winRate += AdvancedCasino.martingale(wallet, mise, walletMax);
		}
		finalWR = winRate / iteration;
		Functions.log("WR: " + finalWR + "%");*/
	}
}

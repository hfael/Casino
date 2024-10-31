package fr.fael.java;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Principale {
	
	// Pour statistique, Chance de perte & de gains avec la stratégie Martingale à la roulette.
	
	static double wallet = 128;
	static double mise =	1;
	static int iteration = 100;

	static double baseWallet = wallet;
	static int base_iteration = iteration;
	
	static Set<Integer> rougeValue = new HashSet<>(Set.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));

	public static void main(String[] args) throws InterruptedException {
		start();
	}
	
	public static void log(String string) {
		System.out.println(string);
	}
	
	public static String getColor(int i) {
		if(i == 0) {
			return "Vert";
		}else if(rougeValue.contains(i)) {
			return "Rouge";
		}else if(i > 0 && !rougeValue.contains(i)){
			return "Noir";
		}
		return null;
	}
	
	public static void start() throws InterruptedException {
		Thread.sleep(1000);
		double actualMise = mise;
		double miseMax = mise;
		double sommeMax = wallet;
		int  miseMaxIteration = 0;
		for(int value = 0; base_iteration >= value; value++) {
			if(wallet >= 0 && actualMise <= wallet) {
				wallet -= actualMise;
				Random random = new Random();
				int number = random.nextInt(36);
				log("Tour: " + value + " | " + getColor(number)  + " - " + number + " | Mise: " + actualMise + "€ | Monnaie: " + wallet + "€");
				if(getColor(number).equalsIgnoreCase("Noir")) {
					wallet += actualMise * 2;
					if(wallet > sommeMax) {
						sommeMax = wallet;
					}
						actualMise = mise;
					}else {
						actualMise = actualMise * 2;
						if(actualMise > miseMax) {
							miseMax = actualMise;
							miseMaxIteration = value + 1;
					}
				}
			}else {
				log("-----------------------");
				log("Vous n'avez plus d'argent !");
				log(" ");
				log("Perdu itération " + value);
				log(" ");
				log("Somme maximum: " + sommeMax + "€ (+" + (sommeMax-baseWallet)+"€)");
				log("-----------------------");
				value = iteration + 1;
				System.exit(1);
		}
	}
		log("-----------------------");
		log("Mise Max: " + miseMax + "€ | Itération: " + miseMaxIteration);
		log(" ");
		log("Somme Max: " + sommeMax + "€");
		log(" ");
		log("Bénéfice: " + (sommeMax - baseWallet) + "€");
		log("-----------------------");
		wallet = sommeMax;
		iteration += base_iteration;
		//start();
	}
}

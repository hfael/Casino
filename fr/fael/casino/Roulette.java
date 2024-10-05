package fr.fael.casino;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class Roulette {
	
	// Pour statistique, Chance de perte & de gains avec la stratégie Martingale à la roulette.
	
	static double wallet = 15000;
	static double mise =	5;
	static int iteration = 410;

	
	static int totalIteration = iteration;
	static double baseWallet = wallet;
	
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
		for(int value = 0; iteration >= value; value++) {
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
				log("Vous n'avez plus d'argent !");
				log("Perdu itération " + value);
				value = iteration + 1;
				System.exit(1);
		}
	}
		totalIteration += iteration;
		log("Mise Max: " + miseMax + " | Itération: " + miseMaxIteration);
		log("Somme Max: " + sommeMax);
		log("Bénéfice: " + (sommeMax - baseWallet));
		wallet = sommeMax;
		start();
	}
}

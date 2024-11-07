package fr.fael.casino.advanced;

import fr.fael.casino.nodes.Nodes1;

public class Main {
	
	public static double wallet = 5000;
	public static double mise = 100;
	public static double benefice = 400; // en %
	
	public static double final_benefice = ((wallet * benefice) / 100) + wallet;
	
	public static void main(String[] args) throws InterruptedException {
		//String result = Functions.roulette2();
		//Functions.log(result);
		Functions.log("\nTaux de chance d'y arriver: " + Nodes1.N1() + "%");
	}
}

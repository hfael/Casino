package fr.fael.casino;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		int number = Functions.getRandomInt(36);
		String color = Functions.getColor(number);
		Functions.log(number + " " + color);
	}

}

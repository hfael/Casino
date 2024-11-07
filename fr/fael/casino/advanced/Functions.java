package fr.fael.casino.advanced;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Functions {

	static Set<Integer> rougeValue = new HashSet<>(Set.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
	
	public static int getRandomInt(int maxInt) {
		Random random = new Random();
		int number = random.nextInt(maxInt);
		return number;
	}
	
	public static String getColor(int number) {
		if(number == 0) return "Vert";
		if(rougeValue.contains(number)) return "Rouge";
		return "Noir";
	}
	
	public static int roulette() {
		int a = getRandomInt(36);
		if(getColor(a).equalsIgnoreCase("Noir")) return 1;
		return 0;
	}
	
	public static double getTime(int games) {
		int time = (games * 140) / 3600;
		return time;
	}
	
	public static void log(String string) {
		System.out.println(string);
	}
	
	public static String roulette2() {
		int a = getRandomInt(36);
		String b = getColor(a);
		String c = a + " " + b;
		return c;
	}
}

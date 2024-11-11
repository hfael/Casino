package fr.fael.casino.nodes;

import fr.fael.casino.advanced.Functions;
import fr.fael.casino.advanced.Main;
import fr.fael.casino.advanced.strats.Martingale;

public class Nodes1 {
    private static final double baseWallet = Main.wallet;
    private static final double baseMise = Main.mise;
    private static final double baseBenefice = Main.final_benefice;

    public static int N1() {
        int victories = 0;
        for (int i = 0; i < 100; i++) {
        	Functions.log("a");
            if (Martingale.martingale(baseWallet, baseMise, baseBenefice) == 1) {
                victories++;
            	Functions.log("b " + victories);
            }
        }
        return victories;
    }
}

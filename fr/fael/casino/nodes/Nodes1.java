package fr.fael.casino.nodes;

import fr.fael.casino.advanced.Main;
import fr.fael.casino.advanced.strats.Martingale;

public class Nodes1 {

    private static final double baseWallet = Main.wallet;
    private static final double baseMise = Main.mise;
    private static final double baseBenefice = Main.final_benefice;

    public static double N1() {
        double victory = 0;

        for (int i = 0; i < 100; i++) {
            int result = Martingale.martingale(baseWallet, baseMise, baseBenefice);
            if(result == 1) {
                victory++;
            }
        }
        return victory;
    }
}

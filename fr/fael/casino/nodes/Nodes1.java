package fr.fael.casino.nodes;

import fr.fael.casino.advanced.Functions;
import fr.fael.casino.advanced.Main;
import fr.fael.casino.advanced.strats.Martingale;

public class Nodes1 {

    private static final double baseWallet = Main.wallet;
    private static final double baseMise = Main.mise;
    private static final double baseBenefice = Main.final_benefice;

    public static double N1() {
        int victory = 0;
        int iteration = 0;
        //Functions.log("Bénéfice ciblé: " + baseBenefice + " soit " + Main.benefice + "% de " + baseWallet + ".");

        for (int i = 0; i < 100; i++) {
            iteration++;
            int result = Martingale.martingale(baseWallet, baseMise, baseBenefice);
            if(result == 1) {
                victory++;
                //Functions.log("Victoire à l'itération " + iteration + ". Total de victoires : " + victory);
            } else {
                //Functions.log("Échec à l'itération " + iteration + ". Total de victoires : " + victory);
            }
        }

        Functions.log("Nombre total de victoires après 100 tentatives: " + victory);
        return victory;
    }

}

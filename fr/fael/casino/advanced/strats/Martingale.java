package fr.fael.casino.advanced.strats;

import fr.fael.casino.advanced.Functions;
import fr.fael.casino.advanced.Main;

public class Martingale {

    private static final double baseWallet = Main.wallet;
    private static final double baseBenefice = Main.final_benefice;

    public static int martingale(double wallet, double mise, double benefice) {
        double walletMax = wallet;
        double actualMise = mise;

        //Functions.log("Démarrage de la martingale avec wallet=" + wallet + ", mise=" + mise + ", objectif bénéfice=" + benefice);

        while (wallet < baseBenefice) {
            wallet -= actualMise;
            int roulette = Functions.roulette();

            //Functions.log("Résultat roulette: " + (roulette == 1 ? "Gagné" : "Perdu") + ", Mise actuelle: " + actualMise + ", Wallet après mise: " + wallet);

            if (roulette == 1) {
                wallet += actualMise * 2;
                actualMise = mise;
                //Functions.log("Victoire! Nouveau wallet: " + wallet);
            } else {
                actualMise *= 2;
                //Functions.log("Défaite. Double la mise pour la prochaine: " + actualMise);
            }

            walletMax = Math.max(walletMax, wallet);

            if (wallet <= 0) {
            	//Functions.log("Portefeuille épuisé, martingale échouée.");
                return 0;
            }
        }

        //Functions.log("Martingale réussie, objectif atteint avec wallet=" + wallet);
        return (wallet > baseWallet) ? 1 : 0;
    }
}

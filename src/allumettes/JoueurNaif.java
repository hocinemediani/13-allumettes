package allumettes;

import java.util.Random;

public class JoueurNaif extends Joueur {

    /** Creates an instance of JoueurNaif. A naive
     * player will randomly withdraw an amount of matches
     * between 1 and 3 without generating any errors.
     */
    public JoueurNaif() {
        super("Ordinateur");
    }


    @Override
    public int getPrise(Jeu jeu) {
        Random randomNumber = new Random();
        int maxTake = Math.max(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
        return randomNumber.nextInt(maxTake) + 1;
    }

}

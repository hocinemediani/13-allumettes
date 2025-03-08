package allumettes;

import java.util.Random;

public class Naif extends Joueur implements Strategie {

    /** Creates an instance of JoueurNaif. A naive
     * player will randomly withdraw an amount of matches
     * between 1 and PRISE_MAX without generating any errors.
     * @param name The name of the player
     */
    public Naif(String name) {
        super(name);
    }


    @Override
    public int getPrise(Jeu jeu) {
        Random randomNumber = new Random();
        int maxTake = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
        return randomNumber.nextInt(maxTake) + 1;
    }

}

package allumettes;

import java.util.Random;

public class Expert extends Joueur implements Strategie {

    /** Variable used to calculate the best move */
    private static final int MODULO = Jeu.PRISE_MAX + 1;


    /** Creates an instance of JoueurExpert. An
     * expert player will always make the best move
     * available, or withdraw a random amount of
     * matches if he can't play the current best move.
     * @param name The name of the player
     */
    public Expert(String name) {
        super(name);
    }


    @Override
    public int getPrise(Jeu jeu) {
        int toWithdraw;
        if (jeu.getNombreAllumettes() % MODULO == 1) {
            Random randomNumber = new Random();
            int maxTake = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
            toWithdraw = randomNumber.nextInt(maxTake) + 1;
        } else {
            toWithdraw = ((jeu.getNombreAllumettes() % MODULO - 1) + MODULO) % MODULO;
        }
        return toWithdraw;
    }

}

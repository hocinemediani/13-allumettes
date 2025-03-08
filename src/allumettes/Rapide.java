package allumettes;

public class Rapide extends Joueur implements Strategie {

    /** Creates an instance of JoueurRapide. A quick
     * player will always take the maximum amount of
     * matches he can take without generating errors.
     * @param name The name of the player
     */
    public Rapide(String name) {
        super(name);
    }


    @Override
    public int getPrise(Jeu jeu) {
        return Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
    }

}

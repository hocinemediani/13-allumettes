package allumettes;

public class JoueurRapide extends Joueur {

    /** Creates an instance of JoueurRapide. A quick
     * player will always take the maximum amount of
     * matches he can take without generating errors.
     */
    public JoueurRapide() {
        super("Ordinateur");
    }


    @Override
    public int getPrise(Jeu jeu) {
        return Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
    }

}

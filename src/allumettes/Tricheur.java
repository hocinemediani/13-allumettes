package allumettes;

public class Tricheur extends Joueur implements Strategie {

    /** Creates an instance of JoueurTricheur. A cheating
     * player will try to set the number of matches to 2
     * then take one to win. He may be caught by the referee
     * depending on the presence or not of the "-confiant"
     * parameter.
     * @param name The name of the player
     */
    public Tricheur(String name) {
        super(name);
    }


    @Override
    public int getPrise(Jeu jeu) {
        System.out.println("[Je triche ...]");
        try {
            while (jeu.getNombreAllumettes() > 2) {
                jeu.retirer(1);
            }
        } catch (CoupInvalideException e) {
        }
        System.out.println("[Allumettes restantes : 2]");
        return 1;
    }

}

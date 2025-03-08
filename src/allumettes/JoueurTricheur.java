package allumettes;

public class JoueurTricheur extends Joueur {

    public JoueurTricheur(String name) {
        super(name);
    }

    @Override
    public int getPrise(Jeu jeu) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

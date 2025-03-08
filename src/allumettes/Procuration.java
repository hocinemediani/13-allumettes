package allumettes;

public class Procuration implements Jeu {

    /** The real game that is played */
    private final Jeu jeu;
    /** A boolean used to create or not the proxy */
    private final boolean modeConfiant;
    /** A boolean used to detect a cheating human */
    private boolean tricheHumaine;


    /** Creates an instance of Procuration.
     * A procuration is the top layer of the game,
     * that handles requests and let them pass through
     * the real game if they are supported.
     * @param jeu The real game that is played
     * @param modeConfiant A boolean used to create or not the proxy
     */
    public Procuration(Jeu jeu, boolean modeConfiant) {
        this.jeu = jeu;
        this.modeConfiant = modeConfiant;
    }


    /** Sets tricheHumain to true */
    public void setTriche() {
        this.tricheHumaine = true;
    }


    @Override
    public int getNombreAllumettes() {
        return jeu.getNombreAllumettes();
    }


    @Override
    public void retirer(int nbPrises) throws CoupInvalideException,
    OperationInterditeException {
        // Récupération des stacks frames
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // L'appelant intervient en deuxième
        // (Procuration => Joueur => Arbitre => Arbitre => Jouer)
        String caller = stackTrace[2].getClassName();

        if (!modeConfiant & (caller.contains("Tricheur") || tricheHumaine)) {
            throw new OperationInterditeException("triche");
        }

        jeu.retirer(nbPrises);
    }

}

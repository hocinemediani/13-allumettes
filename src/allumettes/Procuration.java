package allumettes;

public class Procuration extends JeuReel {
    
    /** Creates an instance of Procuration.
     * A procuration is the top layer of the game,
     * that handles requests and let them pass through
     * the real game if they are supported.
     * @param matches The initial number of matches
     */
    public Procuration(int matches) {
        super(matches);
    }
    
    @Override
    public void retirer(int nbPrises) throws CoupInvalideException, OperationInterditeException{
        // Récupération de la stackTrace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // L'appelant intervient en deuxième (Procuration => Appelant => Arbitre
        // => Arbitre => Jouer)
        String caller = stackTrace[2].getClassName();

        if (caller.contains("Tricheur")) {
            throw new OperationInterditeException("triche");
        }
        
        super.retirer(nbPrises);
    }

}

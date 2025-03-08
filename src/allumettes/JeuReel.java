package allumettes;

public class JeuReel implements Jeu {

    /** Stores the number of matches currently on the board */
    private int matches;

    /** Creates an instance of JeuReel. The game can be
     * initialized with any match number on the board.
     * @param matches The initial number of matches
     */
    public JeuReel(int matches) {
        this.matches = matches;
    }


    @Override
    public int getNombreAllumettes() {
        return matches;
    }

    /** Checks if a take is legal of not.
     * @param nbPrises The number of matches of the take
     * @return True if the take is legal
     */
    public boolean coupValide(int nbPrises) {
        return (nbPrises >= 1 & nbPrises <= Jeu.PRISE_MAX & nbPrises <= this.getNombreAllumettes() & this.getNombreAllumettes() - nbPrises >= 0);
    }


    @Override
    public void retirer(int nbPrises) throws CoupInvalideException {
            if (!coupValide(nbPrises)) {
                String condition = " (< 1)";
                String probleme;

                if (nbPrises > Jeu.PRISE_MAX) {
                    condition = " (> 3)";
                }
                if (nbPrises >= this.getNombreAllumettes()) {
                    condition = " (> " + this.getNombreAllumettes() + ")";
                }
                
                probleme = "Impossible ! Nombre invalide : " + nbPrises + condition;
                System.out.println(probleme);
                System.out.println();
                System.out.println("Allumettes restantes : " + getNombreAllumettes());
                throw new CoupInvalideException(nbPrises, probleme);
            } else {
                this.matches -= nbPrises;
            }
    }

}

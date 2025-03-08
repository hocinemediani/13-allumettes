package allumettes;

public class Joueur {

    /** Name of the player. */
    private final String name;

    /** Strategy of the player */
    private Strategie strategy;


    /** Create a player from its name.
     * @param name The name of the player
     */
    public Joueur(String name) {
        this.name = name;
    }


    /** Sets the strategy of a player to the specified one.
     * @param strategy The new strategy of the player
     */
    public void setStrategie(Strategie strategy) {
        this.strategy = strategy;
    }


    /** Returns the strategy of a player.
     * @return The strategy of the player
     */
    public Strategie getStrategie() {
        return this.strategy;
    }


    /** Returns the name of a player.
     * @return The name of the player
     */
    public String getNom() {
        return this.name;
    }


    public int getPrise(Jeu jeu) {
        return this.strategy.getPrise(jeu);
    }

}

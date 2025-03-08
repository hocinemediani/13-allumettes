package allumettes;

public abstract class Joueur {

    /** Name of the player. */
    private String name;


    /** Create a player from its name.
     * @param name The name of the player
     */
    public Joueur(String name) {
        this.name = name;
    }


    /** Returns the name of a player.
     * @return The name of the player
     */
    public String getNom() {
        return this.name;
    }


    /** Abstract method to get the number of matches
     * to withdraw depending on the player's strategy.
     * @param jeu The game this player belongs to
     * @return The number of matches the player wants
     * to withdraw
     */
    public abstract int getPrise(Jeu jeu);

}

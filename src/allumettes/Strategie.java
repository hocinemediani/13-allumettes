package allumettes;

public interface Strategie {
    
    /** Abstract method to get the number of matches
     * to withdraw depending on the player's strategy.
     * @param jeu The game this player belongs to
     * @return The number of matches the player wants
     * to withdraw
     */
    public int getPrise(Jeu jeu);

}

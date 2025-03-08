package allumettes;

public class Arbitre {

    /** First player of the game. */
    private Joueur player1;
    /** Second player of the game. */
    private Joueur player2;
    /** The player who's turn it is. */
    private Joueur currentPlayer;


    /** Creates a referee that is unique to a certain game
     * between two players. The referee displays the number
     * of matches remaining, asks the number of matches to
     * withdraw at each turn, changes the current player,
     * verifies the validity of each take and displays the
     * result at the end of the game.
     * @param j1 The first player of the game (first to play)
     * @param j2 The second player of the game
     */
    public Arbitre(Joueur j1, Joueur j2) {
        this.player1 = j1;
        this.player2 = j2;
        this.currentPlayer = j1;
    }

    /** Plays the game between two players.
     * @param jeu The game playing
     */
    public void arbitrer(Jeu jeu) {
        try {
            while (jeu.getNombreAllumettes() > 0) {
                System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
                this.playTurn(jeu);
                this.cycleTurn();
                System.out.println();
            }
            this.cycleTurn();
            System.out.println(this.currentPlayer.getNom() + " perd !");
            this.cycleTurn();
            System.out.println(this.currentPlayer.getNom() + " gagne !");
        } catch (OperationInterditeException e) {
            System.out.println("Abandon de la partie car " + currentPlayer.getNom()
            + " triche !");
        }
    }


    /** Asks the current player for the number of matches to withdraw.
     * Plays the turn if it is valid.
     * @param jeu The game playing
     */
    public void playTurn(Jeu jeu) {
        int toWithdraw;
        String allumettesString = "";

        if (currentPlayer.getStrategie() instanceof Humain) {
            System.out.print(currentPlayer.getNom() + ", combien d'allumettes ? ");
        }

        toWithdraw = currentPlayer.getStrategie().getPrise(jeu);
        if (toWithdraw > 1) {
            allumettesString = "s";
        }

        System.out.println(currentPlayer.getNom() + " prend " + toWithdraw + " allumette"
        + allumettesString + ".");

        // Verify the validity of the take
        try {
            jeu.retirer(toWithdraw);
        } catch (CoupInvalideException e) {
            this.playTurn(jeu);
        }
    }


    /** Cycles the turn in between player 1 and player 2. */
    public void cycleTurn() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

}

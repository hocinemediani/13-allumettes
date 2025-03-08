package allumettes;

import java.util.Scanner;

public class Humain extends Joueur implements Strategie {

    /** Scanner used to get input from the user */
    private final Scanner scanner;


    /** Creates an instance of JoueurHumain. The joueur
     * human represents a real player, communicating with
     * the program through the command prompt.
     * @param name The name of the player
     * @param scanner The scanner for the player
     */
    public Humain(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }


    @Override
    public int getPrise(Jeu jeu) {
        boolean isValid = false;
        int toWithdraw = 0;
        while (!isValid) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("triche")) {
                try {
                    ((Procuration) jeu).setTriche();
                } catch (ClassCastException e) {
                    // Only happens when a proxy isn't used
                }
                try {
                    jeu.retirer(1);
                } catch (CoupInvalideException e) {
                }
                System.out.println("[Une allumette en moins, plus que "
                + jeu.getNombreAllumettes() + ". Chut !]");
                System.out.print(super.getNom() + ", combien d'allumettes ? ");
            } else {
                try {
                    toWithdraw = Integer.parseInt(input);
                    isValid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Vous devez donner un entier.");
                    System.out.print(super.getNom() + ", combien d'allumettes ? ");
                }
            }
        }
        return toWithdraw;
    }

}

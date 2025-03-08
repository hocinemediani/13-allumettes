package allumettes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JoueurHumain extends Joueur {

    /** Scanner used to get input from the user */
    private Scanner scanner;


    /** Creates an instance of JoueurHumain. The joueur
     * human represents a real player, communicating with
     * the program through the command prompt.
     * @param name The name of the player
     * @param scanner The scanner for the player
     */
    public JoueurHumain(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }


    @Override
    public int getPrise(Jeu jeu) {
        boolean isValid = false;
        int toWithdraw = 8;
        while (!isValid) {
            try {
                toWithdraw = scanner.nextInt();
                scanner.nextLine();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Vous devez donner un entier.");
                System.out.print(super.getNom() + ", combien d'allumettes ? ");
                scanner.nextLine();
            }
        }
        return toWithdraw;
    }

}

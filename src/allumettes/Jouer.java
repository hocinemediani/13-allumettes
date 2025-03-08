package allumettes;

import java.util.Scanner;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	private static int MATCHES = 13;

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
		String[] argsPlayer1 = args[args.length - 2].split("@");
		String[] argsPlayer2 = args[args.length - 1].split("@");
		Jeu jeu = new JeuReel(MATCHES);
		Scanner scanner = new Scanner(System.in);
		Joueur j1 = initializePlayer(argsPlayer1[0], argsPlayer1[1], scanner);
		Joueur j2 = initializePlayer(argsPlayer2[0], argsPlayer2[1], scanner);
		Arbitre arbitre = new Arbitre(j1, j2);
		arbitre.arbitrer(jeu);
	}

	/** Creates an instance of player depending on its type.
	 * @param name The name of the player
	 * @param type The type of the player (naive, human, ...)
	 * @return A player with the correct name and type
	 */
	public static Joueur initializePlayer(String name, String type, Scanner scanner) {
		switch (type.toLowerCase()) {
			case "naif":
				return new JoueurNaif();
			case "rapide":
				return new JoueurRapide();
			case "expert":
				return new JoueurExpert();
			case "tricheur":
				return new JoueurTricheur(name);
			case "humain":
				return new JoueurHumain(name, scanner);
			default:
				throw new ConfigurationException("Erreur sur le nom de la stratégie");
		}
	}


	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}

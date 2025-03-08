package allumettes;

import java.util.Scanner;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	private static final int NUM_MATCHES = 13;

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
		String player1Args = args[args.length - 2];
		String player2Args = args[args.length - 1];
		boolean modeConfiant = args[0].equals("-confiant");
		Jeu jeu = modeConfiant ? new JeuReel(NUM_MATCHES) : new Procuration(NUM_MATCHES);
		Scanner scanner = new Scanner(System.in);
		Joueur j1 = initializePlayer(player1Args, scanner);
		Joueur j2 = initializePlayer(player2Args, scanner);
		Arbitre arbitre = new Arbitre(j1, j2);
		arbitre.arbitrer(jeu);
	}

	/** Creates an instance of player depending on its type.
	 * @param playerArgs The arguments passed to create the player
	 * in the form of "name@strategy"
	 * @param scanner The scanner used to get input from a human
	 * player
	 * @return A player with the correct name and type
	 */
	public static Joueur initializePlayer(String playerArgs, Scanner scanner) {
		String[] playerArgsArray = playerArgs.split("@");
		String name = playerArgsArray[0];
		String strategy = playerArgsArray[1];
		Joueur newPlayer = new Joueur(name);
		switch (strategy.toLowerCase()) {
			case "naif":
				newPlayer.setStrategie(new Naif(name));
				return newPlayer;
			case "rapide":
				newPlayer.setStrategie(new Rapide(name));
				return newPlayer;
			case "expert":
				newPlayer.setStrategie(new Expert(name));
				return newPlayer;
			case "tricheur":
				newPlayer.setStrategie(new Tricheur(name));
				return newPlayer;
			case "humain":
				newPlayer.setStrategie(new Humain(name, scanner));
				return newPlayer;
			default:
				throw new ConfigurationException("Erreur sur" +
				"le nom de la stratégie");
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

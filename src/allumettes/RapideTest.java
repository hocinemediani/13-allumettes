package allumettes;

import static org.junit.Assert.*;

public class RapideTest {

    public static void main(String[] args) {
        Jeu jeu0 = new JeuReel(13);
        Jeu jeu1 = new JeuReel(1);
        Jeu jeu2 = new JeuReel(2);
        Jeu jeu3 = new JeuReel(3);
        Rapide joueurRapide = new Rapide("Ordinateur");
        assertEquals(joueurRapide.getPrise(jeu0), 3);
        assertEquals(joueurRapide.getPrise(jeu1), 1);
        assertEquals(joueurRapide.getPrise(jeu2), 2);
        assertEquals(joueurRapide.getPrise(jeu3), 3);
    }
}

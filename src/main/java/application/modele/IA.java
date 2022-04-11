package application.modele;

import application.controleur.Controleur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;

import java.util.Random;

public class IA {
    private Jeu jeu;
    private Controleur controleur;
    private String caseJoue;

    public IA(Jeu jeu, Controleur controleur) {
        this.jeu = jeu;
        this.controleur = controleur;
    }

    public void jouer() throws PartieFinie {
        if (!verifPresqueVictoire(2))
            if (!verifPresqueVictoire(1)) {
                Random random = new Random();
                int hasard;
                do {
                    hasard = random.nextInt(9);
                } while (jeu.getGrille().get(hasard).getJoueur() != 0);
                caseJoue = jeu.getGrille().get(hasard).getId();
            }
        jeu.unTour(caseJoue);
    }

    public boolean verifPresqueVictoire(int joueur) {
        Case caseVide = null;

        int i = 0; //horizontal
        while (i < 7 && caseVide == null) {
            if (jeu.getGrille().get(i).getJoueur() == joueur && jeu.getGrille().get(i + 1).getJoueur() == joueur && jeu.getGrille().get(i + 2).getJoueur() == 0)
                caseVide = jeu.getGrille().get(i + 2);
            else if (jeu.getGrille().get(i).getJoueur() == joueur && jeu.getGrille().get(i + 2).getJoueur() == joueur && jeu.getGrille().get(i + 1).getJoueur() == 0)
                caseVide = jeu.getGrille().get(i + 1);
            else if (jeu.getGrille().get(i + 1).getJoueur() == joueur && jeu.getGrille().get(i + 2).getJoueur() == joueur && jeu.getGrille().get(i).getJoueur() == 0)
                caseVide = jeu.getGrille().get(i);
            i+=3;
        }

        i = 0; // vertical
        while (i < 3 && caseVide == null) {
            if (jeu.getGrille().get(i).getJoueur() == joueur && jeu.getGrille().get(i + 3).getJoueur() == joueur && jeu.getGrille().get(i + 6).getJoueur() == 0)
                caseVide = jeu.getGrille().get(i + 6);
            else if (jeu.getGrille().get(i).getJoueur() == joueur && jeu.getGrille().get(i + 6).getJoueur() == joueur && jeu.getGrille().get(i + 3).getJoueur() == 0)
                caseVide = jeu.getGrille().get(i + 3);
            else if (jeu.getGrille().get(i + 3).getJoueur() == joueur && jeu.getGrille().get(i + 6).getJoueur() == joueur && jeu.getGrille().get(i).getJoueur() == 0)
                caseVide = jeu.getGrille().get(i);
            i++;
        }

        //diagonale
        if (caseVide == null)
            //diagonale 1
            if (jeu.getGrille().get(0).getJoueur() == joueur && jeu.getGrille().get(4).getJoueur() == joueur && jeu.getGrille().get(8).getJoueur() == 0)
                caseVide = jeu.getGrille().get(8);
            else if (jeu.getGrille().get(0).getJoueur() == joueur && jeu.getGrille().get(8).getJoueur() == joueur && jeu.getGrille().get(4).getJoueur() == 0)
                caseVide = jeu.getGrille().get(4);
            else if (jeu.getGrille().get(4).getJoueur() == joueur && jeu.getGrille().get(8).getJoueur() == joueur && jeu.getGrille().get(0).getJoueur() == 0)
                caseVide = jeu.getGrille().get(0);

            //diagonale 2
            else if (jeu.getGrille().get(2).getJoueur() == joueur && jeu.getGrille().get(4).getJoueur() == joueur && jeu.getGrille().get(6).getJoueur() == 0)
                caseVide = jeu.getGrille().get(6);
            else if (jeu.getGrille().get(2).getJoueur() == joueur && jeu.getGrille().get(6).getJoueur() == joueur && jeu.getGrille().get(4).getJoueur() == 0)
                caseVide = jeu.getGrille().get(4);
            else if (jeu.getGrille().get(4).getJoueur() == joueur && jeu.getGrille().get(6).getJoueur() == joueur && jeu.getGrille().get(2).getJoueur() == 0)
                caseVide = jeu.getGrille().get(2);

            if (caseVide == null)
                return false;
            else {
                caseJoue = caseVide.getId();
                return true;
            }
    }

    public String getCaseJoue() {
        return caseJoue;
    }
}




















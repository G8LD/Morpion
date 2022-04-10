package application.modele;

import java.util.ArrayList;

public class Jeu {
    private int nbTour;
    private ArrayList<Case> grille;

    public Jeu() {
        nbTour = 0;
        grille = new ArrayList<>();
        initGrille();
    }

    public void initGrille() {
        grille.clear();
        grille.add(new Case("hg",0,0));//0
        grille.add(new Case("hm",0,1));//1
        grille.add(new Case("hd",0,2));//2
        grille.add(new Case("cg",1,0));//3
        grille.add(new Case("cm",1,1));//4
        grille.add(new Case("cd",1,2));//5
        grille.add(new Case("bg", 2,0));//6
        grille.add(new Case("bm", 2,1));//7
        grille.add(new Case("bd", 2,2));//8
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public int getNbTour() {
        return nbTour;
    }

    public ArrayList<Case> getGrille() {
        return grille;
    }

    public int verifVictoire() {
        if //region condition
                  ((grille.get(0).getJoueur() != 0 && grille.get(0).getJoueur() == grille.get(1).getJoueur() && grille.get(1).getJoueur() == grille.get(2).getJoueur()) //horizontal
                || (grille.get(3).getJoueur() != 0 && grille.get(3).getJoueur() == grille.get(4).getJoueur() && grille.get(4).getJoueur() == grille.get(5).getJoueur())
                || (grille.get(6).getJoueur() != 0 && grille.get(6).getJoueur() == grille.get(7).getJoueur() && grille.get(7).getJoueur() == grille.get(8).getJoueur())
                || (grille.get(0).getJoueur() != 0 && grille.get(0).getJoueur() == grille.get(3).getJoueur() && grille.get(3).getJoueur() == grille.get(6).getJoueur()) //vertical
                || (grille.get(1).getJoueur() != 0 && grille.get(1).getJoueur() == grille.get(4).getJoueur() && grille.get(4).getJoueur() == grille.get(7).getJoueur())
                || (grille.get(2).getJoueur() != 0 && grille.get(2).getJoueur() == grille.get(5).getJoueur() && grille.get(5).getJoueur() == grille.get(8).getJoueur())
                || (grille.get(0).getJoueur() != 0 && grille.get(0).getJoueur() == grille.get(4).getJoueur() && grille.get(4).getJoueur() == grille.get(8).getJoueur()) //diagonal
                || (grille.get(2).getJoueur() != 0 && grille.get(2).getJoueur() == grille.get(4).getJoueur() && grille.get(4).getJoueur() == grille.get(6).getJoueur()))
            //endregion
            return (nbTour - 1) % 2 + 1;
        else
            return 0;
    }

}

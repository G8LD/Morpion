package application.modele;

public class Affichage {
    public static char[][] creationGrille() {
        char[][] grille = new char[3][3];

        for (int i = 0; i < grille.length; i++)
            for (int j = 0; j < grille[i].length; j++)
                grille[i][j] = ' ';

        return grille;
    }

    public static void affichageGrille(char[][] grille) {
        System.out.println("    1   2   3");
        for (int i = 0; i < grille.length; i++) {
            System.out.print(" " + (i+1) + " ");
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(" " + grille[i][j]);
                if (j != grille[i].length - 1)
                    System.out.print(" |");
            }
            System.out.println();
            if (i != grille.length - 1)
                System.out.println("   ---+---+---");
        }
    }
}

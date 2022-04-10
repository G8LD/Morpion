package application.modele;

public class Case {
    private String id;
    private int x;
    private int y;
    private int joueur;

    public Case(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.joueur = 0;
    }

    public void setJoueur(int joueur) throws DejaPris {
        if (this.joueur != 0)
            throw new DejaPris();
        this.joueur = joueur;
    }

    public String getId() {
        return id;
    }

    public int getJoueur() {
        return joueur;
    }


}

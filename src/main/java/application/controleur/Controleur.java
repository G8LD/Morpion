package application.controleur;

import application.modele.DejaPris;
import application.modele.IA;
import application.modele.Jeu;
import application.modele.PartieFinie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    private Jeu jeu;
    private int victoire;
    private IA ia;

    @FXML private Button hg,hm,hd,cg,cm,cd,bg,bm,bd;
    @FXML private Label messageVictoire;
    @FXML private Label infoTour;
    @FXML private VBox vBoxFinDeJeu;
    @FXML private BorderPane borderPaneJeu;
    @FXML private BorderPane borderPaneMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jeu = new Jeu();
        victoire = 0;
        borderPaneMenu.toFront();
    }

    @FXML
    void unJoueur(ActionEvent event) {
        commencer(event);
        ia = new IA(jeu, this);
    }

    @FXML
    void deuxJoueurs(ActionEvent event) {
        commencer(event);
    }

    @FXML
    void quitter(ActionEvent event) {
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void boutonMenu(ActionEvent event) {
        borderPaneMenu.toFront();
    }

    @FXML
    void fermerOnglet(ActionEvent event) {
        vBoxFinDeJeu.toBack();
    }

    @FXML
    void commencer(ActionEvent event) {
        borderPaneJeu.toFront();
        jeu.initGrille();
        jeu.setNbTour(0);
        victoire = 0;
        infoTour.setText("X");
        //region reinit affichage
        hg.setText("");
        hm.setText("");
        hd.setText("");
        cg.setText("");
        cm.setText("");
        cd.setText("");
        bg.setText("");
        bm.setText("");
        bd.setText("");
        //endregion
    }

    @FXML
    public void bouton(ActionEvent event) {
        try {
            int nbTourActuelle = jeu.getNbTour();

            if (jeu.getNbTour() == 9 || victoire != 0)
                throw new PartieFinie();

            int i = 0;
            while (!jeu.getGrille().get(i).getId().equals(((Button) event.getSource()).getId())) {
                i++;
            }

            try {
                if (jeu.getNbTour() % 2 == 0) {
                    jeu.getGrille().get(i).setJoueur(1);
                    affichageCase(((Button) event.getSource()).getId(), "X");
                } else {
                    jeu.getGrille().get(i).setJoueur(2);
                    affichageCase(((Button) event.getSource()).getId(), "O");
                }
                jeu.setNbTour(jeu.getNbTour() + 1);
            } catch (DejaPris e) {}

            if (nbTourActuelle < jeu.getNbTour()) {
                if (jeu.getNbTour() >= 5)
                    victoire = jeu.verifVictoire();

                if (jeu.getNbTour() < 9 && victoire == 0) {
                    if (jeu.getNbTour() % 2 == 0)
                        infoTour.setText("X");
                    else {
                        infoTour.setText("O");
                        if (ia != null)
                            ia.jouer();
                    }
                } else {
                    if (victoire == 0)
                        messageVictoire.setText("Egalité !");
                    if (victoire == 1)
                        messageVictoire.setText("Victoire du Joueur X !");
                    else if (victoire == 2)
                        messageVictoire.setText("Victoire du Joueur O !");
                    Thread.sleep(150);
                    vBoxFinDeJeu.toFront();
                }
            }
        } catch (Exception e) {}
    }

    private void affichageCase(String id, String joueur) {
        switch (id) {
            case "hg" : hg.setText(joueur); break;
            case "hm" : hm.setText(joueur); break;
            case "hd" : hd.setText(joueur); break;
            case "cg" : cg.setText(joueur); break;
            case "cm" : cm.setText(joueur); break;
            case "cd" : cd.setText(joueur); break;
            case "bg" : bg.setText(joueur); break;
            case "bm" : bm.setText(joueur); break;
            case "bd" : bd.setText(joueur); break;
            default: break;
        }
    }

    public void appuieBouton(String id) {
        switch (id) {
            case "hg" : hg.fire(); break;
            case "hm" : hm.fire(); break;
            case "hd" : hd.fire(); break;
            case "cg" : cg.fire(); break;
            case "cm" : cm.fire(); break;
            case "cd" : cd.fire(); break;
            case "bg" : bg.fire(); break;
            case "bm" : bm.fire(); break;
            case "bd" : bd.fire(); break;
            default: break;
        }
    }

}


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

    @FXML private Button hg,hm,hd,cg,cm,cd,bg,bm,bd;
    @FXML private Label messageVictoire;
    @FXML private Label infoTour;
    @FXML private VBox vBoxFinDeJeu;
    @FXML private BorderPane borderPaneJeu;
    @FXML private BorderPane borderPaneMenu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jeu = new Jeu();
        borderPaneMenu.toFront();
    }

    @FXML
    void unJoueur(ActionEvent event) {
        commencer(event);
        jeu.setIa(new IA(jeu, this));
    }

    @FXML
    void deuxJoueurs(ActionEvent event) {
        commencer(event);
        jeu.setIa(null);
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
        jeu.setVictoire(0);
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
    public void unTour(ActionEvent event) {
        try {
            jeu.unTour(((Button) event.getSource()).getId());

            int decalage = 0;
            if (jeu.getIa() != null) {
                affichageCase(jeu.getIa().getCaseJoue(), "O");
                decalage = 1;
            }
            if ((jeu.getNbTour() - decalage) % 2 == 1) {
                ((Button) event.getSource()).setText("X");
                infoTour.setText("O");
            } else {
                ((Button) event.getSource()).setText("O");
                infoTour.setText("X");
            }
            if (jeu.getNbTour() == 9 || jeu.getVictoire() != 0)
                throw new PartieFinie();
        } catch (PartieFinie e) {
            if (jeu.getVictoire() == 0)
                messageVictoire.setText("Egalité !");
            if (jeu.getVictoire() == 1)
                messageVictoire.setText("Victoire du Joueur X !");
            else if (jeu.getVictoire() == 2)
                messageVictoire.setText("Victoire du Joueur O !");
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            vBoxFinDeJeu.toFront();
        }
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


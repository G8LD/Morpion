package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            StackPane root = FXMLLoader.load(getClass().getResource("vue.fxml"));
            Scene scene = new Scene(root,600,600);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Morpion");
            primaryStage.getIcons().add(new Image("logo.png"));
            primaryStage.show();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

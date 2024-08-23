package org.atatree.passwordmanager;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class App extends Application {

    public static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/App.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        stage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
        scene.setFill(Color.TRANSPARENT);

        primaryStage.focusedProperty().addListener( (src, ov, nv) -> {
            if (!nv) primaryStage.setOpacity(.8);
            if (nv) primaryStage.setOpacity(1);
        });

        primaryStage.iconifiedProperty().addListener((src, ov, nv) -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(500), root);
            scaleTransition.setNode(root);

            if (!nv) {

                scaleTransition.setToX(1);

                scaleTransition.setToY(1);
                scaleTransition.play();
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}

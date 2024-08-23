package org.atatree.passwordmanager.controllers;

import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import org.atatree.passwordmanager.App;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    ScaleTransition scale = new ScaleTransition(Duration.millis(500));


    @FXML
    public BorderPane root;
    @FXML
    public AnchorPane title_bar;
    @FXML
    public ImageView close_btn;
    @FXML
    public ImageView minimize_btn;

    private double x, y = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        windowInit();
    }

    private void windowInit() {

        title_bar.setOnMousePressed(e -> {
            x = e.getX();
            y = e.getY();
        });

        title_bar.setOnMouseDragged(e -> {
            App.stage.setX(e.getScreenX() - x);
            App.stage.setY(e.getScreenY() - y);

        });

        close_btn.setOnMousePressed(e -> {
            scale.setNode(root);
            scale.setByX(-1);
            scale.setByY(-1);
            scale.play();
            scale.setOnFinished(f -> App.stage.close());
        });

        minimize_btn.setOnMouseClicked(e -> {
            scale.setNode(root);
            scale.setByX(-1);
            scale.setByY(-1);
            scale.play();
            scale.setOnFinished(f -> App.stage.setIconified(true));
        });


    }
}

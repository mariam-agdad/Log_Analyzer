package org.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(LogApplication.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().addAll(getClass().getResource("/css/sideBar.css").toExternalForm(),getClass().getResource("/css/navBar.css").toExternalForm(),getClass().getResource("/org/example/Style.css").toExternalForm());
        stage.setTitle("Log Analyser");
        stage.setScene(scene);
        stage.show();
    }
        public static void main (String[]args){
            Application.launch(args);
        }
    }


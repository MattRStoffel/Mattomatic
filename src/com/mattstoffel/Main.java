package com.mattstoffel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Runs on amazon corretto 1.8

public class Main extends Application {

    int width = 1400;
    int height = 800;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Mattomatic.fxml"));
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.setTitle("Mattomatic");
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    // TODO: Features 5/19/2020
    //     drag and drop for the blueprint and images folder
}

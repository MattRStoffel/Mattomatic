package com.mattstoffel;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class Mattomatic {

    File blueprintFile;

    String workingDirectory = "./";

    ArrayList<ImageButton> imageButtons = new ArrayList<ImageButton>();

    int menuBarHeight = 40;

    double aspectRatio;

    public Mattomatic(){

    }

    @FXML
    private DisplayImageList displayImageList;
    @FXML
    private ImageView imageView;
    @FXML
    private BorderPane borderPane;
    @FXML
    private StackPane stackPane;

    @FXML
    private void menuOpenAction() throws FileNotFoundException {

        //directory and file chooser give you pop up windows that the
        // user can then select the folder with all their immages and the blueprint
        DirectoryChooser directoryChooser = new DirectoryChooser();
        FileChooser fileChooser = new FileChooser();
        directoryChooser.setInitialDirectory(new File(workingDirectory));
        workingDirectory = String.valueOf(directoryChooser.showDialog(borderPane.getScene().getWindow()));
        displayImageList.setWorkingDirectory(workingDirectory, (int) displayImageList.getHeight());
        File fileNames = new File(workingDirectory);
        fileChooser.setInitialDirectory(fileNames);

        //set blueprint image
        blueprintFile = new File(
                String.valueOf(fileChooser.showOpenDialog(borderPane.getScene().getWindow())));
        FileInputStream fileInputStream = new FileInputStream(blueprintFile);
        imageView.setImage(new Image(fileInputStream));
        aspectRatio = imageView.getImage().getWidth() / imageView.getImage().getHeight();
        displayImageList.setItems(FXCollections.observableArrayList(fileNames.list()));
    }

    @FXML
    private void menuSaveAs() {
        // TODO: 5/18/2020 generate the website in a location specified by the user
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Save As...");
//
//        File file = fileChooser.showSaveDialog(borderPane.getScene().getWindow());
//        if (file != null) {
//            try {
//                HTMLFactory html = new HTMLFactory(file.getName() + ".html");
//                html.initializeHTML(file.getCanonicalPath() + "/" , blueprintFile.getName());
//                for (HouseLocation hl: houseLocations) {
//                    if (!hl.getDeleted())
//                        html.writeHTML( (int) hl.getLayoutX(), (int) hl.getLayoutY(), (int)hl.getAngle(), hl.getName());
//                }
//                html.closeHTML();
//                html.openInBrowser();
//
//                for (ImageButton imageButton : imageButtons) {
//                    ImageIO.write(SwingFXUtils.fromFXImage(imageButton.getImage(),
//                            null), "png", new File(file.toURI() + "/" + imageButton.getName()));
//                    System.out.println(file.toURI() + "/" + imageButton.getName());
//                }
//            } catch (IOException ex) {
//                System.out.println(ex);
//            }
//
//        }

    }

    @FXML
    private void menuViewAction() {
        HTMLFactory html = new HTMLFactory("index.html");
        html.initializeHTML("./images/" + blueprintFile.getName());
        for (ImageButton imageButton: imageButtons) {
            if (imageButton.isVisible())
                html.writeHTMLByPercent(imageButton.getTranslateX(), imageButton.getTranslateY(),
                    (int) (imageButton.getRotate()), imageButton.getName(), imageView);
        }
        html.closeHTML();
        try {
            html.openInBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    double imageButtonTranslateX;
    double imageButtonTranslateY;

    @FXML
    private void blueprintMousePressed() {
        imageView.setOnMousePressed(click -> {
            // load an image and create new imageButton objet using the mouse presses and dragged events
            try {
                Image image = new Image(new FileInputStream(workingDirectory + "/" + displayImageList.getSelectionModel().getSelectedItem()));
                String selectedImage = displayImageList.getSelectionModel().getSelectedItem().toString();
                ImageButton imageButton = new ImageButton(image, selectedImage, (int) (displayImageList.getHeight() - menuBarHeight));
                imageButton.setTranslateX(click.getX() - (Math.min(imageView.getFitWidth(), imageView.getFitHeight() * aspectRatio)/2));
                imageButton.setTranslateY(click.getY() - (Math.min(imageView.getFitHeight(), imageView.getFitWidth() / aspectRatio)/2));
                imageButtons.add(imageButton);
                stackPane.getChildren().add(imageButton);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageButtonTranslateX = click.getSceneX();
            imageButtonTranslateY = click.getSceneY();
        });
    }

    @FXML
    private void blueprintMouseDragged() {
        imageView.setOnMouseDragged(drag -> {
            imageButtons.get(imageButtons.size()-1).setRotate(
                    -Math.toDegrees(Math.atan2(drag.getSceneX() - imageButtonTranslateX, drag.getSceneY() - imageButtonTranslateY)) - 135);
        });
    }

}

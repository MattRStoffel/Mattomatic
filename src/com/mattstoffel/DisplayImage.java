package com.mattstoffel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class DisplayImage{

    ImageButton imageButton;

    @FXML
    private Button cancelButton;
    @FXML
    private Button deleteButton;
    @FXML
    private ImageView displayImageView;


    void initData(ImageButton imageButton) {
        this.imageButton = imageButton;
        this.displayImageView.setImage(this.imageButton.getImage());
    }

    public void deleteButtonClicked() {
        deleteButton.setOnMouseClicked(click -> {
            imageButton.setVisible(false);
            ((Stage) (((Button) click.getSource()).getScene().getWindow())).close();
        });
    }

    public void cancelButtonClicked() {
        cancelButton.setOnMouseClicked(click -> ((Stage)(((Button)click.getSource()).getScene().getWindow())).close());
    }

}

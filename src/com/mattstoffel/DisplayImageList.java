package com.mattstoffel;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SuppressWarnings("ALL")
public class DisplayImageList extends ListView {
    //set the size of thumbnails
    private int fitHeight = 200;
    private int fitWidth = 200;
    private String workingDirectory = "./images";

    public DisplayImageList() {
        //cell factory lets me add images to the cell
        this.setCellFactory(param -> new ListCell<String>() {
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    try {
                        //generate the imageview and populate it
                        ImageView imageView = new ImageView();
                        imageView.setImage(new Image(new FileInputStream(workingDirectory + "/" + name)));
                        imageView.setPreserveRatio(true);
                        //keeps the images a manageable size
                        imageView.setFitHeight(fitHeight);
                        imageView.setFitWidth(fitWidth);
                        setGraphic(imageView);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void setWorkingDirectory(String workingDirectory, int size) {
        this.fitHeight = size/2;
        this.fitWidth = size;
        this.workingDirectory = workingDirectory;
    }
}

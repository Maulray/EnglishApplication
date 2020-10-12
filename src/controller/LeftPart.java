package controller;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.Day;

public class LeftPart extends VBox {

    public LeftPart(Day day){
        this.setStyle("-fx-background-color:#585858;\n"+"-fx-border-color: silver;\n");
        Image image = new Image(day.getImageName(),350,350,true,true);
        ImageView imageview = new ImageView(image);
        this.getChildren().add(imageview);

        //VocabularyWords vw = new VocabularyWords(day);
        //this.getChildren().add(vw);
    }
}

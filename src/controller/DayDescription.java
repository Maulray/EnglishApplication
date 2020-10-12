package controller;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.TextAlignment;
import model.Day;

import java.util.Date;

public class DayDescription extends ScrollPane {

    public DayDescription(Day day) {
        this.getStylesheets().add("projet.css");
        this.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        this.setFitToWidth(true);
        this.setMinSize(246, 350);
        this.setMaxSize(250, 350);
        this.setStyle(
                "-fx-border-color: silver;\n"+
                "-fx-background-color:#585858;\n"
        );


        String descr = day.getDescription();
        Label label = new Label(descr);
        label.setStyle(
                "-fx-background-color:#585858;\n"+
                "-fx-text-fill: white;\n"+
                "-fx-font-size: 22px;-fx-font-family: \"Please write me a song\";\n"+
                "-fx-border-color: silver;\n"
        );
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        this.setContent(label);

    }
}

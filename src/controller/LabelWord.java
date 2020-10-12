package controller;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.text.TextAlignment;

public class LabelWord extends Label {
    private String english;
    private String french;
    private Boolean mouseOnButton;

    public LabelWord(String english, String french) {
        super(english);
        this.english = english;
        this.french = french;
        this.mouseOnButton = false;
        this.setWrapText(true);
        this.setAlignment(Pos.CENTER);
        this.setTextAlignment(TextAlignment.CENTER);
        this.setMinSize(180,20);
        this.setStyle(
                "-fx-background-color : white;"+
                "-fx-font: 16px \"Georgia\";\n"+
                "-fx-text-fill: #585858;\n"
        );
        this.setOnMouseMoved(event -> {
            this.mouseOnButton = true;
            this.revealFrench();
        });
        this.setOnMouseExited(event -> {
            this.mouseOnButton = false;
            this.revealEnglish();
        });
    }
    public void revealFrench(){
        this.setText(this.french);
        this.setStyle(
                "-fx-background-color : #585858;" +
                        "-fx-font: 16px \"Georgia\";\n" +
                        "-fx-text-fill: white;\n" +
                        "-fx-border-color: silver;\n"
        );

    }
    public void revealEnglish(){
        if (!this.mouseOnButton) {
            this.setText(this.english);
            this.setStyle(
                    "-fx-background-color : white;" +
                            "-fx-font: 16px \"Georgia\";\n" +
                            "-fx-text-fill: #585858;\n"
            );
        }
    }
}

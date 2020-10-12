package controller;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import model.Day;

import java.util.Date;

public class VocabularyWords extends GridPane {

    private LabelWord word1;
    private LabelWord word2;
    private LabelWord word3;
    private LabelWord word4;
    private LabelWord word5;

    public VocabularyWords(Day day) {
        this.getStylesheets().add("projet.css");
        this.setStyle("-fx-background-color:#585858;\n");
        //this.setMinSize(600, 200);
        this.setMaxSize(600, 350);

        this.word1 = new LabelWord(day.getWord1EN(),day.getWord1FR());
        this.word2 = new LabelWord(day.getWord2EN(),day.getWord2FR());
        this.word3 = new LabelWord(day.getWord3EN(),day.getWord3FR());
        this.word4 = new LabelWord(day.getWord4EN(),day.getWord4FR());
        this.word5 = new LabelWord(day.getWord5EN(),day.getWord5FR());

        this.add(word1, 0, 0,1,1);
        setHalignment(word1, HPos.CENTER);
        this.add(word2,1,0,2,1);
        setHalignment(word2,HPos.CENTER);
        this.add(word3,3,0,1,1);
        setHalignment(word3,HPos.CENTER);
        this.add(word4,0,1,2,1);
        setHalignment(word4,HPos.CENTER);
        this.add(word5,2,1,2,1);
        setHalignment(word5,HPos.CENTER);

        Label signature = new Label("Created by Malaury & Maxime");
        signature.setStyle(
                "-fx-text-fill : silver;\n"+
                        "-fx-font : 15px \"Please write me a song\";\n"
        );
        this.add(signature,1,1,2,1);
        setHalignment(signature,HPos.CENTER);
        signature.setTranslateY(18);


        this.getRowConstraints().addAll(new RowConstraints(30,50,100), new RowConstraints(30,50,100));


        this.setVgap(20);
        ColumnConstraints colonne0 = new ColumnConstraints();
        colonne0.setPercentWidth(33);
        ColumnConstraints colonne1 = new ColumnConstraints();
        colonne1.setPercentWidth(17);
        ColumnConstraints colonne2 = new ColumnConstraints();
        colonne2.setPercentWidth(17);
        ColumnConstraints colonne3 = new ColumnConstraints();
        colonne3.setPercentWidth(33);
        this.getColumnConstraints().addAll(colonne0,colonne1,colonne2,colonne3);

    }
    public void setOnkeyPressed(KeyCode keyCode){
        switch (keyCode){
            case AMPERSAND:
                word1.revealFrench();
                break;
            case DIGIT2:
                word2.revealFrench();
                break;
            case QUOTEDBL:
                word3.revealFrench();
                break;
            case QUOTE:
                word4.revealFrench();
                break;
            case LEFT_PARENTHESIS:
                word5.revealFrench();
                break;
            default:
                break;
        }
    }
    public void setOnkeyReleased(KeyCode keyCode){
        switch (keyCode){
            case AMPERSAND:
                word1.revealEnglish();
                break;
            case DIGIT2:
                word2.revealEnglish();
                break;
            case QUOTEDBL:
                word3.revealEnglish();
                break;
            case QUOTE:
                word4.revealEnglish();
                break;
            case LEFT_PARENTHESIS:
                word5.revealEnglish();
                break;
            default:
                break;
        }
    }
}

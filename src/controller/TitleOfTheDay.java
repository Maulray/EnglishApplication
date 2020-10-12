package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Launcher;
import model.Day;

import java.awt.*;
import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class TitleOfTheDay extends BorderPane {


    private Day day;
    @FXML
    private Label intituleLabel;

    private String dayToString(Day day){

        String texte = Integer.parseInt(day.getDayMonthNumber())+"";
        switch (day.getDayMonthNumber()){
            case "01":
            case "21":
            case "31":
                texte+="st ";
                break;
            case "02":
            case "22":
                texte+="nd ";
                break;
            case "03":
            case "23":
                texte+="rd ";
                break;
            default:
                texte += "th ";
                break;
        }
        switch (day.getMonthNumber()){
            case "01":
                texte +="January ";
                break;
            case "02":
                texte += "February ";
                break;
            case "03":
                texte += "March ";
                break;
            case "04":
                texte += "April ";
                break;
            case "05":
                texte += "May ";
                break;
            case "06":
                texte += "June ";
                break;
            case "07":
                texte += "July ";
                break;
            case "08":
                texte += "August ";
                break;
            case "09":
                texte += "September ";
                break;
            case "10":
                texte += "October ";
                break;
            case "11":
                texte += "November ";
                break;
            case "12":
                texte += "December ";
                break;
            default:
                texte +="MonthError ";
                break;
        }
        return texte;
    }
    public TitleOfTheDay(Day day) {
        this.getStylesheets().add("projet.css");

        this.setStyle("-fx-background-color:#585858;\n");
        this.day = day;

        /*
        Label yesterdayLabel = new Label(this.dayToString(day.getPreviousDay()));
        yesterdayLabel.setTextFill(Color.web("#0076a3"));

        Label tomorrowLabel = new Label(this.dayToString(day.getNextDay()));
        tomorrowLabel.setTextFill(Color.web("#0076a3"));
        this.setLeft(yesterdayLabel);
        this.setRight(tomorrowLabel);
         */
        this.intituleLabel = new Label(day.getIntitule());
        this.intituleLabel.setTextFill(Color.web("white"));
        this.intituleLabel.setStyle("-fx-font-family: \"Vogue\";\n"+"-fx-font-variant:\"small-caps\";\n");
        int fontSize = 30;
        if (day.getIntitule().length()>25) fontSize = 23;
        this.intituleLabel.setFont(new Font(fontSize));
        this.intituleLabel.setWrapText(true);

        this.setMinWidth(Launcher.getWidth());
        this.setCenter(this.intituleLabel);


        //texte += ": " + day.getIntitule();
        //this.setText(texte);
        //this.setTextFill(Color.web("#0076a3"));
        this.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: transparent;");


    }
}

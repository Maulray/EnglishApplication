package controller;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.Launcher;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Day;

import java.time.ZoneId;
import java.util.Date;


public class BackAndNext extends BorderPane {

    private Launcher launcher;

    private Image Back = new Image("resources/back.png", 20, 20, true, true);
    private ImageView imageBack = new ImageView(Back);
    private Image Next = new Image("resources/next.png", 20, 20, true, true);
    private ImageView imageNext = new ImageView(Next);

    public BackAndNext(Launcher launcher, Day day) {
        this.setStyle(
                "-fx-background-color:#585858;\n"+
                "-fx-text-fill: white;\n"+
                "-fx-font: 16px \"Georgia\";"
        );
        Button back = new Button();
        back.setGraphic(imageBack);
        Button next = new Button();
        back.setStyle("-fx-background-color:#585858;\n");
        next.setStyle("-fx-background-color:#585858;\n");
        next.setGraphic(imageNext);

        back.setOnAction(e -> {
            GlobalView gbBack = new GlobalView(launcher, day.getPreviousDay());
            launcher.switchScene(gbBack, launcher.getPrimaryStage());
        });

        next.setOnAction(e -> {
            GlobalView gbNext = new GlobalView(launcher, day.getNextDay());
            launcher.switchScene(gbNext, launcher.getPrimaryStage());
        });

        DatePicker datePicker = new DatePicker(day.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        datePicker.setStyle(
                "-fx-background-color:#585858;\n"+
                "-fx-font: 16px \"Georgia\";"
        );
        datePicker.setOnAction(e -> {
            GlobalView gb = new GlobalView(launcher, Day.getDay(Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())));
            launcher.switchScene(gb, launcher.getPrimaryStage());
        });
        this.setLeft(back);
        this.setRight(next);
        //this.setCenter(datePicker);
        //this.getChildren().addAll(back, datePicker,  next);
        //setMargin(next, new Insets(0, 0, 0, 0)); //valeur à adapter plus tard
        Label yesterdayLabel = new Label(this.dayToString(day.getPreviousDay()));
        yesterdayLabel.setOnMouseClicked(e -> {
            GlobalView gbBack = new GlobalView(launcher, day.getPreviousDay());
            launcher.switchScene(gbBack, launcher.getPrimaryStage());
        });
        yesterdayLabel.setTextFill(Color.web("white"));

        Label tomorrowLabel = new Label(this.dayToString(day.getNextDay()));
        tomorrowLabel.setTextFill(Color.web("white"));
        tomorrowLabel.setOnMouseClicked(e -> {
                    GlobalView gbNext = new GlobalView(launcher, day.getNextDay());
                    launcher.switchScene(gbNext, launcher.getPrimaryStage());
                });
        //this.setLeft(yesterdayLabel);
        //this.setRight(tomorrowLabel);

        BorderPane borderPaneCenter = new BorderPane();
        borderPaneCenter.setLeft(yesterdayLabel);
        yesterdayLabel.setTranslateY(7);
        borderPaneCenter.setCenter(datePicker);
        borderPaneCenter.setRight(tomorrowLabel);
        tomorrowLabel.setTranslateY(7);
        tomorrowLabel.setTranslateX(4);
        this.setCenter(borderPaneCenter);

        /*
        HBox hboxLeft = new HBox();
        hboxLeft.getChildren().addAll(back,yesterdayLabel);
        this.setLeft(hboxLeft);

        HBox hboxRight = new HBox();
        hboxRight.getChildren().addAll(tomorrowLabel,next);
        this.setRight(hboxRight);

         */

    }

    public String getPrevDate(String date) {
        String res;
        String[] splitedDate = date.split("_");
        int month = Integer.parseInt(splitedDate[0]);
        int day = Integer.parseInt(splitedDate[1]);
        String m, d;
        if (day > 1) {
            day--;
            m = splitedDate[0];
        } else if (month == 5 | month == 7 | month == 10 | month == 12) {
            //mois dont le mois précédent possède 30 jours
            day = 30;
            month--;
            m = Integer.toString(month);
        } else if (month == 3) {
            //mois dont le mois précédent possède 29 jours (voir si on raisonne sur l'année plus tard)
            day = 29;
            month = 2;
            m = Integer.toString(month);
        } else if (month == 1) {
            //cas spécial de janvier
            day = 31;
            month = 12;
            m = Integer.toString(month);
        } else {
            //mois dont le mois précédent possède 31 jours
            day = 31;
            month--;
            m = Integer.toString(month);
        }
        d = Integer.toString(day);
        if (d.length() == 1) {
            d = "0" + d;
        }
        if (m.length() == 1) {
            m = "0" + m;
        }
        res = m + "_" + d;
        return res;
    }

    public String getNextDate(String date) {
        String res;
        String[] splitedDate = date.split("_");
        int month = Integer.parseInt(splitedDate[0]);
        int day = Integer.parseInt(splitedDate[1]);
        String m, d;
        if (day < 29) {
            day++;
            m = splitedDate[0];
        } else if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10) {
            //mois possédant 31 jours (hors décembre)
            if (day < 31) {
                day++;
            } else {
                day = 1;
                month++;
            }
            m = Integer.toString(month);
        } else if (month == 2) {
            //février (on part du principe qu'il a toujours 29 jours pour le moment)
            day = 1;
            month = 3;
            m = Integer.toString(month);
        } else if (month == 12) {
            //cas spécial de décembre
            if (day < 31) {
                day++;
            } else {
                day = 1;
                month = 1;
            }
            m = Integer.toString(month);
        } else {
            //mois possédant 30 jours
            if (day < 30) {
                day++;
            } else {
                day = 1;
                month++;
            }
            m = Integer.toString(month);
        }
        d = Integer.toString(day);
        if (d.length() == 1) {
            d = "0" + d;
        }
        if (m.length() == 1) {
            m = "0" + m;
        }
        res = m + "_" + d;
        return res;
    }

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
}

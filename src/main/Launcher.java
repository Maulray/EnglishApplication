package main;

import controller.GlobalView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Day;
import model.Parser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Launcher extends Application {


    private Stage primaryStage;
    private String date;
    private Day day;
    private static int height = 600;
    private static int width = 600;
    private GlobalView gb;

    public static void main(String[] args) throws IOException{
        Parser.parser("jours.xlsx");
        Locale.setDefault(Locale.ENGLISH);
        launch(args);

    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    @Override
    public void start(Stage primaryStage) {
        this.setPrimaryStage(primaryStage);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {

        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM_dd");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);*/
        Day day = Day.getDay(new Date());

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Pigs-in-a-Blanket");
        this.gb = new GlobalView(this, day);
        Scene scene = new Scene(gb);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setMinWidth(width);
        primaryStage.show();
    }

    public void switchScene(Parent node, Stage primaryStage) {
        Scene scene = new Scene(node);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setMinWidth(width);
        primaryStage.show();
    }

}

package controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Launcher;
import javafx.scene.layout.VBox;
import model.Day;

public class GlobalView extends VBox {

    Launcher launcher;
    private TitleOfTheDay dayName;
    private static int height = 600;
    private static int width = 600;
    private Day day;
    private MainPart mainPart;
    private VocabularyWords vw;

    public GlobalView(Launcher launcher, Day day){
        this.setStyle("-fx-background-color:#585858;\n");
        this.setMinHeight(height);
        this.setMaxHeight(height);
        this.setMaxWidth(width);
        this.setMinWidth(width);
        this.day=day;
        this.launcher = launcher;


        BackAndNext arrows = new BackAndNext(launcher,day);
        this.getChildren().add(arrows);

        this.dayName = new TitleOfTheDay(day);
        this.getChildren().add(this.dayName);

        this.mainPart = new MainPart(day);
        this.getChildren().add(this.mainPart);

        this.vw = new VocabularyWords(day);
        this.getChildren().add(this.vw);

        this.setOnKeyPressed(this::handleEventKeyPressed);
        this.setOnKeyReleased(this::handleEventKeyReleased);

    }
    public void handleEventKeyPressed(KeyEvent e){

        if (e.getEventType() == KeyEvent.KEY_PRESSED){
            if (e.getCode() == KeyCode.RIGHT){
                GlobalView gbNext = new GlobalView(launcher, day.getNextDay());
                launcher.switchScene(gbNext, launcher.getPrimaryStage());
            } else if (e.getCode()==KeyCode.LEFT){
                GlobalView gbNext = new GlobalView(launcher, day.getPreviousDay());
                launcher.switchScene(gbNext, launcher.getPrimaryStage());
            } else if (e.getCode()==KeyCode.DOWN){
                this.mainPart.down();
            } else if (e.getCode()==KeyCode.UP){
                this.mainPart.up();
            } else {
                this.vw.setOnkeyPressed(e.getCode());
            }
        }
    }

    public void handleEventKeyReleased(KeyEvent e){
        this.vw.setOnkeyReleased(e.getCode());
    }

    public Launcher getLauncher(){return launcher;}
}

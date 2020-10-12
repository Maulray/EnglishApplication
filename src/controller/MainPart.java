package controller;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Day;

public class MainPart extends BorderPane {
    private DayDescription dd;
    private static final double increment = 0.1;

    public MainPart(Day day){
        this.setStyle("-fx-background-color:#585858;\n");
        LeftPart lp = new LeftPart(day);
        this.setLeft(lp);

        this.dd = new DayDescription(day);
        this.setRight(this.dd);
        setMargin(this.dd,new Insets(0,2,0,2));
    }
    public void down(){
        double vValue = this.dd.getVvalue();
        vValue+=increment;
        if (vValue>1){
            vValue=1;
        }
        this.dd.setVvalue(vValue);
    }
    public void up(){
        double vValue = this.dd.getVvalue();
        vValue-=increment;
        if (vValue<0){
            vValue=0;
        }
        this.dd.setVvalue(vValue);
    }
}

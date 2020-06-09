package pp;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.IOException;

public class RootPane extends Pane {
    Hall hallPane1;
    Hall hallPane2;
    Hall hallPane3;
    Hall hallPane4;
    Label chooseHallLabel;

    Button setHall1, setHall2, setHall3, setHall4;

    Rectangle free, reserved, selected, selectedRes;

    private int WIDTH = 900;
    private int HEIGHT = 500;

    private Label freeLabel, reservedLabel, selectedLabel, selectedResLabel;

    public RootPane() {
        setPrefSize(WIDTH, HEIGHT);

        initHallPanes();
        initHallButtons();
        initHallLabel();
        initLegendRect();
        initLegendLabel();
    }

    private void changeSize(int WIDTH, int HEIGHT) {
        setPrefSize(WIDTH, HEIGHT);
    }

    private void initLegendRect() {
        free = new Rectangle(20, 20, Color.LIMEGREEN);
        reserved = new Rectangle(20, 20, Color.RED);
        selected = new Rectangle(20, 20, Color.ORANGE);
        selectedRes = new Rectangle(20, 20, Color.DEEPSKYBLUE);

        free.setStrokeWidth(2);
        free.setStroke(Color.WHITE);
        free.setLayoutX(720);
        free.setLayoutY(400);

        reserved.setStrokeWidth(2);
        reserved.setStroke(Color.WHITE);
        reserved.setLayoutX(720);
        reserved.setLayoutY(425);

        selected.setStrokeWidth(2);
        selected.setStroke(Color.WHITE);
        selected.setLayoutX(720);
        selected.setLayoutY(450);

        selectedRes.setStrokeWidth(2);
        selectedRes.setStroke(Color.WHITE);
        selectedRes.setLayoutX(720);
        selectedRes.setLayoutY(475);

        getChildren().addAll(free, reserved, selected, selectedRes);
    }

    private void initLegendLabel() {
        freeLabel = new Label("Miejsce wolne");
        reservedLabel = new Label("Miejsce zarezerwowane");
        selectedLabel = new Label("Wybrane do rezerwacji");
        selectedResLabel = new Label("Do anulowania rezerwacji");

        freeLabel.setLayoutX(750);
        freeLabel.setLayoutY(400);
        freeLabel.setMinWidth(100);

        reservedLabel.setLayoutX(750);
        reservedLabel.setLayoutY(425);
        reservedLabel.setMinWidth(100);

        selectedLabel.setLayoutX(750);
        selectedLabel.setLayoutY(450);
        selectedLabel.setMinWidth(100);

        selectedResLabel.setLayoutX(750);
        selectedResLabel.setLayoutY(475);
        selectedResLabel.setMinWidth(100);

        getChildren().addAll(freeLabel, reservedLabel, selectedLabel, selectedResLabel);
    }

    private void initHallLabel() {
        chooseHallLabel = new Label("Wybierz sale kinowa");
        chooseHallLabel.setTextFill(Color.RED);
        chooseHallLabel.setFont(Font.font("Calibri", 22));
        chooseHallLabel.setLayoutX(30);
        chooseHallLabel.setLayoutY(25);

        getChildren().add(chooseHallLabel);
    }

    private void initHallPanes() {
        hallPane1 = new Hall("YOU WERE NEVER REALLY HERE");
        hallPane1.setLayoutX(getPrefWidth() / 2 - hallPane1.getPrefWidth() / 2);
        hallPane1.setLayoutY(25);

        hallPane2 = new Hall("JOKER");
        hallPane2.setLayoutX(getPrefWidth() / 2 - hallPane2.getPrefWidth() / 2);
        hallPane2.setLayoutY(25);

        hallPane3 = new Hall("CALL ME BY YOUR NAME");
        hallPane3.setLayoutX(getPrefWidth() / 2 - hallPane3.getPrefWidth() / 2);
        hallPane3.setLayoutY(25);

        hallPane4 = new Hall("TINKER TAILOR SOLDIER SPY");
        hallPane4.setLayoutX(getPrefWidth() / 2 - hallPane4.getPrefWidth() / 2);
        hallPane4.setLayoutY(25);

        hallPane1.setVisible(false);
        hallPane2.setVisible(false);
        hallPane3.setVisible(false);
        hallPane4.setVisible(false);

        getChildren().addAll(hallPane1, hallPane2, hallPane3, hallPane4);
    }

    private void initHallButtons() {
        setHall1 = new Button("Sala 1");
        setHall2 = new Button("Sala 2");
        setHall3 = new Button("Sala 3");
        setHall4 = new Button("Sala 4");

        //HALL1
        setHall1.setLayoutY(100);
        setHall1.setLayoutX(100);
        setHall1.setScaleX(2);
        setHall1.setScaleY(2);

        //HALL2
        setHall2.setLayoutY(setHall1.getLayoutY() + 100);
        setHall2.setLayoutX(100);
        setHall2.setScaleX(2);
        setHall2.setScaleY(2);

        //HALL3
        setHall3.setLayoutY(setHall2.getLayoutY() + 100);
        setHall3.setLayoutX(100);
        setHall3.setScaleX(2);
        setHall3.setScaleY(2);

        //HALL4
        setHall4.setLayoutY(setHall3.getLayoutY() + 100);
        setHall4.setLayoutX(100);
        setHall4.setScaleX(2);
        setHall4.setScaleY(2);

        setHall1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hallPane1.setVisible(true);
                hallPane2.setVisible(false);
                hallPane3.setVisible(false);
                hallPane4.setVisible(false);
                try {
                    hallPane1.importTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setHall2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hallPane1.setVisible(false);
                hallPane2.setVisible(true);
                hallPane3.setVisible(false);
                hallPane4.setVisible(false);
                try {
                    hallPane2.importTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setHall3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hallPane1.setVisible(false);
                hallPane2.setVisible(false);
                hallPane3.setVisible(true);
                hallPane4.setVisible(false);
                try {
                    hallPane3.importTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setHall4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                hallPane1.setVisible(false);
                hallPane2.setVisible(false);
                hallPane3.setVisible(false);
                hallPane4.setVisible(true);
                try {
                    hallPane4.importTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        getChildren().addAll(setHall1, setHall2, setHall3, setHall4);
    }


}

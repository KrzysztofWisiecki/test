package pp;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ChoosePane extends Pane {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 200;

    private Label label;

    public Button clientButton;
    public Button employeeButton;

    public ChoosePane() {
        setPrefSize(WIDTH, HEIGHT);
        setStyle("-fx-background-color: darkgrey");

        initLabel();
        initButtons();
    }

    private void initLabel() {
        label = new Label("Witaj w naszym kinie! Wybierz tryb dalszych akcji:");
        label.setWrapText(true);
        label.setMinWidth(WIDTH);
        label.setTextFill(Color.BLACK);
        label.setFont(new Font(20));
        label.setAlignment(Pos.CENTER);
        label.setLayoutX(0);
        label.setLayoutY(10);
        //label.setBorder(new Border(new BorderStroke(Color.BLACK,
        //BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        label.setVisible(true);

        getChildren().add(label);
    }

    private void initButtons() {
        clientButton = new Button("Tryb konsumenta");
        employeeButton = new Button("Tryb pracownika");

        clientButton.setScaleX(2.6);
        clientButton.setScaleY(2.6);
        clientButton.setLayoutX(100);
        clientButton.setLayoutY(HEIGHT / 2);
        clientButton.setVisible(true);

        employeeButton.setScaleX(2.6);
        employeeButton.setScaleY(2.6);
        employeeButton.setLayoutX(400);
        employeeButton.setLayoutY(HEIGHT / 2);
        employeeButton.setVisible(true);

        getChildren().add(clientButton);
        getChildren().add(employeeButton);
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
}

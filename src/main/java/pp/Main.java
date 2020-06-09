package pp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ChoosePane choosePane = new ChoosePane();
        Scene scene = new Scene(choosePane);
        primaryStage.setTitle("Kino - projekt zaliczeniowy");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

        choosePane.clientButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                RootPane rootPane = new RootPane();
                scene.setRoot(rootPane);
                primaryStage.sizeToScene();
            }
        });

    }
}

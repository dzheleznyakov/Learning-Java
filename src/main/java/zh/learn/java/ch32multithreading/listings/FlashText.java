package zh.learn.java.ch32multithreading.listings;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FlashText extends Application {
    private String text = "";

    @Override
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        Label lblText = new Label("Programming is fun");
        pane.getChildren().add(lblText);

        new Thread(() -> {
            try {
                while (true) {
                    text = lblText.getText().trim().length() == 0 ? "Welcome" : "";
                    Platform.runLater(() -> lblText.setText(text));
                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
            }
        }).start();

        Scene scene = new Scene(pane, 200, 50);
        stage.setTitle("FlashText");
        stage.setScene(scene);
        stage.show();
    }
}

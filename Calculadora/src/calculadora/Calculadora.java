package calculadora;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;  

public class Calculadora extends Application {

    private double posMousex, posMousey = 0;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Interfaz_basica.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        //Para el movimiento de el programa mediante el mouse
        root.setOnMousePressed(mouseEvent -> {
            posMousex = mouseEvent.getSceneX();
            posMousey = mouseEvent.getSceneY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - posMousex);
            stage.setY(mouseEvent.getScreenY() - posMousey);
        });
        
        stage.setScene(scene);
        stage.getIcons().add(new Image("calculadora/img/Logo.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

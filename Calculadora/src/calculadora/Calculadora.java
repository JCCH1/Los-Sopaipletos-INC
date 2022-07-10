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

        //Para definir la barra de la ventana en transparente
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        //Para el movimiento de el programa mediante el mouse
        root.setOnMousePressed(mouseEvent -> {
            posMousex = mouseEvent.getSceneX();
            posMousey = mouseEvent.getSceneY();
        });
        
        //Para mover la ventana
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - posMousex);
            stage.setY(mouseEvent.getScreenY() - posMousey);
        });

        //Para definir el logo de la barra
        stage.setScene(scene);
        stage.getIcons().add(new Image("calculadora/img/Logo.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*Casos de prueba:
 * 1) 2*(2/5))/(-1*(7/2)^2)/(5+(6*-3)
 * Resultado: 0.005024
 * 
 * 2)(6*((6*((8*4)/(-6/tan(100°))))/(cos(65°))))/(-1)
 * 
 * Resultado: -2576.524036
 * 
 * 3) (3*((2/5)+6)/((4^(cos(30°)+6))^(4*(6/3)))^(18))
 * 
 * Resultado: 1.051906
*/

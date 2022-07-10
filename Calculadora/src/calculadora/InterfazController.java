package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InterfazController implements Initializable {

    @FXML
    protected Canvas Display;
    @FXML
    protected Button Btn_Cientifico;
    @FXML
    protected Button Btn_CambiarBase;
    @FXML
    protected TextField textoSalida;
    @FXML
    protected TextField Txt_Input;
    @FXML
    protected TextArea textArea;
    @FXML
    protected Slider tamanoCaracteres;
    @FXML
    protected Button Btn_Aux;
    @FXML
    protected HBox barra;
    @FXML
    protected AnchorPane botonesEstandar;
    @FXML
    protected AnchorPane botonesCientificos1;
    @FXML
    protected AnchorPane botonesCientificos2;
    @FXML
    protected AnchorPane flechas;
    @FXML
    protected AnchorPane otrosBotones;
    @FXML
    protected AnchorPane padreCanvas;
    @FXML
    protected AnchorPane nombre;
    @FXML
    protected TextField precedencia;
    @FXML
    AnchorPane fondoInterfaz;

    ArrayList<Simbolo> lista_simbolos = new ArrayList();

    GraphicsContext gc;

    Logica l = new Logica(this);
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    FuncionesAuxiliares fa = new FuncionesAuxiliares();

    //Para los colores de los numeros y operadores
    Color colorNum = Color.GREEN;
    Color colorOp = Color.RED;

    //X e Y iniciales
    double pivot_x = 50;
    double pivot_y = 250;

    @FXML
    protected void Boton0_presionado() {
        l.agregarSimbolo(gc, 0, lista_simbolos, Display);
    }

    @FXML
    protected void Boton1_presionado() {
        l.agregarSimbolo(gc, 1, lista_simbolos, Display);
    }

    @FXML
    protected void Boton2_presionado() {
        l.agregarSimbolo(gc, 2, lista_simbolos, Display);
    }

    @FXML
    protected void Boton3_presionado() {
        l.agregarSimbolo(gc, 3, lista_simbolos, Display);
    }

    @FXML
    protected void Boton4_presionado() {
        l.agregarSimbolo(gc, 4, lista_simbolos, Display);
    }

    @FXML
    protected void Boton5_presionado() {
        l.agregarSimbolo(gc, 5, lista_simbolos, Display);
    }

    @FXML
    protected void Boton6_presionado() {
        l.agregarSimbolo(gc, 6, lista_simbolos, Display);
    }

    @FXML
    protected void Boton7_presionado() {
        l.agregarSimbolo(gc, 7, lista_simbolos, Display);
    }

    @FXML
    protected void Boton8_presionado() {
        l.agregarSimbolo(gc, 8, lista_simbolos, Display);
    }

    @FXML
    protected void Boton9_presionado() {
        l.agregarSimbolo(gc, 9, lista_simbolos, Display);
    }

    @FXML
    protected void BotonMas_presionado() {
        if (l.bloqueadorOperadorMultiple(lista_simbolos) == 0) {
            l.agregarSimbolo(gc, 10, lista_simbolos, Display);
        }
    }

    @FXML
    protected void BotonMenos_presionado() {
        if (lista_simbolos.isEmpty()) {
            l.agregarSimbolo(gc, 11, lista_simbolos, Display);
        }else if (l.contadorNegativos <2){
            l.agregarSimbolo(gc, 11, lista_simbolos, Display);
        }   
    }

    @FXML
    protected void BotonMultiplicar_presionado() {
        if (l.bloqueadorOperadorMultiple(lista_simbolos) == 0) {
            l.agregarSimbolo(gc, 12, lista_simbolos, Display);
        }
    }

    @FXML
    protected void BotonDivision_presionado() {
        if (!lista_simbolos.isEmpty()) {
            if (fa.conseguirUltimoSimbolo(lista_simbolos).getTipo() == 0
                || fa.conseguirUltimoSimbolo(lista_simbolos).valor == 18) {
                l.agregarSimbolo(gc, 13, lista_simbolos, Display);
            }
        }
    }

    @FXML
    protected void Btn_Igual() {
        fa.limpiarLista(lista_simbolos);
        try{
            String exp = l.listaATexto(lista_simbolos);
            String prec = fa.precedenc(exp);
            l.context.precedencia.setText(prec);
        }catch(Exception e){
            l.context.precedencia.setText("Ocurrió un problema");
        }
        fa.ordenCalcular(lista_simbolos, l);
    }

    @FXML
    protected void BotonRaiz_presionado() {
        l.agregarSimbolo(gc, 21, lista_simbolos, Display);

    }

    @FXML 
    protected void BotonCambiarBase_presionado() {
        if(Btn_CambiarBase.getText().equals("Binario")){
            Btn_CambiarBase.setText("Decimal");
            l.cambiaDecimales(lista_simbolos,gc,Display);
            fg.limpiarCanvas(gc, Display);
            fg.dibujarTodosLosSimbolos(gc, lista_simbolos);
        }else{
            Btn_CambiarBase.setText("Binario");
            l.cambiaBinarios(lista_simbolos,gc,Display);
            fg.limpiarCanvas(gc, Display);
            fg.dibujarTodosLosSimbolos(gc, lista_simbolos);
        }
    }

    @FXML
    protected void BotonParentesisAbierto_presionado() {
        l.agregarSimbolo(gc, 17, lista_simbolos, Display);
    }

    @FXML
    protected void BotonParentesisCerrado_presionado() {
        if (!l.ParentesisAbiertos.isEmpty()) {
            if (!lista_simbolos.isEmpty()) {
                Simbolo s = fa.conseguirUltimoSimbolo(lista_simbolos);
                if (s.tipo == 0 || (s.tipo != 0 && (s.valor < 10 || s.valor > 13))) {
                    l.agregarSimbolo(gc, 18, lista_simbolos, Display);
                }
            }
        }
    }

    @FXML
    protected void BotonGrado_presionado() {
        if (!lista_simbolos.isEmpty()) {
            if (fa.conseguirUltimoSimbolo(lista_simbolos).tipo == 0) {
                l.agregarSimbolo(gc, 20, lista_simbolos, Display);
            }
        }
    }

    @FXML
    protected void BotonAC_presionado() {
        l.resetEstado();
        fg.borrarTodo(gc, Display, lista_simbolos, l.pivot_x);
        if(Btn_CambiarBase.getText().equals("Binario")){
            Btn_CambiarBase.setText("Decimal");
        }
    }

    @FXML
    protected void BotonPuntosControl_presionado() {
        l.switchPuntosControl(lista_simbolos, gc, Display);
    }

    @FXML
    protected void Slider_presionado() {
        double valor = tamanoCaracteres.getValue();
        switch ((int) valor) {
            case 1:
                l.cambiarTamano(0.35);
                l.factor = 0.35;
                break;
            case 2:
                l.cambiarTamano(0.50);
                l.factor = 0.50;
                break;
            case 3:
                l.cambiarTamano(1);
                l.factor = 1;
                break;
            case 4:
                l.cambiarTamano(1.50);
                l.factor = 1.50;
                break;
            case 5:
                l.cambiarTamano(1.75);
                l.factor = 1.75;
                break;
        }
    }

    
    @FXML
    protected void BotonMaximizar_presionado() {
        Stage stage = (Stage) fondoInterfaz.getScene().getWindow();
        if (stage.isMaximized()) {
            stage.setMaximized(false);
            Display.setWidth(550); //Display
            Display.setHeight(250);
            barra.setLayoutX(500);
            botonesEstandar.setLayoutX(184);
            botonesEstandar.setLayoutY(432);
            Txt_Input.setLayoutX(402);
            Txt_Input.setLayoutY(458);
            textoSalida.setLayoutX(77); //Barra
            textoSalida.setLayoutY(325);
            botonesCientificos1.setLayoutX(96); //Botones cientificos
            botonesCientificos1.setLayoutY(482); 
            botonesCientificos2.setLayoutX(185); //Botones cientificos
            botonesCientificos2.setLayoutY(380);
            otrosBotones.setLayoutX(78); //Otros botones
            otrosBotones.setLayoutY(358);
            flechas.setLayoutX(43); //Flechas
            flechas.setLayoutY(423);
            nombre.setLayoutX(5); //Nombre
            nombre.setLayoutY(5);
            nombre.getStyleClass().clear();
            nombre.getStyleClass().add("name");
            nombre.setPrefSize(200, 27);
            precedencia.setLayoutX(77); //Precedencia
            precedencia.setLayoutY(295);
            l.dibujarSimbolos();

        } else {
            stage.setMaximized(true);
            stage.setMaximized(true);
            double ancho = stage.getWidth();
            double largo = stage.getHeight();
            Display.setWidth(ancho-500); //Display
            Display.setHeight(largo-50);
            Btn_Aux.setLayoutX(ancho-25); //Fondo
            Btn_Aux.setLayoutY(largo-25);
            barra.setLayoutX(ancho-90); //Min,Max,Close
            botonesEstandar.setLayoutX(ancho-350); //Botones normales
            botonesEstandar.setLayoutY(largo-400);
            Txt_Input.setLayoutX(ancho-250); //Escribir
            Txt_Input.setLayoutY(largo-130);
            textoSalida.setLayoutX(ancho-455); //Barra
            textoSalida.setLayoutY(200);
            botonesCientificos1.setLayoutX(ancho-160); //Botones cientificos
            botonesCientificos1.setLayoutY(largo-398); 
            botonesCientificos2.setLayoutX(ancho-350); //Botones cientificos
            botonesCientificos2.setLayoutY(largo-460);
            otrosBotones.setLayoutX(ancho-455); //Otros botones
            otrosBotones.setLayoutY(250);
            flechas.setLayoutX(ancho-400); //Flechas
            flechas.setLayoutY(largo-100);
            nombre.setLayoutX(ancho-450); //Nombre
            nombre.setLayoutY(80);
            nombre.getStyleClass().clear();
            nombre.getStyleClass().add("nameGrande");
            nombre.setPrefSize(400, 54);
            precedencia.setLayoutX(ancho-455); //Precedencia
            precedencia.setLayoutY(150);
            l.dibujarSimbolos();
        }
    }

    @FXML
    protected void BotonCientifico_presionado() {
        if (botonesCientificos1.isVisible() == true) {
            botonesCientificos1.setVisible(false);
            botonesCientificos2.setVisible(false);
            Btn_Cientifico.setText("Básico");
        } else {
            botonesCientificos1.setVisible(true);
            botonesCientificos2.setVisible(true);
            Btn_Cientifico.setText("Científico");
        }
    }

    @FXML
    protected void Cerrar() {
        Platform.exit();
    }

    @FXML
    protected void minimizar() {
        Stage stage = (Stage) fondoInterfaz.getScene().getWindow();
        stage.setIconified(true);
    }
    
    @FXML
    protected void BotonArriba_presionado() {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).moverAbajo(1);
        }
        l.pivot_y = l.pivot_y + 22;
        l.dibujarSimbolos();
    }

    @FXML
    protected void BotonAbajo_presionado() {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).moverArriba(1);
        }
        l.pivot_y = l.pivot_y - 22;
        l.dibujarSimbolos();
    }

    @FXML
    protected void BotonDerecha_presionado() {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).moverIzquierda(1);
        }

        l.pivot_x = l.pivot_x - 15;
        l.dibujarSimbolos();

    }

    @FXML
    protected void BotonIzquierda_presionado() {
        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).moverDerecha(1);

        }

        l.pivot_x = l.pivot_x + 15;
        l.dibujarSimbolos();

    }

    @FXML
    protected void BotonPotencia_presionado() {
        if (!lista_simbolos.isEmpty()) {
            if (!l.enPotencia) {
                l.enPotencia = true;
                l.fa.getAlturaSimbolo(l);
                l.agregarSimbolo(gc, -1, lista_simbolos, Display);
            }
        }
    }

    @FXML
    protected void BotonIngresarFormula_presionado() {
        l.resetEstado();
        lista_simbolos.clear();

        String cadena = Txt_Input.getText();

        boolean enPotencia = false;
        int contadorPotencia = 0;
        int aux = 0;

        int valorChar;

        for (int i = 0; i < cadena.length(); i++) {
            valorChar = cadena.charAt(i);
            if (enPotencia) {
                if (contadorPotencia == 0 & aux != 0) {
                    l.enPotencia = false;
                }
            }
            if (valorChar >= 48 && valorChar <= 67) {
                l.agregarSimbolo(gc, valorChar - 48, lista_simbolos, Display);
            } else {
                switch (cadena.charAt(i)) {
                    case '√':
                        BotonRaiz_presionado();
                        break;
                    case '^':
                        BotonPotencia_presionado();
                        break;
                    case '+':
                        BotonMas_presionado();
                        break;
                    case '-':
                        BotonMenos_presionado();
                        break;
                    case '*':
                        BotonMultiplicar_presionado();
                        break;
                    case '/':
                        BotonDivision_presionado();
                        break;
                    case 's':
                    case 'S':
                        BotonSeno_presionado();
                        i = i + 2;
                        break;
                    case 'c':
                    case 'C':
                        BotonCos_presionado();
                        i = i + 2;
                        break;
                    case 't':
                    case 'T':
                        BotonTan_presionado();
                        i = i + 2;
                        break;
                    case '(':
                        if (enPotencia) {
                            contadorPotencia++;
                            aux++;
                        }
                        l.agregarSimbolo(gc, 17, lista_simbolos, Display);
                        break;
                    case ')':
                        if (enPotencia) {
                            contadorPotencia--;
                            l.enPotencia = true;
                            enPotencia = true;
                            fa.getAlturaSimbolo(l);
                        }
                        BotonParentesisCerrado_presionado();
                        break;
                    case '!':
                        BotonFact_presionado();
                        break;
                    case '°':
                        BotonGrado_presionado();
                        break;
                }
            }
        }
    }

    @FXML
    protected void BotonSeno_presionado() {
        l.agregarSimbolo(gc, 14, lista_simbolos, Display);
    }

    @FXML
    protected void BotonCos_presionado() {
        l.agregarSimbolo(gc, 15, lista_simbolos, Display);
    }

    @FXML
    protected void BotonTan_presionado() {
        l.agregarSimbolo(gc, 16, lista_simbolos, Display);
    }

    @FXML
    protected void BotonFact_presionado() {
        if (!lista_simbolos.isEmpty()) {
            if (fa.conseguirUltimoSimbolo(lista_simbolos).tipo == 0) {
                l.agregarSimbolo(gc, 19, lista_simbolos, Display);
            }
        }
    }

    //Colores
    @FXML
    protected void BotonColorNum_Azul() {
        colorNum = Color.web("#0D3C94");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorNum_Rojo() {
        colorNum = Color.web("#CC0000");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorNum_Verde() {
        colorNum = Color.web("#32940D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorNum_Cafe() {
        colorNum = Color.web("#94550D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorNum_Morado() {
        colorNum = Color.web("#540E64");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorNum_Naranjo() {
        colorNum = Color.web("#E56B20");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorOp_Azul() {
        colorOp = Color.web("#0D3C94");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorOp_Rojo() {
        colorOp = Color.web("#CC0000");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorOp_Verde() {
        colorOp = Color.web("#32940D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorOp_Cafe() {
        colorOp = Color.web("#94550D");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorOp_Morado() {
        colorOp = Color.web("#540E64");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @FXML
    protected void BotonColorOp_Naranjo() {
        colorOp = Color.web("#E56B20");
        fg.actualizarColores(gc, lista_simbolos, colorNum, colorOp, Display);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = Display.getGraphicsContext2D();
    }
}
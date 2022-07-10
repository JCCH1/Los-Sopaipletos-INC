package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Operaciones {

    protected double suma(ArrayList<Simbolo> lista_simbolos, int posici, GraphicsContext gc, Canvas Display) {
        Simbolo numero1 = lista_simbolos.get(posici - 1);
        Simbolo numero2 = lista_simbolos.get(posici + 1);
        System.out.println("numero1: " + numero1.valor);
        System.out.println("numero2: " + numero2.valor);
        numero1.valor = numero1.valor + numero2.valor;
        
        for(int i = 0; i < lista_simbolos.size(); i++){
            System.out.print(" aqui" + lista_simbolos.get(i).valor + ", i: " + i);
        }

        return numero1.valor;
    }
}

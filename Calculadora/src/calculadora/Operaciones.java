package calculadora;

import java.util.ArrayList;

public class Operaciones {
    protected ArrayList<Simbolo> suma(ArrayList<Simbolo> lista_simbolos){
        String string1 = "";
        String string2 = "";
        ArrayList<Simbolo> numSuma = new ArrayList<>(); 
        Simbolo a = new Simbolo();
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    string2 = string1;
                }
                if (s.valor == 11) {
                    string2 = string1;
                }
                if (s.valor == 12) {
                    string2 = string1;
                }
                if (s.valor == 13) {
                    string2 = string1;
                }
                if (s.valor == 14) {
                    string2 = string1;
                }
                if (s.valor == 15) {
                    string2 = string1;
                }
                if (s.valor == 16) {
                    string2 = string1;
                }
                if (s.valor == 17) {
                    string2 = string1;
                }
                if (s.valor == 18) {
                    string2 = string1;
                }
                if (s.valor == 19) {
                    string2 = string1;
                }
                if (s.valor == 20) {
                    string2 = string1;
                }
                if (s.valor == 21) {
                    string2 = string1;
                }

            } else if (s.valor == -1) {
                string2 = string1;
            } else {
                System.out.print(s.valor);
                string1 = string1 + s.valor;
                
            }

        }
        int n = Integer.parseInt(string1);
        int m = Integer.parseInt(string2);
        int resultado = m+n;
        System.out.println("Funciona suma: " + resultado);

        return numSuma;
    }
}

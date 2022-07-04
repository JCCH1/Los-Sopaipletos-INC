package calculadora;

import java.util.ArrayList;

public class Operaciones {
    protected ArrayList<Simbolo> igual (ArrayList<Simbolo> lista_simbolos){
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    System.out.println("suma: " + suma(lista_simbolos) + "....");
                }
                if (s.valor == 11) {
                    System.out.println("resta: " + resta(lista_simbolos) + "....");
                }
                if (s.valor == 12) {
                    System.out.println("multiplicacion: " + multiplicacion(lista_simbolos) + "....");
                }
                if (s.valor == 13) {
                    System.out.println("division: " + division(lista_simbolos) + "....");
                }
                if (s.valor == 14) {
                    break;
                }
                if (s.valor == 15) {
                    break;
                }
                if (s.valor == 16) {
                    break;
                }
                if (s.valor == 17) {
                    break;
                }
                if (s.valor == 18) {
                    break;
                }
                if (s.valor == 19) {
                    break;
                }
                if (s.valor == 20) {
                    break;
                }
                if (s.valor == 21) {
                    break;
                }

            } else if (s.valor == -1) {
                break;
            } else {
                System.out.print(" ");              
            }
        }
        return lista_simbolos;
    }

    protected int suma(ArrayList<Simbolo> lista_simbolos){
        String string1 = "";
        String string2 = "";
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    string2 = string1;
                    string1 = "";
                }
                if (s.valor == 11) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 12) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 13) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 14) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 15) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 16) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 17) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 18) {
                    string2 = string1;
                }
                if (s.valor == 19) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 20) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 21) {
                    string2 = string1;
                    break;
                }

            } else if (s.valor == -1) {
                string2 = string1;
                break;
            } else {
                //System.out.print(s.valor);
                string1 = string1 + s.valor;
                
            }

        }
        int n = Integer.parseInt(string1);
        int m = Integer.parseInt(string2);
        int resultado = m+n;
        return resultado;
    }


    protected int resta(ArrayList<Simbolo> lista_simbolos){
        String string1 = "";
        String string2 = "";
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 11) {
                    string2 = string1;
                    string1 = "";
                }
                if (s.valor == 12) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 13) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 14) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 15) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 16) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 17) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 18) {
                    string2 = string1;
                }
                if (s.valor == 19) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 20) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 21) {
                    string2 = string1;
                    break;
                }

            } else if (s.valor == -1) {
                string2 = string1;
                break;
            } else {
                //System.out.print(s.valor);
                string1 = string1 + s.valor;
                
            }

        }
        int n = Integer.parseInt(string1);
        int m = Integer.parseInt(string2);
        int resultado = m-n;
        return resultado;
    }

    protected int multiplicacion(ArrayList<Simbolo> lista_simbolos){
        String string1 = "";
        String string2 = "";
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 11) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 12) {
                    string2 = string1;
                    string1 = "";
                }
                if (s.valor == 13) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 14) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 15) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 16) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 17) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 18) {
                    string2 = string1;
                }
                if (s.valor == 19) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 20) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 21) {
                    string2 = string1;
                    break;
                }
    
            } else if (s.valor == -1) {
                string2 = string1;
                break;
            } else {
                //System.out.print(s.valor);
                string1 = string1 + s.valor;
                
            }
    
        }
        int n = Integer.parseInt(string1);
        int m = Integer.parseInt(string2);
        int resultado = m*n;
        return resultado;
    }

    protected int division(ArrayList<Simbolo> lista_simbolos){
        String string1 = "";
        String string2 = "";
        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 11) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 12) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 13) {
                    string2 = string1;
                    string1 = "";
                }
                if (s.valor == 14) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 15) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 16) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 17) {
                   System.out.println(); 
                }
                if (s.valor == 18) {
                    System.out.println();
                }
                if (s.valor == 19) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 20) {
                    string2 = string1;
                    break;
                }
                if (s.valor == 21) {
                    string2 = string1;
                    break;
                }
    
            } else if (s.valor == -1) {
                string2 = string1;
                break;
            } else {
                //System.out.print(s.valor);
                string1 = string1 + s.valor;
                
            }
    
        }
        int n = Integer.parseInt(string1);
        int m = Integer.parseInt(string2);
        int resultado = m/n;
        return resultado;
    }

}

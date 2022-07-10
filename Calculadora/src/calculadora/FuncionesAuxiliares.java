package calculadora;

import java.util.ArrayList;
import java.util.Stack;

public class FuncionesAuxiliares {

    protected void moverPivotDerecha(Logica l, Simbolo s) {
        if (s.getValor() > 13 && s.getValor() < 17) {
            l.pivot_x = l.pivot_x + (l.espacioEntreSimbolos * 3);
            l.d.listaMovimientosHaciaDerecha.set(l.d.listaMovimientosHaciaDerecha.size() - 1,
                l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size() - 1) + 3);
            l.d.movimientosDerecha = l.d.movimientosDerecha + 3;
        } else {
            l.pivot_x = l.pivot_x + l.espacioEntreSimbolos;
            l.d.listaMovimientosHaciaDerecha.set(l.d.listaMovimientosHaciaDerecha.size() - 1,
                l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size() - 1) + 1);
            l.d.movimientosDerecha = l.d.movimientosDerecha + 1;
        }
    }

    protected void moverPivotDerechaPotencia(Logica l) {
        l.pivot_x = l.pivot_x + (l.espacioEntreSimbolos / 2);
        l.d.listaMovimientosHaciaDerecha.set(l.d.listaMovimientosHaciaDerecha.size() - 1,
            l.d.listaMovimientosHaciaDerecha.get(l.d.listaMovimientosHaciaDerecha.size() - 1) + 0.7);
    }

    protected double getAlturaSimbolo(Logica l) {
        return l.pivot_y = conseguirUltimoSimbolo(l.context.lista_simbolos).getAlturaSimbolo() + 40;
    }

    protected void moverPivotAbajo(Logica l, double distancia) {

        l.pivot_y = l.pivot_y + distancia;
    }

    protected void moverPivotADenominador(Logica l) {
        if (!l.ParentesisAbiertos.isEmpty()) {
            l.pivot_x = l.ParentesisAbiertos.get(l.ParentesisAbiertos.size() - 1).Xpos;
        } else {
            l.pivot_x = l.context.lista_simbolos.get(0).Xpos - l.espacioEntreSimbolos;
        }
    }

    protected Simbolo conseguirUltimoSimbolo(ArrayList<Simbolo> lista_simbolos) {

        if (!lista_simbolos.isEmpty()) {
            return lista_simbolos.get(lista_simbolos.size() - 1);
        } else {
            return null;
        }
    }

    protected void posicionarParentesisDeCierre(Logica l, Simbolo s) {
        int contador = 1;
        double coordenadaXmasLejana = l.pivot_x;

        for (int i = l.context.lista_simbolos.size() - 1; i >= 0; i--) {
            if (l.context.lista_simbolos.get(i).valor == 18) {
                contador++;
            }
            if (l.context.lista_simbolos.get(i).valor == 17) {
                contador--;
            }
            if (contador == 0) {
                break;
            } else {
                if (l.context.lista_simbolos.get(i).Xpos > coordenadaXmasLejana) {
                    coordenadaXmasLejana = l.context.lista_simbolos.get(i).Xpos;
                }
            }

        }

        s.Xpos = coordenadaXmasLejana;
        l.pivot_x = coordenadaXmasLejana;

    }

    protected String buscarNumero(ArrayList<Simbolo> lista_simbolos, int posicion) {
        String numero = "";
        if (posicion == 1) {
            if (lista_simbolos.get(posicion - 1).valor == 11) {
                numero = numero + "-";
            }
        } else if (posicion > 1) {
            if (lista_simbolos.get(posicion - 1).valor == 11 && (lista_simbolos.get(posicion - 2).tipo != 0 && lista_simbolos.get(posicion - 2).valor != 18)) {
                numero = numero + "-";
            }
        }
        for (int i = posicion; i < lista_simbolos.size(); i++) {
            if (lista_simbolos.get(i).tipo != 0) {
                break;
            } else {
                numero = numero + lista_simbolos.get(i).getValorString();
            }
        }
        return numero;

    }

    protected int factorial(int i) {
        if (i <= 2) {
            return i;
        } else {
            return i * factorial(i - 1);
        }
    }

    protected void operacion(ArrayList<Simbolo> numerosAoperar, int operacion) {
        Simbolo numeroAnterior = numerosAoperar.get(numerosAoperar.size() - 1);
        Simbolo anteriorAnumeroAnterior = new Simbolo();
        if (numerosAoperar.size() > 1) {
            anteriorAnumeroAnterior = numerosAoperar.get(numerosAoperar.size() - 2);
        }
        Simbolo resultado = new Simbolo();
        switch (operacion) {
            case -3:
                resultado.resultado = numeroAnterior.resultado * -1;
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case -1:
                resultado.resultado = Math.pow(anteriorAnumeroAnterior.resultado, numeroAnterior.resultado);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 10:
                resultado.resultado = anteriorAnumeroAnterior.resultado + numeroAnterior.resultado;
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 11:
                resultado.resultado = anteriorAnumeroAnterior.resultado - numeroAnterior.resultado;
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 12:
                resultado.resultado = anteriorAnumeroAnterior.resultado * numeroAnterior.resultado;
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 13:
                resultado.resultado = anteriorAnumeroAnterior.resultado / numeroAnterior.resultado;
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 14:
                resultado.resultado = Math.sin(numeroAnterior.resultado);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 15:
                resultado.resultado = Math.cos(numeroAnterior.resultado);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            case 16:
                resultado.resultado = Math.tan(numeroAnterior.resultado);
                numerosAoperar.remove(numerosAoperar.size() - 1);
                numerosAoperar.add(resultado);
                break;
            default:
                break;
        }

        if (operacion == 19) {
            resultado.resultado = factorial((int) numeroAnterior.resultado);
            numerosAoperar.remove(numerosAoperar.size() - 1);
            numerosAoperar.add(resultado);
        }

        if (operacion == 20) {
            resultado.resultado = Math.toRadians(numeroAnterior.resultado);
            numerosAoperar.remove(numerosAoperar.size() - 1);
            numerosAoperar.add(resultado);
        }
        if (operacion == 21) {
            resultado.resultado = Math.sqrt(numeroAnterior.resultado);
            numerosAoperar.remove(numerosAoperar.size() - 1);
            numerosAoperar.add(resultado);
        }

        System.out.println("Subresultado: " + numerosAoperar.get(numerosAoperar.size() - 1).resultado);

    }

    protected double calcular(ArrayList<Simbolo> cadena){

        ArrayList<Simbolo> numerosAoperar = new ArrayList();

        for (int i = 0; i < cadena.size(); i++) {
            if (cadena.get(i).tipo == 0) {
                numerosAoperar.add(cadena.get(i));
            } else {
                if (cadena.get(i).valor == -3) {
                    operacion(numerosAoperar, -3);
                }
                if (cadena.get(i).valor == -1) {
                    operacion(numerosAoperar, -1);
                }
                if (cadena.get(i).valor == 10) {
                    operacion(numerosAoperar, 10);
                }
                if (cadena.get(i).valor == 11) {
                    operacion(numerosAoperar, 11);
                }
                if (cadena.get(i).valor == 12) { 
                    operacion(numerosAoperar, 12);
                }
                if (cadena.get(i).valor == 13) { 
                    operacion(numerosAoperar, 13);
                }
                if (cadena.get(i).valor == 14) {
                    operacion(numerosAoperar, 14);
                }
                if (cadena.get(i).valor == 15) {
                    operacion(numerosAoperar, 15);
                }
                if (cadena.get(i).valor == 16) {
                    operacion(numerosAoperar, 16);
                }
                if (cadena.get(i).valor == 19) { 
                    operacion(numerosAoperar, 19);
                }
                if (cadena.get(i).valor == 20) {
                    operacion(numerosAoperar, 20);
                }
                if (cadena.get(i).valor == 21) {
                    operacion(numerosAoperar, 21);
                }
            }
        }
        return numerosAoperar.get(0).resultado;
    }

    static int Precedencia(char caracter){
		switch (caracter){
		case '+':
		case '-':
			return 1;
	
		case '*':
		case '/':
			return 2;
	
		case '^':
			return 3;
		}
		return -1;
	}

    protected String precedenc(String expresion) {
		String resultado = new String("");
		Stack<Character> monton = new Stack<>();
		for (int i = 0; i<expresion.length(); ++i){
			char caract = expresion.charAt(i);
			
			if (Character.isLetterOrDigit(caract)){
                resultado += caract;
            }
			else if (caract == '('){
                monton.push(caract);
            }	
			else if (caract == ')'){
				while (!monton.isEmpty() && monton.peek() != '('){
                    resultado += monton.pop();
                }
				monton.pop();
			}
			else{
				while (!monton.isEmpty() && Precedencia(caract) <= Precedencia(monton.peek())){
					resultado += monton.pop();
			    }   
				monton.push(caract);
			}
		}
	
		while (!monton.isEmpty()){
			if(monton.peek() == '('){
                System.out.println("Expresion no valida");
            }
			resultado += monton.pop();
		}
        return resultado;
    }

    protected void resultadoEnCanvas(double resultado, Logica l) {
        String resultadoString = Double.toString(Math.round(resultado * 100000000.0) / 100000000.0);

        l.context.lista_simbolos.clear();

        if (resultado != Double.POSITIVE_INFINITY) {
            String caracter;
            for (int i = 0; i < resultadoString.length(); i++) {
                caracter = Character.toString(resultadoString.charAt(i));
                if (".".equals(caracter)) {
                    l.agregarSimbolo(l.context.gc, -2, l.context.lista_simbolos, l.context.Display);
                } else if ("-".equals(caracter)) {
                    l.agregarSimbolo(l.context.gc, 11, l.context.lista_simbolos, l.context.Display);
                } else if (Integer.valueOf(caracter) >= 0 && Integer.valueOf(caracter) <= 9) {
                    l.agregarSimbolo(l.context.gc, Integer.valueOf(caracter), l.context.lista_simbolos, l.context.Display);
                }
            }
        } else {
            l.agregarSimbolo(l.context.gc, 11, l.context.lista_simbolos, l.context.Display);
            l.agregarSimbolo(l.context.gc, 1, l.context.lista_simbolos, l.context.Display);
        }
        l.dibujarSimbolos();
    }

    protected ArrayList<Simbolo> sacarOperaciones(ArrayList<Simbolo> lista_simbolos) {
        ArrayList<Simbolo> lista_operaciones = new ArrayList();

        int numero;

        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = new Simbolo();
            if (lista_simbolos.get(i).tipo != 0) {
                lista_operaciones.add(lista_simbolos.get(i));
            } else {
                numero = Integer.parseInt(buscarNumero(lista_simbolos, i));
                String numeroStr = String.valueOf(numero);
                if (numero < 0) {
                    lista_operaciones.remove(lista_operaciones.size() - 1);
                    i = i + numeroStr.length() - 2;
                } else {
                    i = i + numeroStr.length() - 1;
                }
                s.valor = numero;
                s.resultado = numero;
                lista_operaciones.add(s);
            }

        }
        return lista_operaciones;
    }

    protected void ordenCalcular(ArrayList<Simbolo> lista_simbolos, Logica l) {
        ArrayList<Simbolo> lista_Ordenada = sacarOperaciones(lista_simbolos);
        l.resetEstado();

        ArrayList<Simbolo> operacionesMath = new ArrayList();
        ArrayList<Simbolo> operadores = new ArrayList();

        for (int i = 0; i < lista_Ordenada.size(); i++) {
            if (lista_Ordenada.get(i).tipo == 0) { 
                operacionesMath.add(lista_Ordenada.get(i));
                
            } else{
                if (lista_Ordenada.get(i).valor == 18) {
                    for (int j = operadores.size() - 1; j >= 0; j--) {
                        if (operadores.get(j).valor == 17) {
                            operadores.remove(j);
                            break;
                        } else {
                            operacionesMath.add(operadores.get(j));
                            operadores.remove(j);
                        }
                    }

                } else {
                    if (lista_Ordenada.get(i).valor != 17) { // Si no es un parentesis de apertura
                        if (!operadores.isEmpty()) { //Si la pila no está vacia
                            int largoLista = operadores.size() - 1;
                            while ((lista_Ordenada.get(i).valorPrecedencia < operadores.get(largoLista).valorPrecedencia
                                || (lista_Ordenada.get(i).valorPrecedencia == operadores.get(largoLista).valorPrecedencia))) {
                                operacionesMath.add(operadores.get(largoLista));
                                operadores.remove(largoLista);
                                largoLista = largoLista - 1;
                                if (largoLista == -1) {
                                    break;
                                }
                            }

                        }

                    }
                    operadores.add(lista_Ordenada.get(i));
                }
            }
        }

        // /*
        if (!operadores.isEmpty()) {
            for (int i = operadores.size() - 1; i >= 0; i--) {
                operacionesMath.add(operadores.get(i));
            }
        }

        resultadoEnCanvas(calcular(operacionesMath), l);

    }

    protected void limpiarLista(ArrayList<Simbolo> lista_simbolos) {
        lista_simbolos.removeIf(s -> (s.tipo == -1 && s.valor < -1));
    }

}
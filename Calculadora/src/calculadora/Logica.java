package calculadora;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Logica {

    double pivot_x = 50;
    double pivot_y = 250;
    double espacioEntreSimbolos = 15;
    double factor = 1;
    double pivot_yPrePotencia;
    double movimientosDeLista = 0;
    
    int puntosControlActivo = 0;
    int contadorNegativos;

    ArrayList<Simbolo> ParentesisAbiertos = new ArrayList();
    ArrayList<Simbolo> parentesisEnPotencia = new ArrayList();

    boolean Check = false;
    boolean enDivision;
    boolean enPotencia = false;

    InterfazController context;

    Simbolo simboloMasApartado = new Simbolo();
    division d = new division();
    CoordenadasSimbolos cs = new CoordenadasSimbolos();
    FuncionesGraficadoras fg = new FuncionesGraficadoras();
    FuncionesAuxiliares fa = new FuncionesAuxiliares();
    

    public Logica(InterfazController context) {
        this.context = context;
    }

    protected void agregarSimbolo(GraphicsContext gc, int nSimbolo,
        ArrayList<Simbolo> lista_simbolos,
        Canvas Display) {
        
        if(nSimbolo == 11){
            contadorNegativos++;
        }else {
            contadorNegativos = 0;
        }

        if (context.lista_simbolos.isEmpty()) {
            simboloMasApartado.Ypos = context.pivot_y;
            simboloMasApartado.Xpos = context.pivot_x;
        }

        if (pivot_x > simboloMasApartado.Xpos) {
            simboloMasApartado.Xpos = pivot_x;
        }

        Simbolo s = new Simbolo();
        s.setXpos(pivot_x);
        s.setYpos(pivot_y);
        s.Xfactor = factor;
        s.Yfactor = factor;

        //Iniciación de una forma general
        double[] forma;

        if (Check) {
            checkPotencias(nSimbolo);
        }

        switch (nSimbolo) {
            case -2: //punto
                if (enPotencia) {
                    forma = cs.puntoPot(pivot_x, pivot_y);
                } else {
                    forma = cs.punto(pivot_x, pivot_y);
                }
                s.setForma(forma);
                s.setValor(-2);
                s.setColor(context.colorNum);
                s.setTipo(-2);
                lista_simbolos.add(s);
                break;
            case -1: //Apertura de potencias
                s.setTipo(-1);
                s.setValor(-1);
                s.setColor(Color.rgb(0, 0, 0, 0));
                s.valorPrecedencia = 9; //Mayor precedencia
                forma = cs.ceroPot(pivot_x, pivot_y);
                s.setForma(forma);
                pivot_x = pivot_x - 10; //Para que el siguiente simbolo este mas cerca del ultimo agregado.
                lista_simbolos.add(s);

                if (context.lista_simbolos.get(context.lista_simbolos.size() - 2).valor != 18) {
                    System.out.println("No hay parentesis antes de");
                    pivot_yPrePotencia = pivot_y;
                } else {
                    System.out.println("Hay parentesis antes de");
                    for (int k = context.lista_simbolos.size() - 3; k >= 0; k--) {
                        System.out.println("^Simbolo: " + context.lista_simbolos.get(k));
                        if (context.lista_simbolos.get(k).tipo == 0) {
                            pivot_yPrePotencia = context.lista_simbolos.get(k).Ypos;
                            break;
                        }
                    }

                }
                Check = true;
                break;
            case 0:
                if (enPotencia) {
                    forma = cs.ceroPot(pivot_x, pivot_y);
                } else {
                    forma = cs.cero(pivot_x, pivot_y);
                }
                s.setForma(forma);
                s.setValor(0);
                s.setColor(context.colorNum);
                s.setTipo(0);
                lista_simbolos.add(s);
                break;
            case 1:
                if (enPotencia) {
                    forma = cs.unoPot(pivot_x, pivot_y);
                } else {
                    forma = cs.uno(pivot_x, pivot_y);
                }
                s.setValor(1);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 2:
                if (enPotencia) {
                    forma = cs.dosPot(pivot_x, pivot_y);
                } else {
                    forma = cs.dos(pivot_x, pivot_y);
                }
                s.setValor(2);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 3:
                if (enPotencia) {
                    forma = cs.tresPot(pivot_x, pivot_y);
                } else {
                    forma = cs.tres(pivot_x, pivot_y);
                }
                s.setValor(3);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 4:
                if (enPotencia) {
                    forma = cs.cuatroPot(pivot_x, pivot_y);
                } else {
                    forma = cs.cuatro(pivot_x, pivot_y);
                }
                s.setValor(4);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 5:
                if (enPotencia) {
                    forma = cs.cincoPot(pivot_x, pivot_y);
                } else {
                    forma = cs.cinco(pivot_x, pivot_y);
                }
                s.setValor(5);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 6:
                if (enPotencia) {
                    forma = cs.seisPot(pivot_x, pivot_y);
                } else {
                    forma = cs.seis(pivot_x, pivot_y);
                }
                s.setValor(6);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 7:
                if (enPotencia) {
                    forma = cs.sietePot(pivot_x, pivot_y);
                } else {
                    forma = cs.siete(pivot_x, pivot_y);
                }
                s.setValor(7);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 8:
                if (enPotencia) {
                    forma = cs.ochoPot(pivot_x, pivot_y);
                } else {
                    forma = cs.ocho(pivot_x, pivot_y);
                }
                s.setValor(8);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 9: // 9
                if (enPotencia) {
                    forma = cs.nuevePot(pivot_x, pivot_y);
                } else {
                    forma = cs.nueve(pivot_x, pivot_y);
                }
                s.setValor(9);
                s.setTipo(0);
                s.setColor(context.colorNum);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 10: //Suma
                if (enPotencia) {
                    forma = cs.masPot(pivot_x, pivot_y);
                } else {
                    forma = cs.mas(pivot_x, pivot_y);
                }
                s.valorPrecedencia = 1;
                s.setValor(10);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 11: //Resta
                if (enPotencia) {
                    forma = cs.menosPot(pivot_x, pivot_y);
                } else {
                    forma = cs.menos(pivot_x, pivot_y);
                }
                s.valorPrecedencia = 1;
                s.setValor(11);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 12: //Multiplicacion
                if (enPotencia) {
                    forma = cs.multiplicarPot(pivot_x, pivot_y);
                } else {
                    forma = cs.multiplicar(pivot_x, pivot_y);
                }
                s.valorPrecedencia = 2;
                s.setValor(12);
                s.setTipo(1);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 13: //division

                forma = cs.dividir(pivot_x, pivot_y);
                s.setValor(13);
                s.setTipo(1);
                s.valorPrecedencia = 2;
                s.setColor(context.colorOp);
                s.setForma(forma);
                d.nuevaDivision(this);
                d.crearLineaDivision(this, s);
                enDivision = true;
                d.Numeradores.add(s);
                dimensionarParentesisAbiertos(gc);
                lista_simbolos.add(s);
                break;
            case 14: //Seno
                s.setValor(14);
                s.setTipo(2);
                s.valorPrecedencia = 11;
                s.setColor(context.colorOp);
                formaOperadorCientifico(this, 14, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                fa.moverPivotDerechaPotencia(this);
                fa.moverPivotDerechaPotencia(this);
                break;
            case 15: //Coseno
                s.setValor(15);
                s.setTipo(2);
                s.valorPrecedencia = 11;
                s.setColor(context.colorOp);
                formaOperadorCientifico(this, 15, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                fa.moverPivotDerechaPotencia(this);
                fa.moverPivotDerechaPotencia(this);
                break;
            case 16: //Tangente
                s.setValor(16);
                s.setTipo(2);
                s.valorPrecedencia = 11;
                s.setColor(context.colorOp);
                formaOperadorCientifico(this, 16, pivot_x, pivot_y, s);
                lista_simbolos.add(s);
                fa.moverPivotDerechaPotencia(this);
                fa.moverPivotDerechaPotencia(this);
                break;
            case 17: //Parentesis Abierto
                if (enPotencia) {
                    forma = cs.pAbiertoPot(pivot_x, pivot_y);
                    parentesisEnPotencia.add(new Simbolo());
                } else {
                    forma = cs.pAbierto(pivot_x, pivot_y);
                }

                s.valorPrecedencia = 0;
                s.setValor(17);
                s.setTipo(2);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                ParentesisAbiertos.add(s);
                break;
            case 18: //Parentesis Cerrado
                s.setValor(18);
                s.setTipo(2);
                s.setColor(context.colorOp);
                s.enlace = ParentesisAbiertos.get(ParentesisAbiertos.size() - 1);
                fa.posicionarParentesisDeCierre(this, s);
                
                if (enPotencia) {
                    forma = cs.pCerradoPot(pivot_x, pivot_y);
                    if (!parentesisEnPotencia.isEmpty()) {
                        parentesisEnPotencia.remove(parentesisEnPotencia.size() - 1);
                    }
                } else {
                    forma = cs.pCerrado(pivot_x, pivot_y);
                }
                s.setForma(forma);
                s.setAlturaParentesis(ParentesisAbiertos.get(ParentesisAbiertos.size() - 1).getAlturaParentesis());

                lista_simbolos.add(s);

                ParentesisAbiertos.remove(ParentesisAbiertos.size() - 1); //Elimina el ultimo parentesis abierto

                if (ParentesisAbiertos.isEmpty()) {
                    d.Numeradores.clear();
                    enDivision = false;
                }
                break;
            case 19: //Factorial
                if (enPotencia) {
                    forma = cs.factorialPot(pivot_x, pivot_y);
                } else {
                    forma = cs.factorial(pivot_x, pivot_y);
                }
                s.setValor(19);
                s.valorPrecedencia = 2;
                s.setTipo(2);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 20: //grado
                if (enPotencia) {
                    forma = cs.gradoPot(pivot_x, pivot_y);
                } else {
                    forma = cs.grado(pivot_x, pivot_y);
                }
                s.valorPrecedencia = 3;
                s.setValor(20);
                s.setTipo(2);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
            case 21: //raiz
                if (enPotencia) {
                    forma = cs.raizPot(pivot_x, pivot_y);
                } else {
                    forma = cs.raiz(pivot_x, pivot_y);
                }
                s.valorPrecedencia = 3;
                s.setValor(21);
                s.setTipo(2);
                s.setColor(context.colorOp);
                s.setForma(forma);
                lista_simbolos.add(s);
                break;
        }
        d.centrarNumeradores(this);

        //Luego de insertar un simbolo, mueve el pivot hacia la derecha
        if (!enPotencia) {
            fa.moverPivotDerecha(this, s);
        } else {
            fa.moverPivotDerechaPotencia(this);
        }

        //Para activar los puntos de control de los simbolos
        if (puntosControlActivo == 1) {
            s.switchPuntosControl();
        }

        context.textoSalida.setText(listaATexto(lista_simbolos));
        dibujarSimbolos();
    }

    protected void dibujarSimbolos() {
        fg.limpiarCanvas(context.gc, context.Display);
        fg.dibujarTodosLosSimbolos(context.gc, context.lista_simbolos);

    }
   
    protected void cambiarTamano(double factor) {
        for (int i = 0; i < context.lista_simbolos.size(); i++) {
            context.lista_simbolos.get(i).Xfactor = factor;
            context.lista_simbolos.get(i).Yfactor = factor;
        }
        dibujarSimbolos();
    }

    protected void resetEstado() {
        enDivision = false;
        enPotencia = false;
        Check = false;
        ParentesisAbiertos.clear();
        context.pivot_x = 50;
        context.pivot_y = 250;
        pivot_x = 50;
        pivot_y = 250;
        movimientosDeLista = 0;
        context.textoSalida.setText("");

    }

    protected void formaOperadorCientifico(Logica l, int valor, double pivot_x, double pivot_y, Simbolo s) {

        double[] forma;

        switch (valor) {
            case 14: //Operador Seno
                if (enPotencia) {
                    forma = cs.sPot(pivot_x, pivot_y); //Agrega la S
                    s.forma = forma;
                    s.moverIzquierda(0.5);
                    forma = cs.iPot(pivot_x, pivot_y); //Agregar I
                    s.concatenarForma(forma);
                    s.moverIzquierda(0.5);
                    forma = cs.nPot(pivot_x, pivot_y); //Agregar N
                    s.concatenarForma(forma);
                    s.moverDerecha(1);

                } else {
                    forma = cs.s(pivot_x, pivot_y); //Agrega la S
                    s.forma = forma;
                    s.moverIzquierda(1);
                    forma = cs.i(pivot_x, pivot_y); //Agregar I
                    s.concatenarForma(forma);
                    s.moverIzquierda(1);
                    forma = cs.n(pivot_x, pivot_y); //Agregar N
                    s.concatenarForma(forma);
                    s.moverDerecha(2);
                    l.pivot_x = l.pivot_x - l.espacioEntreSimbolos;
                }
                break;
            case 15: //Operador Coseno
                if (enPotencia) {
                    forma = cs.cPot(pivot_x, pivot_y); //Agrega la C
                    s.forma = forma;
                    s.moverIzquierda(0.5);
                    forma = cs.oPot(pivot_x, pivot_y); //Agregar O
                    s.concatenarForma(forma);
                    s.moverIzquierda(0.5);
                    forma = cs.sPot(pivot_x, pivot_y); //Agregar S
                    s.concatenarForma(forma);
                    s.moverDerecha(1);

                } else {
                    forma = cs.c(pivot_x, pivot_y); //Agrega la C
                    s.forma = forma;
                    s.moverIzquierda(1);
                    forma = cs.o(pivot_x, pivot_y); //Agregar O
                    s.concatenarForma(forma);
                    s.moverIzquierda(1);
                    forma = cs.s(pivot_x, pivot_y); //Agregar S
                    s.concatenarForma(forma);
                    s.moverDerecha(2);
                    l.pivot_x = l.pivot_x - l.espacioEntreSimbolos;
                }
                break;
            case 16: //Operador Tangente
                if (enPotencia) {
                    forma = cs.tPot(pivot_x, pivot_y); //Agrega la T
                    s.forma = forma;
                    s.moverIzquierda(0.5);
                    forma = cs.aPot(pivot_x, pivot_y); //Agregar A
                    s.concatenarForma(forma);
                    s.moverIzquierda(0.5);
                    forma = cs.nPot(pivot_x, pivot_y); //Agregar N
                    s.concatenarForma(forma);
                    s.moverDerecha(1);

                } else {
                    forma = cs.t(pivot_x, pivot_y); //Agrega la T
                    s.forma = forma;
                    s.moverIzquierda(1);
                    forma = cs.a(pivot_x, pivot_y); //Agregar A
                    s.concatenarForma(forma);
                    s.moverIzquierda(1);
                    forma = cs.n(pivot_x, pivot_y); //Agregar N
                    s.concatenarForma(forma);
                    s.moverDerecha(2);
                    l.pivot_x = l.pivot_x - l.espacioEntreSimbolos;
                }
                break;
        }
    }

    protected void dimensionarParentesisAbiertos(GraphicsContext gc) {
        if (enPotencia) {
            for (int i = 0; i < ParentesisAbiertos.size(); i++) {
                ParentesisAbiertos.get(i).dimensionarParentesis(gc, 0.5);
                ParentesisAbiertos.get(i).aumentarVecesDimensionado();
            }
        } else {
            for (int i = 0; i < ParentesisAbiertos.size(); i++) {
                ParentesisAbiertos.get(i).dimensionarParentesis(gc, 1);
                ParentesisAbiertos.get(i).aumentarVecesDimensionado();
            }
        }
    }

    protected int bloqueadorOperadorMultiple(ArrayList<Simbolo> lista_simbolos) {
        int index = lista_simbolos.size() - 1;
        if (!lista_simbolos.isEmpty()) {
            if (index != -1) {
                if (lista_simbolos.get(index).tipo == 0 || lista_simbolos.get(index).tipo == 2) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }

        } else {
            return 1;
        }
    }

    protected void switchPuntosControl(ArrayList<Simbolo> lista_simbolos, GraphicsContext gc, Canvas Display) {

        for (int i = 0; i < lista_simbolos.size(); i++) {
            lista_simbolos.get(i).switchPuntosControl();
        }

        dibujarSimbolos();

        if (puntosControlActivo == 0) {
            puntosControlActivo = 1;
        } else {
            puntosControlActivo = 0;
        }

    }

    protected ArrayList<Simbolo> decimalAbinario(int numero, GraphicsContext gc,
    ArrayList<Simbolo> lista_simbolos, Canvas Display){
        resetEstado();
        lista_simbolos.clear();
        String number1 = Integer.toBinaryString(numero);
        char[] digits1 = number1.toCharArray();
        for(int i = 0; i < digits1.length; i++) {
            String numAux = String.valueOf(digits1[i]);
            int num = Integer.parseInt(numAux);
            agregarSimbolo(gc,num, lista_simbolos, Display);
        }
        return lista_simbolos; 
    }

    protected ArrayList<Simbolo> binarioAdecimal(int numero, GraphicsContext gc,
    ArrayList<Simbolo> lista_simbolos, Canvas Display){
        resetEstado();
        lista_simbolos.clear();
        String num1 = String.valueOf(numero);
        int decimal = Integer.parseInt(num1,2); 
        String num2 = String.valueOf(decimal);
        char[] digits1 = num2.toCharArray();
        for(int i = 0; i < digits1.length; i++) {
            String numAux = String.valueOf(digits1[i]);
            int num = Integer.parseInt(numAux);
            agregarSimbolo(gc,num, lista_simbolos, Display);
        }
        return lista_simbolos; 
    }
    
    public ArrayList<Simbolo> cambiaBinarios(ArrayList<Simbolo> lista_simbolos, GraphicsContext gc,
    Canvas Display){
        String n = "";
        for(int i = 0; i < lista_simbolos.size(); i++){
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    System.out.print(" + ");
                }
                if (s.valor == 11) {
                    System.out.print(" - ");
                }
                if (s.valor == 12) {
                    System.out.print(" * ");
                }
                if (s.valor == 13) {
                    System.out.print(" / ");
                }
                if (s.valor == 14) {
                    System.out.print(" Sin");
                }
                if (s.valor == 15) {
                    System.out.print(" Cos");
                }
                if (s.valor == 16) {
                    System.out.print(" Tan");
                }
                if (s.valor == 17) {
                    System.out.print("(");
                }
                if (s.valor == 18) {
                    System.out.print(")");
                }
                if (s.valor == 19) {
                    System.out.print("!");
                }
                if (s.valor == 20) {
                    System.out.print("°");
                }
                if (s.valor == 21) {
                    System.out.print("√");
                }
            } else{
                n+=s.valor;
                
            }                       
        }
        int N = Integer.parseInt(n);
        lista_simbolos = decimalAbinario(N,gc,lista_simbolos,Display);
        return lista_simbolos;
    }
    
    public ArrayList<Simbolo> cambiaDecimales(ArrayList<Simbolo> lista_simbolos, GraphicsContext gc,
    Canvas Display){
        String n = "";
        for(int i = 0; i < lista_simbolos.size(); i++){
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    System.out.print(" + ");
                }
                if (s.valor == 11) {
                    System.out.print(" - ");
                }
                if (s.valor == 12) {
                    System.out.print(" * ");
                }
                if (s.valor == 13) {
                    System.out.print(" / ");
                }
                if (s.valor == 14) {
                    System.out.print(" Sin");
                }
                if (s.valor == 15) {
                    System.out.print(" Cos");
                }
                if (s.valor == 16) {
                    System.out.print(" Tan");
                }
                if (s.valor == 17) {
                    System.out.print("(");
                }
                if (s.valor == 18) {
                    System.out.print(")");
                }
                if (s.valor == 19) {
                    System.out.print("!");
                }
                if (s.valor == 20) {
                    System.out.print("°");
                }
                if (s.valor == 21) {
                    System.out.print("√");
                }
            } else{
                n+=s.valor;
                
            }                       
        }
        int N = Integer.parseInt(n);
        lista_simbolos = binarioAdecimal(N,gc,lista_simbolos,Display);
        return lista_simbolos;
    }

    protected String listaATexto(ArrayList<Simbolo> lista_simbolos) {

        String string = "";

        for (int i = 0; i < lista_simbolos.size(); i++) {
            Simbolo s = lista_simbolos.get(i);
            if (s.valor > 9 && s.valor != -1) {
                if (s.valor == 10) {
                    System.out.print("+");
                    string = string + "+";
                }
                if (s.valor == 11) {
                    System.out.print("-");
                    string = string + "-";
                }
                if (s.valor == 12) {
                    System.out.print("*");
                    string = string + "*";
                }
                if (s.valor == 13) {
                    System.out.print("/");
                    string = string + "/";
                }
                if (s.valor == 14) {
                    System.out.print("sin");
                    string = string + "sin";
                }
                if (s.valor == 15) {
                    System.out.print("cos");
                    string = string + "cos";
                }
                if (s.valor == 16) {
                    System.out.print("tan");
                    string = string + "tan";
                }
                if (s.valor == 17) {
                    System.out.print("(");
                    string = string + "(";
                }
                if (s.valor == 18) {
                    System.out.print(")");
                    string = string + ")";
                }
                if (s.valor == 19) {
                    System.out.print("!");
                    string = string + "!";
                }
                if (s.valor == 20) {
                    System.out.print("°");
                    string = string + "°";
                }
                if (s.valor == 21) {
                    System.out.print("√");
                    string = string + "√";
                }

            } else if (s.valor == -1) {
                System.out.print("^");
                string = string + "^";
            } else if (s.valor == -2) {
                System.out.print(".");
                string = string + ".";
            } else {
                System.out.print(s.valor);
                string = string + s.valor;
            }

        }
        System.out.println();

        return string;
    }
    
    protected void checkPotencias(int n) {

        if ((n < 0 || n > 9) && n != 17 && parentesisEnPotencia.isEmpty()) {
            enPotencia = false;
            Check = false;
            pivot_y = pivot_yPrePotencia;
        }

    }

}
package calculadora;

import java.util.ArrayList;

public class division {

    ArrayList<Simbolo> Numeradores = new ArrayList();
    ArrayList<Double> listaMovimientosHaciaDerecha = new ArrayList();


    FuncionesAuxiliares fa = new FuncionesAuxiliares();

    double anchoAnterior = 0;
    double movimientosDerechaAnterior = 0;
    double movimientosDerecha = 0;
    double diferenciaLineaDivision = 0;
    double coordNumerador;

    Simbolo hayParentesis;
    Simbolo movimientoLinea;
    
    boolean lineaDivision = true;


    protected void nuevaDivision(Logica l) {
        movimientosDerechaAnterior = movimientosDerecha;
        movimientosDerecha = 0;
        conseguirNumeradores(l);
        if (l.enPotencia) {
            moverNumeradoresHaciaArriba(1);
            fa.moverPivotADenominador(l);
        } else {
            moverNumeradoresHaciaArriba(2);
            fa.moverPivotADenominador(l);
        }
    }

    protected void crearLineaDivision(Logica l, Simbolo s) {
        if (!l.ParentesisAbiertos.isEmpty()) {
            if (l.enPotencia) {
                s.forma[0] = l.pivot_x - 5;
            } else {
                s.forma[0] = l.pivot_x;
            }

        } else {
            s.forma[0] = l.context.lista_simbolos.get(0).Xpos - l.espacioEntreSimbolos;
        }

        s.forma[2] = coordNumerador;
        s.moverArriba(1);
        movimientoLinea = s;
    }


    protected void moverNumeradoresHaciaArriba(double pos) {
        for (int i = 0; i < Numeradores.size(); i++) {
            Numeradores.get(i).moverArriba(pos);
        }
    }

    public division() {
        listaMovimientosHaciaDerecha.add((double) 0);
    }

    protected void conseguirNumeradores(Logica l) {
        int contador = 0;
        int movimientosDer = 0;

        coordNumerador = l.context.lista_simbolos.get(l.context.lista_simbolos.size() - 1).Xpos;

        for (int i = l.context.lista_simbolos.size() - 1; i >= 0; i--) {
            if (l.context.lista_simbolos.get(i).valor == 18) {
                contador++;
            } else if (l.context.lista_simbolos.get(i).valor == 17) {
                contador--;
            }
            if (contador == -1) {
                hayParentesis = l.context.lista_simbolos.get(i);
                break;
            } else {
                if (!Numeradores.contains(l.context.lista_simbolos.get(i))) {
                    Numeradores.add(l.context.lista_simbolos.get(i));
                    movimientosDer++;
                }
            }
        }
        movimientosDerecha = movimientosDer;
    }

    protected void centrarNumeradores(Logica l) {
        if (l.pivot_x > coordNumerador && l.context.lista_simbolos.get(l.context.lista_simbolos.size() - 1).valor != 18) {
            if (l.enDivision) {
                for (int i = 0; i < Numeradores.size(); i++) {
                    Numeradores.get(i).moverDerecha(0.5);
                }
                if (lineaDivision) {
                    if (!l.ParentesisAbiertos.isEmpty() && hayParentesis != null) {
                        movimientoLinea.setDimensionLineaDivision(
                            hayParentesis.Xpos, l.pivot_x);
                    } else {
                        movimientoLinea.setDimensionLineaDivision(
                            l.context.lista_simbolos.get(0).Xpos - l.espacioEntreSimbolos, l.pivot_x);
                    }
                }
            }
        }
    }
}

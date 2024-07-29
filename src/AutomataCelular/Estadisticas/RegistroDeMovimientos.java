package AutomataCelular.Estadisticas;

import java.util.ArrayList;
import java.util.List;

/*
Esta clase gestiona el registro de movimientos de los seres vivos dentro de la simulación. También funciona
como un Singleton, asegurando que solo haya una única instancia que recopile los movimientos de los seres vivos.
La clase tiene un lista de movimientos, cada uno asociado con la especie, el ID, el ciclo actual y las posiciones
incial y final del movimiento.
Tambien proporciona métodos para registrar un movimiento y obtener la lista de movimientos.

 */

public class RegistroDeMovimientos {
    private static final List<String> movimientos = new ArrayList<>();
    private static RegistroDeMovimientos registroDeMovimientos;
    private static int cicloActual = 1;

    public static RegistroDeMovimientos getInstancia() {
        if (registroDeMovimientos == null) {
            registroDeMovimientos = new RegistroDeMovimientos();
        }
        return registroDeMovimientos;
    }

    public static void incrementarCiclo() {
        cicloActual++;
    }

    public void registrarMovimiento(String especie, int id, int[] posicionInicial, int[] posicionFinal) {
        movimientos.add("Movimiento; " + especie + ": " + id + "; " + cicloActual
                + "; De [" + posicionInicial[0] + ", " + posicionInicial[1]
                + "]; a [" + posicionFinal[0] + ", " + posicionFinal[1] + "]");
    }
    public static List<String> getMovimientos() {
        return movimientos;
    }
}

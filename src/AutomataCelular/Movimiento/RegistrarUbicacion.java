package AutomataCelular.Movimiento;

import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.UbicacionSeresVivos.Celda;

import java.util.HashMap;
import java.util.Map;
/*
Gestiona la ubicación y posición de los seres vivos en el tablero.
Utiliza dos mapas: uno para asociar cada ser vivo con una celda en específico, y el otro para registrar las
coordenadas de cada ser vivo.
tiene métodos para establecer y obtener la ubicación y posición de un ser vivo.
Esta clase tiene como objetivo facilitar el seguimiento y la actualización de las posiciones de los seres vivos.
 */

public class RegistrarUbicacion {
    private static final Map<SerVivo, Celda> ubicaciones = new HashMap<>();
    private static final Map<SerVivo, int[]> posiciones = new HashMap<>();

    public static void establecerUbicacion(SerVivo serVivo, Celda celda) {
        ubicaciones.put(serVivo, celda);
    }

    public static Celda obtenerUbicacion(SerVivo serVivo) {
        return ubicaciones.get(serVivo);
    }

    public static void establecerPosicion(SerVivo serVivo, int fila, int columna) {
        posiciones.put(serVivo, new int[]{fila, columna});
    }

    public static int[] obtenerPosicion(SerVivo serVivo) {
        return posiciones.getOrDefault(serVivo, new int[]{-1, -1});
    }

}
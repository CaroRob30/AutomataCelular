package AutomataCelular.UbicacionSeresVivos;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;

import java.util.HashMap;
import java.util.Map;

public class RegistrarUbicacion {
    private static final Map<SerVivo, Celda> ubicaciones = new HashMap<>();
    private static final Map<SerVivo, int[]> posiciones = new HashMap<>();

    public static void establecerUbicacion(SerVivo serVivo, Celda celda) {
        ubicaciones.put(serVivo, celda);
    }

    public static Celda obtenerUbicacion(SerVivo serVivo) {
        return ubicaciones.get(serVivo);
    }

    public static void eliminarUbicacion(SerVivo serVivo) {
        ubicaciones.remove(serVivo);
    }

    public static void establecerPosicion(SerVivo serVivo, int fila, int columna) {
        posiciones.put(serVivo, new int[]{fila, columna});
    }

    public static int[] obtenerPosicion(SerVivo serVivo) {
        return posiciones.getOrDefault(serVivo, new int[]{-1, -1});
    }

}
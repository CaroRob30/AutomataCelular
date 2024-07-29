package AutomataCelular.Simulacion;

import AutomataCelular.Estadisticas.RegistroDeSeresVivos;
import AutomataCelular.Estadisticas.RegistroDeEventos;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;
import AutomataCelular.UbicacionSeresVivos.Celda;

import java.util.ArrayList;
import java.util.List;
/*
Esta clase se encarga de actualizar el estado de los seres vivos en el tablero. Para cada celda del tablero,
se verifica cada ser vivo, llamando al método 'pasoDelTiempo' y eliminando aquellos que ya no estén vivos.
Registra las muertes en 'RegistroDeEventos' y en 'RegistroDeSeresVivos', actualizando las estadísticas.
 */

public class ActualizadorDeSeresVivos {
    private final Tablero tablero = Tablero.getInstancia();
    private final RegistroDeEventos registroDeEventos = RegistroDeEventos.getInstancia();

    public void actualizarSeresVivos() {
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int columna = 0; columna < tablero.getColumnas(); columna++) {
                Celda celda = tablero.getCelda(fila, columna);
                List<SerVivo> seresVivosParaEliminar = new ArrayList<>();
                for (SerVivo serVivo : celda.getSeresVivos()) {
                    serVivo.pasoDelTiempo();
                    if (!serVivo.estaVivo()) {
                        seresVivosParaEliminar.add(serVivo);
                        registroDeEventos.registrarMuerte(serVivo.getClass().getSimpleName()
                                , serVivo.getId(), new int[]{fila, columna});
                        RegistroDeSeresVivos.registrarMuerte(serVivo.getClass().getSimpleName());
                    }
                }
                seresVivosParaEliminar.forEach(celda::eliminarSerVivo);
            }
        }
    }
}
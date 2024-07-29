package AutomataCelular.Simulacion;

import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;

import java.util.ArrayList;
import java.util.List;

public class ActualizadorDeEstado {
    private final Tablero tablero = Tablero.getInstancia();

    public void ejecutarActualizacionDeSeresVivos() {
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int columna = 0; columna < tablero.getColumnas(); columna++) {
                List<SerVivo> seresVivos = tablero.getCelda(fila, columna).getSeresVivos();
                actualizarSeresVivos(seresVivos);
            }
        }
    }

    private void actualizarSeresVivos(List<SerVivo> seresVivos) {
        List<SerVivo> seresVivos2 = new ArrayList<>(seresVivos);
        for (SerVivo serVivo : seresVivos2) {
            serVivo.pasoDelTiempo();
            if (!serVivo.estaVivo()) {
                seresVivos.remove(serVivo);
            }
        }
    }
}

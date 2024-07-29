package AutomataCelular.Estadisticas.GeneradorCSV;
import AutomataCelular.Estadisticas.RegistroDeMovimientos;

import java.io.PrintWriter;
import java.util.List;
/*
Esta clase extiende también de la clase abstracta 'GeneradorCSV'.
Sobreescribe los métodos 'getNombreArchivo' y 'escribirContenido' para generar un archivo
CSV con los movimientos registrados.
 */
public class GeneradorDeMovimientosCSV extends GeneradorCSV {

    @Override
    protected String getNombreArchivo() {
        return "registroDeMovimientos.csv";
    }

    @Override
    protected void escribirContenido(PrintWriter contenido) {
        contenido.println("Evento; Especie; ID; Año; De [F, C]; A [F, C]");
        List<String> movimientos = RegistroDeMovimientos.getMovimientos();
        for (String movimiento : movimientos) {
            contenido.println(movimiento);
        }
    }
}
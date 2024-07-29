
import AutomataCelular.Estadisticas.GeneradorCSV.GeneradorDeEventosCSV;
import AutomataCelular.Estadisticas.GeneradorCSV.GeneradorDeMovimientosCSV;
import AutomataCelular.Simulacion.AutomataCelular;
import AutomataCelular.Configuracion;
import AutomataCelular.Tablero;
import AutomataCelular.Utilidades.Descripcion;
/*
La clase principal se encarga de la ejecución de la simulación.
Inicializa la descripción de la simulación, crea instancias de los generadores de CSV que registran
eventos y movimientos, obtiene la instancia del tablero e inicia la simulación a través del automatacelular
con el número especificado de ciclos de la clase Configuración.
 */

public class Main {
    public static void main(String[] args) {
        Descripcion.iniciar();
        GeneradorDeEventosCSV generadorDeEventosCSV = new GeneradorDeEventosCSV();
        GeneradorDeMovimientosCSV generadorDeMovimientosCSV = new GeneradorDeMovimientosCSV();
        Tablero.getInstancia();
        AutomataCelular automata = new AutomataCelular();
        automata.iniciar(Configuracion.CICLOS);
        generadorDeEventosCSV.generarCSV();
        generadorDeMovimientosCSV.generarCSV();
    }
}

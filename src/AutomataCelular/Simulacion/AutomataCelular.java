package AutomataCelular.Simulacion;

import AutomataCelular.Comportamiento.ConvivenciaAnimal;
import AutomataCelular.Movimiento.MovimientoAnimal;
import AutomataCelular.SeresVivos.*;

import AutomataCelular.Tablero;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AutomataCelular {
    private final Tablero tablero = Tablero.getInstancia();
    private final ExecutorService executor;
    private final GeneradorDeSimulacion generadorDeSimulacion;

    public AutomataCelular() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.generadorDeSimulacion = new GeneradorDeSimulacion();
    }

    public void iniciar(int iteraciones) {
        generadorDeSimulacion.iniciar(iteraciones);
    }
}
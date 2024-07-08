package AutomataCelular;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AutomataCelular {
    private final Tablero tablero;
    private ExecutorService executor;

    public AutomataCelular(Tablero tablero) {
        this.tablero = tablero;
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void iniciar(int iteraciones) {
        for (int i = 0; i < iteraciones; i++) {
            ejecutarIteracion();
        }
        executor.shutdown();
    }

    private void ejecutarIteracion() {
        Celda[][] celdas = tablero.getCeldas();
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                final int fila = i;
                final int columna = j;
                executor.submit(() -> {
                    if (tablero.getCeldas()[fila][columna].getSerVivo() != null) {
                        tablero.getCeldas()[fila][columna].getSerVivo().pasoDelTiempo();
                        if (tablero.getCeldas()[fila][columna].getSerVivo() instanceof Animal) {
                            ((Animal) tablero.getCeldas()[fila][columna].getSerVivo()).mover(celdas, fila, columna);
                        }
                    }
                });
            }
        }
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!executor.isTerminated()) {
            executor.shutdownNow();
        }
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
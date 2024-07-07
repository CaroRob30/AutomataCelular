package AutomataCelular;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AutomataCelular {
    private final Tablero tablero;
    private ExecutorService executor;

    public AutomataCelular(Tablero tablero) {
        this.tablero = tablero;
        this.executor = Executors.
                newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void iniciar(int iteraciones) {
        for (int i = 0; i < iteraciones; i++) {
            ejecutarIteracion();
        }
        executor.shutdown();
    }

    private void ejecutarIteracion() {
        Celda[][] celdas = new Celda[tablero.getFilas()][tablero.getColumnas()];
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                final int fila = i;
                final int columna = j;
                executor.submit(() -> {
                    if (tablero.getCeldas()[fila][columna].getSerVivo() != null) {
                        tablero.getCeldas()[fila][columna].getSerVivo().pasoDelTiempo();
                        if (tablero.getCeldas()[fila][columna].getSerVivo() instanceof Animal) {
                            ((Animal) tablero.getCeldas()[fila][columna].getSerVivo())
                                    .mover(tablero.getCeldas(), fila, columna);
                        }
                    }
                });
            }

        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                tablero.getCeldas()[i][j] = celdas[i][j];
                
            }
        }
        if (!executor.isTerminated()) {
            executor.shutdownNow();
        }
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }



}

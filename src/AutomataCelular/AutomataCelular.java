package AutomataCelular;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AutomataCelular {
    private final Tablero tablero;
    private ExecutorService executor;
    private MostrarTablero mostrarTablero;

    public AutomataCelular(Tablero tablero) {
        this.tablero = tablero;
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.mostrarTablero = new MostrarTablero();
    }

    public void iniciar(int iteraciones) {
        for (int i = 1; i < iteraciones; i++) {
            System.out.println("Año: ");
            ejecutarIteracion();
            mostrarTablero.mostrarTablero();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    private void ejecutarIteracion() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                final int fila = i;
                final int columna = j;
                executor.submit(() -> {
                    Celda celda = tablero.getCelda(fila, columna);
                    for (SerVivo serVivo : celda.getSeresVivos()) {

                        if (serVivo instanceof Animal) {
                            ((Animal)serVivo).pasoDelTiempo();
                            if (((Animal) serVivo).estaMuerto()) {
                                celda.eliminarSerVivo(serVivo);
                            }
                            ((Animal) serVivo).mover(tablero.getCeldas(), fila, columna);
                        }
                    }
                });
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }
}
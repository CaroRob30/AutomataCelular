package AutomataCelular;

import AutomataCelular.Estadisticas.RegistroDeSeresVivos;
import AutomataCelular.SeresVivos.*;
import AutomataCelular.Estadisticas.ImpresoraDeEstadisticas;
import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.Movimiento.RegistrarUbicacion;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
La clase 'Tablero' actúa como gestor central del entorno de la simulación. Inicializa y mantiene una serie de
celdas en las cuales se coloca un ser vivo, ya sean plantas o animales.
Utiliza un patron Singleton para garantizar que solo exista una instancia de la clase 'Tablero'.
La clase también se encarga de la inicialización por defecto de los seres vivos en el tablero, utilizando un
ExecutorService para ejecutar las tareas de inicialización de los seres vivos en paralelo.
Tiene métodos para acceder a las celdas del tablero y a sus dimensiones, facilitando la gestión del estado
de la simulación.
 */

public class Tablero {
    private static Tablero tablero;
    private final ImpresoraDeEstadisticas impresoraDeEstadisticas;
    private final int filas;
    private final int columnas;
    private final Celda[][] celdas;
    private final Random random;

    public Tablero() {
        this.filas = Configuracion.FILAS;
        this.columnas = Configuracion.COLUMNAS;
        this.celdas = new Celda[filas][columnas];
        this.random = new Random();
        this.impresoraDeEstadisticas = new ImpresoraDeEstadisticas();

        iniciarTablero();
    }

    public static synchronized Tablero getInstancia() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }

    private void iniciarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = new Celda();
            }
        }
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor.submit(() -> inicializarSeresVivos(Configuracion.PLANTAS_INICIALES, Planta.class));
        executor.submit(() -> inicializarSeresVivos(Configuracion.GATOS_INICIALES, Gato.class));
        executor.submit(() -> inicializarSeresVivos(Configuracion.RATONES_INICIALES, Raton.class));
        executor.submit(() -> inicializarSeresVivos(Configuracion.PERROS_INICIALES, Perro.class));

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private <T extends SerVivo> void inicializarSeresVivos(int cantidad, Class<T> serVivo) {
        int incializados = 0;
        while (incializados < cantidad) {
            int x = random.nextInt(filas);
            int y = random.nextInt(columnas);
            synchronized (this) {
                if (celdas[x][y].getSeresVivos().size() == 0) {
                    try {
                        celdas[x][y].agregarSerVivo(serVivo.getDeclaredConstructor().newInstance());
                        RegistroDeSeresVivos.registrarSeresVivos(serVivo.getSimpleName());
                        incializados++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public Celda[][] getCeldas() {
        return celdas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getFilas() {
        return filas;
    }

    public Celda getCelda(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            return celdas[x][y];
        }
        return null;
    }
}

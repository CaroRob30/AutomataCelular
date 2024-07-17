package AutomataCelular;

import AutomataCelular.SeresVivos.*;
import AutomataCelular.Estadisticas.Estadisticas;
import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.UbicacionSeresVivos.RegistrarUbicacion;

import java.util.Random;

public class Tablero {
    private static Tablero tablero;
    private final Estadisticas estadisticas;
    private final int filas;
    private final int columnas;
    private final Celda[][] celdas;
    private final Random random;

    public Tablero() {
        this.filas = Configuracion.FILAS;
        this.columnas = Configuracion.COLUMNAS;
        this.celdas = new Celda[filas][columnas];
        this.random = new Random();
        this.estadisticas = new Estadisticas();

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
        for (int i = 0; i < Configuracion.PLANTAS_INICIALES; i++) {
            int x = random.nextInt(filas);
            int y = random.nextInt(columnas);
            celdas[x][y].agregarSerVivo(new Planta());
            estadisticas.registrarSeresVivos("Planta");

        }
        for (int i = 0; i < Configuracion.GATOS_INICIALES; i++) {
            int x = random.nextInt(filas);
            int y = random.nextInt(columnas);
            celdas[x][y].agregarSerVivo(new Gato());
            estadisticas.registrarSeresVivos("Gato");
        }
        for (int i = 0; i < Configuracion.PERROS_INICIALES; i++) {
            int x = random.nextInt(filas);
            int y = random.nextInt(columnas);
            celdas[x][y].agregarSerVivo(new Perro());
            estadisticas.registrarSeresVivos("Perro");
        }
        for (int i = 0; i < Configuracion.RATONES_INICIALES; i++) {
            int x = random.nextInt(filas);
            int y = random.nextInt(columnas);
            celdas[x][y].agregarSerVivo(new Raton());
            estadisticas.registrarSeresVivos("Raton");
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

    public static int[] obtenerPosicion(SerVivo serVivo) {
        Celda celdaBuscada = RegistrarUbicacion.obtenerUbicacion(serVivo);
        if (celdaBuscada != null) {
            Celda[][] celdas = Tablero.getInstancia().getCeldas();
            for (int fila = 0; fila < Configuracion.FILAS; fila++) {
                for (int columna = 0; columna < Configuracion.COLUMNAS; columna++) {
                    if (celdas[fila][columna].equals(celdaBuscada)) {
                        return new int[]{fila, columna};
                    }
                }
            }
        }
        return new int[]{-1, -1}; // O considerar lanzar una excepción si es más apropiado
    }
}

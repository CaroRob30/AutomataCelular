package AutomataCelular;

import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    private Celda[][] celdas;
    private Random random;

    public Tablero() {
        this.filas = Configuracion.FILAS;
        this.columnas = Configuracion.COLUMNAS;
        this.celdas = new Celda[filas][columnas];
        this.random = new Random();
        iniciarTablero();
    }

    private void iniciarTablero() {
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                celdas[x][y] = new Celda();
                int aleatorio = random.nextInt(5);
                if (aleatorio == 0) {
                    celdas[x][y].agregarSerVivo(new Planta());
                } else if (aleatorio == 1) {
                    celdas[x][y].agregarSerVivo(new Gato());
                } else if (aleatorio == 2) {
                    celdas[x][y].agregarSerVivo(new Perro());
                } else if (aleatorio == 3) {
                    celdas[x][y].agregarSerVivo(new Raton());
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

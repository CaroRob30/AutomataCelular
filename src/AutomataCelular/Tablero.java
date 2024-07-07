package AutomataCelular;

import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    private Celda[][] celdas;
    private Random random;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Celda[filas][columnas];
        this.random = new Random();
        iniciarTablero();
    }

    private void iniciarTablero() {
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                celdas[x][y] = new Celda();

                int aleatorio = random.nextInt(3); // 0, 1, o 2
                if (aleatorio == 0) {
                    // Celda vacía
                } else if (aleatorio == 1) {
                    celdas[x][y].setSerVivo(new Planta(
                            Configuracion.ENERGIA_INICIAL_PLANTA,
                            Configuracion.ENERGIA_MAXIMA_PLANTA
                    ));
                } else if (aleatorio == 2) {
                    celdas[x][y].setSerVivo(new Gato()); // Ejemplo de animal
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

    public void actualizarTablero() {
        /*falta implementar el estado del tablero con las interacciones
        mover animales, crecer plantas, etc.
         */
        for (int x = 0; x < filas; x++) {
            for (int y = 0; y < columnas; y++) {
                Celda celda = celdas[x][y];
             /*   celda.actualizar(); este metodo deberá estar implementado en la
                clase celda
                        */
            }

        }
    }

    public void agregarSerVivo(SerVivo serVivo, int x, int y) {
        Celda celda = getCelda(x, y);
        if (celda != null) {
            celda.setSerVivo(serVivo);
        }
    }
}

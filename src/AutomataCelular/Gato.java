package AutomataCelular;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gato extends Animal {
    private static final int ENERGIA_REPRODUCTIVA = 3;
    private static final int ENERGIA_INICIAL_CRIA = 2;
    private static final int ENERGIA_COMIDA = 1;

    public Gato() {
        super();
    }

    @Override
    public void mover(Celda[][] tablero, int fila, int columna) {

    }

    private List<int[]> obtenerCeldaVecina(Celda[][] tablero, int x, int y) {
        List<int[]> vecinos = new ArrayList<>();
        int filas = tablero.length;
        int columnas = tablero[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nuevoX = x + dx[i];
            int nuevoY = y + dy[i];

            if (nuevoX >= 0 && nuevoX < filas && nuevoY >= 0 && nuevoY < columnas) {
                vecinos.add(new int[]{nuevoX, nuevoY});
            }
        }

        return vecinos;
    }

    private List<int[]> obtenerCeldasLibres(Celda[][] tablero, int x, int y) {
        List<int[]> celdasLibres = new ArrayList<>();
        List<int[]> vecinos = obtenerCeldaVecina(tablero, x, y);

        for (int[] vecino : vecinos) {
            if (tablero[vecino[0]][vecino[1]].estaVacia()) {
                celdasLibres.add(vecino);
            }
        }

        return celdasLibres;


    }

    @Override
    public void comer() {

    }

    @Override
    public void reproducir() {

    }
}


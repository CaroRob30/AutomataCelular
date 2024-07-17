package AutomataCelular.UbicacionSeresVivos;

import java.util.ArrayList;
import java.util.List;

public class DetectorDeVecinos {

    public static List<int[]> detectarVecinos(int fila, int columna, int filas, int columnas) {
        int[][] vecinos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> posicionDeVecinos = new ArrayList<>();
        for (int[] vecino : vecinos) {
            int nuevaFila = fila + vecino[0];
            int nuevaColumna = columna + vecino[1];
            if (laPosicionEsValida(nuevaFila, nuevaColumna, filas, columnas)) {
                posicionDeVecinos.add(new int[]{nuevaFila, nuevaColumna});
            }
        }
        return posicionDeVecinos;
    }

    private static boolean laPosicionEsValida(int fila, int columna, int filas, int columnas) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }
}

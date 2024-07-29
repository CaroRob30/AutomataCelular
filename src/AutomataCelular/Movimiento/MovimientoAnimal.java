package AutomataCelular.Movimiento;

import AutomataCelular.Estadisticas.RegistroDeMovimientos;
import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.SeresVivos.Animal;

import java.util.List;
import java.util.Random;
/*
La clase 'MovimientoAnimal' se encarga del movimiento de los animales en el tablero. Utiliza la instancia
'RegistroDeMovimientos' para registrar cada movimiento realizado. La funcion 'moverAnimal' recibe un animal
y sus coordenadas actuales en el tablero, y primero verifica que el animal esté presente en su ubicación actual.
Luego, obtiene las posiciones vecinas válidas y selecciona una posición aleatoria para mover al animal.
Si la celda destino puede recibir al animal, se realiza el movimiento y se hace su registro.
La clase utiliza synchronized para asegurar que el movimiento se realice de manera segura y sin interferencias.
 */

public class MovimientoAnimal {
    private final RegistroDeMovimientos registroDeMovimientos;

    public MovimientoAnimal() {
        registroDeMovimientos = RegistroDeMovimientos.getInstancia();
    }

    public synchronized void moverAnimal(Animal animal, Celda[][] tablero, int fila, int columna) {
        Celda celdaActual = RegistrarUbicacion.obtenerUbicacion(animal);
        if (celdaActual == null || !celdaActual.contieneSerVivo(animal)) {
            return;
        }

        List<int[]> posicionesVecinas = DetectorDeVecinos.detectarVecinos(fila, columna, tablero.length, tablero[0].length);
        Random random = new Random();

        while (!posicionesVecinas.isEmpty()) {
            int indiceAleatorio = random.nextInt(posicionesVecinas.size());
            int[] nuevaPosicion = posicionesVecinas.remove(indiceAleatorio);
            int nuevaFila = nuevaPosicion[0];
            int nuevaColumna = nuevaPosicion[1];

            if (nuevaFila >= 0 && nuevaFila < tablero.length && nuevaColumna >= 0 && nuevaColumna < tablero[0].length) {
                Celda celdaDestino = tablero[nuevaFila][nuevaColumna];

                if (celdaDestino.puedeAgregarSerVivo(animal)) {
                    synchronized (this) {
                        if (celdaActual.contieneSerVivo(animal)) {
                            celdaActual.eliminarSerVivo(animal);
                            celdaDestino.agregarSerVivo(animal);
                            RegistrarUbicacion.establecerUbicacion(animal, celdaDestino);
                            RegistrarUbicacion.establecerPosicion(animal, nuevaFila, nuevaColumna);
                        }
                    }
                    registroDeMovimientos.registrarMovimiento(animal.getClass().getSimpleName(), animal.getId(),
                            new int[]{fila, columna}, new int[]{nuevaFila, nuevaColumna});
                } else {

                }
                return;
            }
        }
    }
}
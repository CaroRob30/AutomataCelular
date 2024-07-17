package AutomataCelular.Movimiento;

import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.Comportamiento.ConvivenciaAnimal;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.UbicacionSeresVivos.DetectorDeVecinos;
import AutomataCelular.UbicacionSeresVivos.RegistrarUbicacion;

import java.util.List;
import java.util.Random;

public class MovimientoAnimal {

    public void moverAnimal(Animal animal, Celda[][] tablero, int fila, int columna) {
        List<int[]> posicionesVecinas = DetectorDeVecinos.detectarVecinos(
                fila, columna, tablero.length, tablero[0].length);
        if (!posicionesVecinas.isEmpty()) {
            Random random = new Random();
            int[] nuevaPosicion = posicionesVecinas.get(random.nextInt(posicionesVecinas.size()));
            int nuevaFila = nuevaPosicion[0];
            int nuevaColumna = nuevaPosicion[1];

            Celda celdaDestino = tablero[nuevaFila][nuevaColumna];

            Celda celdaActual = RegistrarUbicacion.obtenerUbicacion(animal);
            if (celdaActual != null) {
                celdaActual.eliminarSerVivo(animal);
            }

            for (SerVivo serVivo : celdaDestino.getSeresVivos()) {
                if (serVivo instanceof Animal) {
                    new ConvivenciaAnimal().encuentro(animal, serVivo);
                }
            }

            celdaDestino.agregarSerVivo(animal);
            RegistrarUbicacion.establecerUbicacion(animal, celdaDestino);
            RegistrarUbicacion.establecerPosicion(animal, nuevaFila, nuevaColumna);
        }
    }
}
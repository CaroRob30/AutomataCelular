package AutomataCelular.Movimiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Esta clase se encarga de gestionar y ejecutar los movimientos de los animales en un tablero de la simulación.
Utiliza un ExecutorService para ejecutar los movimientos de los animales de manera simultanea, asegurando que
los animales se muevan de manera eficiente y sin interferencias.
Recorre el tablero celda por celda, identificando a los animales en cada celda y enviando tareas para mover
cada animal. Para cada animal se utiliza 'MovimientoAnimal' para manejar la lógica de su desplazamiento en
el tablero. Finalmenete el ExecutorService se apaga una vez que se han movido todos los animales.
 */

public class GestorDeMovimiento {
    private final Tablero tablero = Tablero.getInstancia();

    public void ejecutarMovimiento() {
        Set<Animal> animalesMovidos = new HashSet<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            for (int fila = 0; fila < tablero.getFilas(); fila++) {
                for (int columna = 0; columna < tablero.getColumnas(); columna++) {
                    List<SerVivo> seresVivos = new ArrayList<>(tablero.getCelda(fila, columna).getSeresVivos());
                    for (SerVivo serVivo : seresVivos) {
                        if (serVivo instanceof Animal animal && !animalesMovidos.contains(serVivo)) {
                            final int filaOrigen = fila;
                            final int columnaOrigen = columna;
                            executor.submit(() -> moverAnimal(animal, filaOrigen, columnaOrigen));
                            animalesMovidos.add(animal);
                        }
                    }
                }
            }
        } finally {
            executor.shutdown();
        }
    }

    private void moverAnimal(Animal animal, int filaOrigen, int columnaOrigen) {
        MovimientoAnimal movimiento = new MovimientoAnimal();
        movimiento.moverAnimal(animal, tablero.getCeldas(), filaOrigen, columnaOrigen);
    }
}
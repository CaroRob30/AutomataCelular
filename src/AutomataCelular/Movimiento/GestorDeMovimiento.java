package AutomataCelular.Movimiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;

import java.util.ArrayList;
import java.util.List;

public class GestorDeMovimiento {
    private Tablero tablero = Tablero.getInstancia();

    public void ejecutarMovimiento() {
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int columna = 0; columna < tablero.getColumnas(); columna++) {
                List<SerVivo> seresVivos = tablero.getCelda(fila, columna).getSeresVivos();
                moverSeresVivos(seresVivos, fila, columna);
            }
        }
    }

    private void moverSeresVivos(List<SerVivo> seresVivos, int fila, int columna) {
        List<SerVivo> seresVivos2 = new ArrayList<>(seresVivos);
        for (SerVivo serVivo : seresVivos2) {
            if (serVivo instanceof Animal) {
                MovimientoAnimal movimiento = new MovimientoAnimal();
                movimiento.moverAnimal((Animal) serVivo, tablero.getCeldas(), fila, columna);
            }
        }
    }
}

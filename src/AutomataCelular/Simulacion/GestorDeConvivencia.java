package AutomataCelular.Simulacion;

import AutomataCelular.Comportamiento.ConvivenciaAnimal;
import AutomataCelular.Estadisticas.Estadisticas;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;

import java.util.ArrayList;
import java.util.List;

public class GestorDeConvivencia {
    private Tablero tablero;
    private Estadisticas estadisticas;

    public GestorDeConvivencia(Tablero tablero, Estadisticas estadisticas) {
        this.tablero = tablero;
        this.estadisticas = new Estadisticas();
    }

    public void ejecutarConvivencia() {
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int columna = 0; columna < tablero.getColumnas(); columna++) {
                List<SerVivo> seresVivos = tablero.getCelda(fila, columna).getSeresVivos();
                convivirConSeresVivos(seresVivos);
            }
        }
    }

    private void convivirConSeresVivos(List<SerVivo> seresVivos) {
        List<SerVivo> seresVivos2 = new ArrayList<>(seresVivos);
        for (SerVivo serVivo : seresVivos2) {
            if (!(serVivo instanceof Animal)) continue;
            for (SerVivo otroSerVivo : seresVivos) {
                if (otroSerVivo instanceof Animal) continue;
                ConvivenciaAnimal convivencia = new ConvivenciaAnimal();
                convivencia.encuentro((Animal) serVivo, otroSerVivo);
                ;
            }
        }
    }
}


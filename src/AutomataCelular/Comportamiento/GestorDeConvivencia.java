package AutomataCelular.Comportamiento;

import AutomataCelular.Estadisticas.Estadisticas;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
import AutomataCelular.Tablero;

import java.util.List;
/*
La clase 'GestorDeConvivencia', se encarga de gestionar las interacciones entre los seres vivos
en el tablero de la simulación.
Utiliza un objeto 'Tablero' para acceder a las celdas que contienen los seres vivos y un objeto 'Estadisticas'
para registrar la información sobre la simulación. De igual manera, utiliza una instancia de 'ConvivenciaAnimal'
para manejar los encuentros entre los seres vivos. El método 'ejecutarConvivencia' hace un recorrido de todas
las celdas del tablero y, si hay más de un ser vivo en una celda, llama al método 'convivirConSeresVivos' para
gestionar las interacciones entre ellos. Este último método hace una verificación en cada combinación de seres vivos
que estpan en la celda y, si uno de ellos es un animal, llama al método 'encuentro' de 'ConvivenciaAnimal' para
determinar y ejecutar la interacción apropiada a las reglas establecidas en los Patrones de Comportamiento, ya sea
reproducción, alimentación o comunicación, segun el tipo de seres vivos involucrados y el número total
de seres vivos en la celda.
 */

public class GestorDeConvivencia {
    private final Tablero tablero;
    private final Estadisticas estadisticas;
    private final ConvivenciaAnimal convivencia;

    public GestorDeConvivencia(Tablero tablero, Estadisticas estadisticas) {
        this.tablero = tablero;
        this.estadisticas = estadisticas;
        this.convivencia = new ConvivenciaAnimal();
    }

    public void ejecutarConvivencia() {
        for (int fila = 0; fila < tablero.getFilas(); fila++) {
            for (int columna = 0; columna < tablero.getColumnas(); columna++) {
                List<SerVivo> seresVivos = tablero.getCelda(fila, columna).getSeresVivos();
                if (seresVivos.size() > 1) {
                    convivirConSeresVivos(seresVivos);
                }
            }
        }
    }

    private void convivirConSeresVivos(List<SerVivo> seresVivos) {
        int totalSeresEnCelda = seresVivos.size();
        for (SerVivo serVivo : seresVivos) {
            if (serVivo instanceof Animal) {
                for (SerVivo otroSerVivo : seresVivos) {
                    if (!otroSerVivo.equals(serVivo)) {
                        convivencia.encuentro((Animal) serVivo, otroSerVivo, totalSeresEnCelda);
                    }
                }
            }
        }
    }
}

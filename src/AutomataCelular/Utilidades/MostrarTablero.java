package AutomataCelular.Utilidades;

import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.SeresVivos.*;
import AutomataCelular.Tablero;

public class MostrarTablero {

    private final Tablero tablero = Tablero.getInstancia();

    public void mostrarTablero() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Celda celda = tablero.getCelda(i, j);
                if (celda.getSeresVivos().isEmpty()) {
                    System.out.print(" ° ");
                } else {
                    StringBuilder celdaContenido = new StringBuilder("[");
                    int contadorAnimales = 0;
                    for (SerVivo serVivo : celda.getSeresVivos()) {
                        if (serVivo instanceof Gato) {
                            celdaContenido.append("\uD83D\uDC31⚡:").append(serVivo.getEnergia())
                                    .append("\uD83D\uDD6F️:").append(((Gato) serVivo).getEdad()).append(" ");
                        } else if (serVivo instanceof Perro) {
                            celdaContenido.append("\uD83D\uDC36⚡:").append(serVivo.getEnergia())
                                    .append("\uD83D\uDD6F:").append(((Perro) serVivo).getEdad()).append(" ");
                        } else if (serVivo instanceof Raton) {
                            celdaContenido.append("\uD83D\uDC39⚡:").append(serVivo.getEnergia())
                                    .append("\uD83D\uDD6F:").append(((Raton) serVivo).getEdad()).append(" ");
                        } else if (serVivo instanceof Planta) {
                            celdaContenido.append("\uD83C\uDF31⚡:").append(serVivo.getEnergia()).append("\uD83D\uDD6F:0 ");
                        }
                        contadorAnimales++;
                    }
                    celdaContenido.append("]<-").append(contadorAnimales+"|   ");
                    System.out.print(celdaContenido.toString());
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------\n");
    }
}

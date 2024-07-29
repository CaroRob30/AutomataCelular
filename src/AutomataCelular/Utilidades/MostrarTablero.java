package AutomataCelular.Utilidades;

import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.SeresVivos.*;
import AutomataCelular.Tablero;
/*
'MostrarTablero' se encarga de imprimir en la consola el estado actual del tablero.
Utiliza un patrón Singleton para obtener la instancia del tablero y recorre cada celda del mismo.
Si una celda está vacía, imprime un "°". Si la celda contiene seres vivos, construye una cadena con los
detalles de cada ser vivo, su ID, especie, energía y edad(solo para animales), después de contruir la cadena,
imprime esta información en la consola, mostrando el contenido de cada celda y el número de animales en ella.
Esta clase ayuda a visualizar el comportamiento de los seres vivos en el tablero.
 */

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
                            celdaContenido.append("\uD83C\uDD94")
                                    .append(serVivo.getId())
                                    .append("\uD83D\uDC31")
                                    .append("⚡:")
                                    .append(serVivo.getEnergia())
                                    .append("\uD83D\uDD6F️:")
                                    .append(((Gato) serVivo).getEdad())
                                    .append(" ");
                        } else if (serVivo instanceof Perro) {
                            celdaContenido.append("\uD83C\uDD94")
                                    .append(serVivo.getId())
                                    .append("\uD83D\uDC36")
                                    .append("⚡:")
                                    .append(serVivo.getEnergia())
                                    .append("\uD83D\uDD6F:")
                                    .append(((Perro) serVivo).getEdad())
                                    .append(" ");
                        } else if (serVivo instanceof Raton) {
                            celdaContenido.append("\uD83C\uDD94")
                                    .append(serVivo.getId())
                                    .append("\uD83D\uDC39")
                                    .append("⚡:")
                                    .append(serVivo.getEnergia())
                                    .append("\uD83D\uDD6F:")
                                    .append(((Raton) serVivo).getEdad())
                                    .append(" ");
                        } else if (serVivo instanceof Planta) {
                            celdaContenido.append("\uD83C\uDD94" + serVivo.getId() + "\uD83C\uDF31" + "⚡:")
                                    .append(serVivo.getEnergia())
                                    .append(" ");
                        }
                        contadorAnimales++;
                    }
                    celdaContenido.append("]<-").append(contadorAnimales + "|   ");
                    System.out.print(celdaContenido.toString());
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

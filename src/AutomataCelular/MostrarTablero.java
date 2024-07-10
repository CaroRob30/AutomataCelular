package AutomataCelular;

public class MostrarTablero {
    private final Tablero tablero = new Tablero();

    public void mostrarTablero() {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Celda celda = tablero.getCelda(i, j);
                if (celda.estaVacia()) {
                    System.out.print(" ° ");
                } else {
                    boolean hayGato = false;
                    boolean hayPerro = false;
                    boolean hayRaton = false;
                    boolean hayPlanta = false;
                    for (SerVivo serVivo : celda.getSeresVivos()) {
                        if (serVivo instanceof Gato) {
                            System.out.print(((Animal)serVivo).getEdad());
                            hayGato = true;
                        } else if (serVivo instanceof Perro) {
                            hayPerro = true;
                        } else if (serVivo instanceof Raton) {
                            hayRaton = true;
                        } else if (serVivo instanceof Planta) {
                            hayPlanta = true;
                        }
                    }
                    if (hayGato && hayPlanta) {
                        System.out.print("\uD83D\uDC31y\uD83C\uDF31");
                    } else if (hayGato) {
                        System.out.print(" \uD83D\uDC31 ");
                    } else if (hayPerro) {
                        System.out.print(" \uD83D\uDC36 ");
                    } else if (hayRaton) {
                        System.out.print(" \uD83D\uDC39 ");
                    } else if (hayPlanta) {
                        System.out.print(" \uD83C\uDF31 ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}

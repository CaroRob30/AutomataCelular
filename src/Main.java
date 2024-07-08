import AutomataCelular.AutomataCelular;
import AutomataCelular.Configuracion;
import AutomataCelular.Tablero;
import AutomataCelular.Animal;
import AutomataCelular.Planta;
import AutomataCelular.Gato;
import AutomataCelular.Celda;
import AutomataCelular.VisualizacionDelTablero;


public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        AutomataCelular automata = new AutomataCelular(tablero);
        automata.iniciar(Configuracion.ITERACIONES);

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imprimirTablero(tablero);
        }
    }

    private static void imprimirTablero(Tablero tablero) {

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (tablero.getCeldas()[i][j].estaVacia()) {
                    System.out.print("[  ]");
                } else if (tablero.getCeldas()[i][j].getSerVivo() instanceof Planta) {
                    System.out.print("[\uD83C\uDF31]");
                } else if (tablero.getCeldas()[i][j].getSerVivo() instanceof Gato) {
                    System.out.print("[\uD83D\uDC31]");
                }
            }
            System.out.println();

        }

    }
}


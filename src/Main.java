import AutomataCelular.AutomataCelular;
import AutomataCelular.Configuracion;
import AutomataCelular.Tablero;
import AutomataCelular.Animal;
import AutomataCelular.Planta;
import AutomataCelular.Celda;


public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(Configuracion.FILAS, Configuracion.COLUMNAS);
        AutomataCelular automata = new AutomataCelular(tablero);
        automata.iniciar(Configuracion.ITERACIONES);

        // Imprimir estado final del tablero
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Celda celda = tablero.getCeldas()[i][j];
                if (celda == null || celda.estaVacia()) {
                    System.out.print("[]");
                } else if (celda.getSerVivo() instanceof Planta) {
                    System.out.print("P");
                } else if (celda.getSerVivo() instanceof Animal) {
                    System.out.print("A");
                }
            }
            System.out.println();
        }
    }
}

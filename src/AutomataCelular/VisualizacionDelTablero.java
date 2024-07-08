package AutomataCelular;

public class VisualizacionDelTablero{

    public static void VisualizacionDelTablero(Tablero tablero) {
        /* 🐱🐶🐹🏵️🏵️🌱🌳🪴*/
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Celda celda = tablero.getCeldas()[i][j];
                if (celda == null || celda.estaVacia()) {
                    System.out.print("[]");
                } else if (celda.getSerVivo() instanceof Planta) {
                    System.out.print("P");
                } else if (celda.getSerVivo() instanceof Animal) {
                    System.out.print("");
                }
            }
            System.out.println();
        }
    }
}

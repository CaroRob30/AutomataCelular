import AutomataCelular.AutomataCelular;
import AutomataCelular.Configuracion;
import AutomataCelular.Tablero;
import AutomataCelular.Planta;
import AutomataCelular.Gato;


public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        AutomataCelular automata = new AutomataCelular(tablero);
        automata.iniciar(Configuracion.ITERACIONES);
    }
}

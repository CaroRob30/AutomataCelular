import AutomataCelular.Estadisticas.RegistroDeEventos;
import AutomataCelular.Simulacion.AutomataCelular;
import AutomataCelular.Configuracion;
import AutomataCelular.Tablero;


public class Main {
    public static void main(String[] args) {
        Tablero tablero = Tablero.getInstancia();
        AutomataCelular automata = new AutomataCelular();
        automata.iniciar(Configuracion.CICLOS);
        RegistroDeEventos.generarCSV("D:\\Users\\Caro\\Projects IntelliJ\\AutomataCelular\\src\\AutomataCelular\\Registros");
    }
}

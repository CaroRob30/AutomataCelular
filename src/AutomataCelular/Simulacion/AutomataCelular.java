package AutomataCelular.Simulacion;

/*
Esta clase sirve como el controlador principal de la simulación. Inicializa el objeto GeneradorDeSimulacion y
proporciona el método iniciar() para comenzar la simulación y la ejecuta durante un número de iteraciones.
 */
public class AutomataCelular {

    private final GeneradorDeSimulacion generadorDeSimulacion;

    public AutomataCelular() {

        this.generadorDeSimulacion = new GeneradorDeSimulacion();
    }

    public void iniciar(int iteraciones) {
        generadorDeSimulacion.iniciar(iteraciones);
    }
}
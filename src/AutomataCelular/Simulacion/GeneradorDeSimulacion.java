package AutomataCelular.Simulacion;

import AutomataCelular.Estadisticas.Estadisticas;
import AutomataCelular.Movimiento.GestorDeMovimiento;
import AutomataCelular.Tablero;
import AutomataCelular.Utilidades.MostrarTablero;

public class GeneradorDeSimulacion {
    private Tablero tablero = Tablero.getInstancia();
    private ActualizadorDeEstado actualizadorDeEstado;
    private Estadisticas estadisticas;
    private GestorDeMovimiento gestorDeMovimiento;
    private GestorDeConvivencia gestorDeConvivencia;
    private MostrarTablero mostrarTablero;

    public GeneradorDeSimulacion() {
        this.actualizadorDeEstado = new ActualizadorDeEstado();
        this.gestorDeMovimiento = new GestorDeMovimiento();
        this.gestorDeConvivencia = new GestorDeConvivencia(tablero,estadisticas);
        this.estadisticas = new Estadisticas();
        this.mostrarTablero = new MostrarTablero();
    }

    public void iniciar(int iteraciones) {
        for (int i = 0; i <= iteraciones; i++) {
            System.out.println("Año: " + (i + 1));
            estadisticas.actualizarEstadisticas();
            mostrarTablero.mostrarTablero();
            gestorDeMovimiento.ejecutarMovimiento();
            gestorDeConvivencia.ejecutarConvivencia();
            actualizadorDeEstado.ejecutarActualizacionDeSeresVivos();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Interrupción durante la pausa entre iteraciones.");
            }
        }
    }
}

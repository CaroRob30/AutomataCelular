package AutomataCelular.Simulacion;

import AutomataCelular.Comportamiento.GestorDeConvivencia;
import AutomataCelular.Estadisticas.ImpresoraDeEstadisticas;
import AutomataCelular.Estadisticas.RegistroDeEventos;
import AutomataCelular.Estadisticas.RegistroDeMovimientos;
import AutomataCelular.Movimiento.GestorDeMovimiento;
import AutomataCelular.Tablero;
import AutomataCelular.Utilidades.MostrarTablero;
import AutomataCelular.Configuracion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
Esta clase es la encargada de ejecutar la simulación.
Inicializa varios componentes necesarios para la simulacón, como el 'ActualizadorDeSeresVivos',
el 'GestorDeMovimiento', el 'GestorDeConvivencia', el 'ImpresoraDeEstadisticas', el 'MostrarTablero',
el 'RegistroDeEventos' y el 'RegistroDeMovimientos'.
Su método 'iniciar' ejecuta la simulación a lo largo de un número especifico de iteracciones utilizando
un ExecutorService para gestionar las tareas.
Durante cada iteracción, la clase actualiza el tablero, ejecuta el movimiento de los seres vivos,
gestiona la convivencia entre los seres vivos, actualiza los seres vivos, muestra en pantalla el tablero, y,
si está configurado, muestra las estadisticas. Además, se realiza una pausa de 3 segundos entre iteracciones.
 */

public class GeneradorDeSimulacion {
    private final ActualizadorDeSeresVivos actualizadorDeSeresVivos;
    private final GestorDeMovimiento gestorDeMovimiento;
    private final GestorDeConvivencia gestorDeConvivencia;
    private final MostrarTablero mostrarTablero;
    private final RegistroDeEventos registroDeEventos;

    public GeneradorDeSimulacion() {
        Tablero tablero = Tablero.getInstancia();
        this.actualizadorDeSeresVivos = new ActualizadorDeSeresVivos();
        this.gestorDeMovimiento = new GestorDeMovimiento();
        this.gestorDeConvivencia = new GestorDeConvivencia(tablero);
        this.mostrarTablero = new MostrarTablero();
        this.registroDeEventos = RegistroDeEventos.getInstancia();
    }

    public void iniciar(int iteraciones) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i <= iteraciones; i++) {
            final int ciclo = i;
            executor.submit(() -> {
                System.out.println("Año: " + (ciclo + 1));
                registroDeEventos.incrementarCiclo();
                RegistroDeMovimientos.incrementarCiclo();
                mostrarTablero.mostrarTablero();
                gestorDeMovimiento.ejecutarMovimiento();
                gestorDeConvivencia.ejecutarConvivencia();
                actualizadorDeSeresVivos.actualizarSeresVivos();
                if (Configuracion.IMPRIMIR_ESTADISTICAS) {
                    ImpresoraDeEstadisticas.imprimirEstadisticas();
                }
                System.out.println("----------------------------------------------");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Interrupción durante la pausa entre iteraciones.");
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupción mientras esperaba la finalización de las tareas.");
        }
    }
}
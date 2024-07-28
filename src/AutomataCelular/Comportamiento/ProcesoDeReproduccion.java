package AutomataCelular.Comportamiento;

import AutomataCelular.Estadisticas.Estadisticas;
import AutomataCelular.Estadisticas.RegistroDeEventos;
import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.Configuracion;
import AutomataCelular.Movimiento.DetectorDeVecinos;
import AutomataCelular.SeresVivos.*;
import AutomataCelular.Tablero;
import AutomataCelular.Movimiento.RegistrarUbicacion;

import java.util.List;
/*
Esta clase es la encargada de manejar el proceso de reproducción de los animales. Utiliza 'FiltroDeReproduccion'
para verificar si dos seres vivos pueden reproducirse según sus características y condiciones.
 */
public class ProcesoDeReproduccion {
    private final RegistroDeEventos registroDeEventos;
    private final Tablero tablero;
    private final FiltroDeReproduccion filtroDeReproduccion;

    public ProcesoDeReproduccion() {
        tablero = Tablero.getInstancia();
        registroDeEventos = RegistroDeEventos.getInstancia();
        filtroDeReproduccion = new FiltroDeReproduccion();
    }

    public void iniciarReproduccion(Animal animal, SerVivo serVivo) {
        if (filtroDeReproduccion.sePuedenReproducir(animal, serVivo)) {
            String parejaID = filtroDeReproduccion.generarParejaID(animal, serVivo);
            List<int[]> vecinos = DetectorDeVecinos.detectarVecinos(
                    RegistrarUbicacion.obtenerPosicion(animal)[0],
                    RegistrarUbicacion.obtenerPosicion(animal)[1],
                    Configuracion.FILAS,
                    Configuracion.COLUMNAS);
            for (int[] posicion : vecinos) {
                if (huboReproduccion(animal, serVivo, posicion)) {
                    FiltroDeReproduccion.parejasReproducidas.add(parejaID);
                    break;
                }
            }
        }
    }

    private boolean huboReproduccion(Animal animal, SerVivo serVivo, int[] posicion) {
        Celda celdaVecina = tablero.getCelda(posicion[0], posicion[1]);
        if (celdaVecina.estaVacia()) {
            Animal cria = animal.clonar((Animal) serVivo);
            celdaVecina.agregarSerVivo(cria);
            registroDeEventos.registrarNacimiento(serVivo.getClass().getSimpleName(), cria.getId(), posicion);
            Estadisticas.registrarNacimiento(cria.getClass().getSimpleName());
            animal.consumirEnergiaPorReproduccion();
            ((Animal) serVivo).consumirEnergiaPorReproduccion();
            System.out.println("Se reprodujeron: " + animal.getClass().getSimpleName() + " n° " + animal.getId()
                    + " y " + serVivo.getClass().getSimpleName() + " n° " + serVivo.getId());
            return true;
        }
        return false;
    }
}
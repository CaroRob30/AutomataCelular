package AutomataCelular.Comportamiento;

import AutomataCelular.Estadisticas.RegistroDeEventos;
import AutomataCelular.SeresVivos.Crias.Cria;
import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.Configuracion;
import AutomataCelular.UbicacionSeresVivos.DetectorDeVecinos;
import AutomataCelular.SeresVivos.*;
import AutomataCelular.SeresVivos.Crias.GatoCria;
import AutomataCelular.SeresVivos.Crias.PerroCria;
import AutomataCelular.SeresVivos.Crias.RatonCria;
import AutomataCelular.Tablero;
import AutomataCelular.UbicacionSeresVivos.RegistrarUbicacion;

import java.util.List;
import java.util.Optional;

public class PatronDeReproduccion implements IPatronDeComportamiento {
    private RegistroDeEventos registroDeEventos;
    private Tablero tablero;

    public PatronDeReproduccion() {
        tablero = Tablero.getInstancia();
        registroDeEventos = RegistroDeEventos.getInstancia();
    }

    @Override
    public void ejecutar(Animal animal, SerVivo serVivo) {
        if (animal.sonDeLaMismaEspecie(serVivo) && animal.estanEnEdadReproductiva((Animal) serVivo)) {
            List<int[]> vecinos = DetectorDeVecinos.detectarVecinos(
                    Tablero.obtenerPosicion(animal)[0],
                    Tablero.obtenerPosicion(animal)[1],
                    Configuracion.FILAS,
                    Configuracion.COLUMNAS);
            for (int[] posicion : vecinos) {
                Celda celdaVecina = tablero.getCelda(posicion[0], posicion[1]);
                if (celdaVecina.estaVacia()) {
                    Animal cria = animal.clonar((Animal) serVivo);
                    if (cria != null) {
                        celdaVecina.agregarSerVivo(cria);
                        RegistrarUbicacion.establecerUbicacion(cria, celdaVecina);
                        // RegistroDeEventos registroDeEventos = null; // Eliminar esta línea
                        registroDeEventos.registrarNacimiento(serVivo.getClass().getSimpleName(), 1,
                                RegistrarUbicacion.obtenerUbicacion(animal));
                        System.out.println("Se reprodujeron: " + animal.getClass().getSimpleName());
                    }
                    animal.consumirEnergiaPorReproduccion();
                    ((Animal) serVivo).consumirEnergiaPorReproduccion();
                    return;
                }
            }
        }
    }
}
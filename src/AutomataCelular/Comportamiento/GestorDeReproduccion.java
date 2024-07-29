package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
/*
La clase gestiona el proceso de reproducción entre los animales de la simulación. Utiliza dos clases auxiliares:
'FiltroDeReproduccion' y 'ProcesoDeReproduccion' para determinar si los animales pueden reproducirse y registrar.
El método 'sePuedenReproducir' consulta a la clase 'FiltroDeReproduccion' para determinar si los animales cumplen
con las condiciones necesarias para reproducirse. Si es así, llama al método 'registrarReproduccion' para delegar
la tarea de registro y proceso de reproducción al 'ProcesoDeReproduccion'. Además, la clase tiene un método estático
'limpiarParejasReproducidas' que se encarga de limpiar el registro de las parejas que ya se han reproducido.
 */

public class GestorDeReproduccion {
    private final FiltroDeReproduccion filtroDeReproduccion;
    private final ProcesoDeReproduccion procesoDeReproduccion;

    public GestorDeReproduccion() {
        filtroDeReproduccion = new FiltroDeReproduccion();
        procesoDeReproduccion = new ProcesoDeReproduccion();
    }

    public boolean sePuedenReproducir(Animal animal, SerVivo serVivo) {
        return filtroDeReproduccion.sePuedenReproducir(animal, serVivo);
    }

    public void registrarReproduccion(Animal animal, SerVivo serVivo) {
        procesoDeReproduccion.iniciarReproduccion(animal, serVivo);
    }

    public static void limpiarParejasReproducidas() {
        FiltroDeReproduccion.limpiarParejasReproducidas();
    }
}
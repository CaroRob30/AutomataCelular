package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
/*
Esta clase encapula la lógica de la reproducción de los seres vivos en la simulación delegando la lógica a la
clase 'Reproductor' que se encarga de la reproducción de los seres vivos. Lo cual facilita la extensión y
modificación de las reglas de reproducción sin afectar al programa.
 */

public class PatronDeReproduccion implements IPatronDeComportamiento {
    private final Reproductor reproductor;

    public PatronDeReproduccion() {
        reproductor = new Reproductor();
    }

    @Override
    public void iniciar(Animal animal, SerVivo serVivo) {
        reproductor.reproducir(animal, serVivo);
    }
}
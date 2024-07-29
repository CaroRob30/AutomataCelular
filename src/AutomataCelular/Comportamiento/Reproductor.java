package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

/*
Esta clase es la encargada solamente de la lógica de reproducción entre dos animales. Su principal objetivo
es actuar como intermediario para verificar y facilitar el proceso de reproducción.
Se crea una instancia de 'GestorDeReproduccion' para delegar la lógica de reproducción y determinar si dos
seres vivos pueden reproducirse, de ser posible, delega la tarea de registrar la reproducción al
'GestorDeReproduccion'.
 */

public class Reproductor {
    private final GestorDeReproduccion gestorDeReproduccion;

    public Reproductor() {
        gestorDeReproduccion = new GestorDeReproduccion();
    }

    public void reproducir(Animal animal, SerVivo serVivo) {
        if (gestorDeReproduccion.sePuedenReproducir(animal, serVivo)) {
            gestorDeReproduccion.registrarReproduccion(animal, serVivo);
        }
    }
}
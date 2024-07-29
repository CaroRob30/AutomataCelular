package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

import java.util.HashSet;
import java.util.Set;
/*
La clase se encarga de filtrar las parejas que se pueden reproducir, así como el hecho de ser de la misma especie,
estar en edad reproductiva y tener la energía necesaria para reproducirse.
De igual manera, se encarga de llevar un registro de las parejas que ya se han reproducido para evitar que se
reproduzcan nuevamente.
 */

public class FiltroDeReproduccion {
    final static Set<String> parejasReproducidas = new HashSet<>();

    public boolean sePuedenReproducir(Animal animal, SerVivo serVivo) {
        String parejaID = generarParejaID(animal, serVivo);
        return !parejasReproducidas.contains(parejaID) &&
                animal.sonDeLaMismaEspecie(serVivo) &&
                animal.estanEnEdadReproductiva((Animal) serVivo) &&
                animal.tieneEnergiaReproductiva() &&
                ((Animal) serVivo).tieneEnergiaReproductiva();
    }

    String generarParejaID(SerVivo serVivo1, SerVivo serVivo2) {
        long id1 = serVivo1.getId();
        long id2 = serVivo2.getId();
        return id1 < id2 ? id1 + "-" + id2 : id2 + "-" + id1;
    }

    public static void limpiarParejasReproducidas() {
        parejasReproducidas.clear();
    }
}
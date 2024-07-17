package AutomataCelular.UbicacionSeresVivos;

import AutomataCelular.Comportamiento.ConvivenciaAnimal;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    private List<SerVivo> seresVivos;

    public Celda() {
        this.seresVivos = new ArrayList<>();
    }

    public List<SerVivo> getSeresVivos() {
        return new ArrayList<>(seresVivos);
    }

    public void agregarSerVivo(SerVivo serVivo) {
        long cantidadAnimales = seresVivos.stream().filter(serVivo1 -> serVivo1 instanceof Animal).count();
        if (!(serVivo instanceof Animal) || cantidadAnimales < 2) {
            RegistrarUbicacion.establecerUbicacion(serVivo, this);
            seresVivos.add(serVivo);
        }
    }

    public void eliminarSerVivo(SerVivo serVivo) {
        seresVivos.remove(serVivo);
    }

    public boolean estaVacia() {
        return seresVivos.isEmpty();
    }
}
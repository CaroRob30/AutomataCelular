package AutomataCelular.UbicacionSeresVivos;

import AutomataCelular.Movimiento.RegistrarUbicacion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

import java.util.ArrayList;
import java.util.List;
/*
La clase 'Celda' representa una celda en el tablero y maneja los seres vivos que contiene.
Esta clase almacena una lista de seres vivos y proporciona métodos para agregar, eliminar y verificar
la presencia de seres vivos en la celda.
Al agregar un ser vivo, se verifica si ya hay dos animales en la celda, en cuyo caso no se agrega el ser vivo.
Además de tener un control de la ubicación de los seres vivos.
 */
public class Celda {
    private final List<SerVivo> seresVivos;

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

    public boolean contieneSerVivo(Animal animal) {
        for (SerVivo serVivo : seresVivos) {
            if (serVivo instanceof Animal && ((Animal) serVivo).getId() == animal.getId()) {
                return true;
            }
        }
        return false;
    }
    public boolean puedeAgregarSerVivo() {
        long cantidadAnimales = seresVivos.stream().filter(serVivo -> serVivo instanceof Animal).count();
        return cantidadAnimales < 2;
    }
}
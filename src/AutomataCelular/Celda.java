package AutomataCelular;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    private List<SerVivo> seresVivos;

    public Celda() {
        this.seresVivos = new ArrayList<>();
    }

    public List<SerVivo> getSeresVivos() {
        return seresVivos;
    }

    public void agregarSerVivo(SerVivo serVivo) {
        seresVivos.add(serVivo);
    }

    public void eliminarSerVivo(SerVivo serVivo) {
        seresVivos.remove(serVivo);
    }

    public boolean estaVacia() {
        return seresVivos.isEmpty();
    }

}

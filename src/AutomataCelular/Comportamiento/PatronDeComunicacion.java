package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

/*
Esta clase, 'PatronDeComunicacion', implementa la interfaz 'IPatronDeComportamiento' y define el método 'iniciar'
que se encarga de definir cómo los animales interactuán entre sí.
Esta clase simula el costo energético de la comunicación entre los animales.
 */

public class PatronDeComunicacion implements IPatronDeComportamiento {
    @Override
    public void iniciar(Animal animal, SerVivo serVivo) {
        animal.consumirEnergiaPorInteraccion();
        if (serVivo instanceof Animal) {
            ((Animal) serVivo).consumirEnergiaPorInteraccion();
        }
    }
}

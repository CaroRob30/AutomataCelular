package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

public interface IPatronDeComportamiento {
    void ejecutar(Animal animal, SerVivo serVivo);
}

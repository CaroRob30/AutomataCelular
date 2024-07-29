package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

/*
Esta interfaz define el método 'iniciar' que debe ser implementado por cualquier clase que represente un patrón
de comportamiento en la simulación.
Permite la creación de diferentes patrones de comportamiento para los seres vivos, como la reproducción,
alimentación o la comunicación, facilitando la modificación y extensión de las reglas de interacción
entre los seres vivos sin afectar al programa.
 */

public interface IPatronDeComportamiento {
    void iniciar(Animal animal, SerVivo serVivo);
}

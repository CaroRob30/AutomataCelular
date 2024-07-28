package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;

/* Esta interfaz define el método 'encuentro' que se encarga de gestionar las interacciones entre los seres vivos
en la simulación. La implementación de este método se realiza en la clase 'ConvivenciaAnimal' que
implementa esta interfaz. Y con esta interfaz se deja abierta la opción de crear diferentes maneras de convivir
entre los seres vivos.
 */
public interface IConvivencia {
    void encuentro(Animal animal, SerVivo serVivo, int totalSeresEnCelda);
}

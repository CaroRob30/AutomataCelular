package AutomataCelular.Comportamiento;

import AutomataCelular.SeresVivos.*;

/*
La clase 'ConvivenciaAnimal', gestiona las interacciones entre los animales y plantas en la simulación.
Implementa la interfaz 'IConvivencia' y utiliza tres patrones de comportamiento:'PatronDeReproduccion',
'PatronDeAlimentacion' y 'PatronDeComunicacion' para determinar y ejecutar acciones específicas durante
los encuentros entre los seres vivos, según el tipo de ser vivo encontrado y la cantidad total de seres vivos,
la clase decide si los animales deben reproducirse, alimentarse o comunicarse. De igual manera permite que no
haya mas de tres seres vivos en una celda.
 */

public class ConvivenciaAnimal implements IConvivencia {
    private final IPatronDeComportamiento patronDeReproduccion;
    private final IPatronDeComportamiento patronDeAlimentacion;
    private final IPatronDeComportamiento patronDeComunicacion;

    public ConvivenciaAnimal() {
        this.patronDeReproduccion = new PatronDeReproduccion();
        this.patronDeComunicacion = new PatronDeComunicacion();
        this.patronDeAlimentacion = new PatronDeAlimentacion();
    }

    @Override
    public void encuentro(Animal animal, SerVivo serVivo, int totalSeresEnCelda) {
        boolean esMismaEspecie = serVivo instanceof Animal && serVivo.sonDeLaMismaEspecie(animal);
        boolean esPlanta = serVivo instanceof Planta;

        if (totalSeresEnCelda == 2) {
            if (esMismaEspecie) {
                patronDeReproduccion.iniciar(animal, serVivo);
            } else if (esPlanta) {
                patronDeAlimentacion.iniciar(animal, serVivo);
            } else {
                patronDeComunicacion.iniciar(animal, serVivo);
            }
        } else if (totalSeresEnCelda > 2) {
            patronDeComunicacion.iniciar(animal, serVivo);
        }
    }
}
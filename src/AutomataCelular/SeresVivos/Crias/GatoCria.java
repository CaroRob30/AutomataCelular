package AutomataCelular.SeresVivos.Crias;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.Gato;
/*
Esta clase hereda la clase abstracta Cria e implementa el método nacer() para crear una nueva instancia de Gato.
 */

public class GatoCria extends Cria {
    @Override
    public Animal nacer() {
        Animal gatoCria = new Gato();
        gatoCria.setEnergia(Configuracion.ENERGIA_INICIAL_ANIMAL);
        gatoCria.setEdad(0);
        return gatoCria;
    }
}

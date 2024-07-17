package AutomataCelular.SeresVivos.Crias;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.Raton;

public class RatonCria extends Cria {
    @Override
    public Animal nacer() {
        Animal ratonCria = new Raton();
        ratonCria.setEnergia(Configuracion.ENERGIA_INICIAL_ANIMAL);
        ratonCria.setEdad(0);
        return ratonCria;
    }
}

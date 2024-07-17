package AutomataCelular.SeresVivos.Crias;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.Perro;

public class PerroCria extends Cria {
    @Override
    public Animal nacer() {
        Animal perroCria = new Perro();
        perroCria.setEnergia(Configuracion.ENERGIA_INICIAL_ANIMAL);
        perroCria.setEdad(0);
        return perroCria;
    }
}

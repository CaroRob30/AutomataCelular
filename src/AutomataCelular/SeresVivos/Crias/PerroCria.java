package AutomataCelular.SeresVivos.Crias;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.Perro;
/*
'PerroCria' hereda la clase abstracta Cria e implementa el método nacer() para crear una nueva instancia de Perro.
 */

public class PerroCria extends Cria {
    @Override
    public Animal nacer() {
        Animal perroCria = new Perro();
        perroCria.setEnergia(Configuracion.ENERGIA_INICIAL_ANIMAL);
        perroCria.setEdad(0);
        return perroCria;
    }
}

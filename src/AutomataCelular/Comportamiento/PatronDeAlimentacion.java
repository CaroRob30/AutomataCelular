package AutomataCelular.Comportamiento;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.Planta;
import AutomataCelular.SeresVivos.SerVivo;

public class PatronDeAlimentacion implements IPatronDeComportamiento {
    @Override
    public void ejecutar(Animal animal, SerVivo serVivo) {
        if (serVivo instanceof Planta) {
            animal.setEnergia(animal.getEnergia() + Configuracion.ENERGIA_ABSORBIDA_DE_PLANTA);
            serVivo.setEnergia(serVivo.getEnergia() - Configuracion.ENERGIA_ABSORBIDA_DE_PLANTA);
        }
    }
}

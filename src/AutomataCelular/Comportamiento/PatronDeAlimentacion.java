package AutomataCelular.Comportamiento;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Animal;
import AutomataCelular.SeresVivos.SerVivo;
/*
Esta clase implementa la interfaz 'IPatronDeComportamiento' y define el método 'iniciar' que se encarga de
incremetar la energía del animal que se alimenta de la planta y disminuir la energía de la planta, hasta un
máximo de energía permitida para el animal. De igual manera, la energía de la planta disminuye por la cantidad
predeterminada en la configuración de la simulación.

 */
public class PatronDeAlimentacion implements IPatronDeComportamiento {
    @Override
    public void iniciar(Animal animal, SerVivo serVivo) {

            int energiaPotencial = animal.getEnergia() + Configuracion.ENERGIA_CONSUMIDA_DE_LA_PLANTA;

            animal.setEnergia(Math.min(energiaPotencial, Configuracion.ENERGIA_MAX_ANIMAL));

            serVivo.setEnergia(serVivo.getEnergia() - Configuracion.ENERGIA_CONSUMIDA_DE_LA_PLANTA);

            System.out.println("Comio: "  + serVivo.getClass().getSimpleName() + " n°: "+ serVivo.getId());

    }
}

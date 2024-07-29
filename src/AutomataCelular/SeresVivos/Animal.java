package AutomataCelular.SeresVivos;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Crias.GatoCria;
import AutomataCelular.SeresVivos.Crias.PerroCria;
import AutomataCelular.SeresVivos.Crias.RatonCria;
/*
Esta clase abstracta 'Animal' define el comportamiento y las características comunes de todos los animales.
Hereda de la clase 'SerVivo' y agrega  propiedades específicas de los animales como la edad.
Se define la energía inciial y la edad inicial de los animales.
Proporciona métodos para simular el paso del tiempo, verificar si el animal está vivo, gestionar aspectos
relacionados con la reproducción y la interacción con otros animales.
También incluye un método para clonar un animal y crear una nueva cría, simulando la reproducción.
 */
public abstract class Animal extends SerVivo {
    protected int edad;

    public Animal() {
        this.energia = Configuracion.ENERGIA_INICIAL_ANIMAL;
        this.edad = Configuracion.EDAD_INICIAL_ANIMAL;
    }

    public Animal clonar(Animal animal) {
        if (animal instanceof Gato) {
            return new GatoCria().nacer();
        } else if (animal instanceof Perro) {
            return new PerroCria().nacer();
        } else {
            return new RatonCria().nacer();

        }
    }

    @Override
    public void pasoDelTiempo() {
        edad++;
        energia--;
    }

    @Override
    public boolean estaVivo() {
        return edad < Configuracion.EDAD_MAX_ANIMAL && energia > 0;
    }

    public boolean estanEnEdadReproductiva(Animal animal) {
        return animal.getEdad() >= Configuracion.EDAD_PARA_PODER_REPRODUCIRSE
                && this.getEdad() >= Configuracion.EDAD_PARA_PODER_REPRODUCIRSE;
    }

    public boolean tieneEnergiaReproductiva() {
        return this.getEnergia() > Configuracion.ENERGIA_CONSUMIDA_POR_REPRODUCCION;
    }

    public void consumirEnergiaPorReproduccion() {
        this.setEnergia(this.getEnergia() - Configuracion.ENERGIA_CONSUMIDA_POR_REPRODUCCION);
    }

    public void consumirEnergiaPorInteraccion() {
        this.setEnergia(this.getEnergia() - Configuracion.ENERGIA_CONSUMIDA_POR_INTERACTUAR_CON_ANIMALES);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

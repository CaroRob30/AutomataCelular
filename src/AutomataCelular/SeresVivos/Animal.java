package AutomataCelular.SeresVivos;

import AutomataCelular.Configuracion;
import AutomataCelular.SeresVivos.Crias.GatoCria;
import AutomataCelular.SeresVivos.Crias.PerroCria;
import AutomataCelular.SeresVivos.Crias.RatonCria;

public abstract class Animal extends SerVivo {
    protected int energiaComida;
    protected int edad;
    protected int edadMaxima;

    public Animal clonar(Animal animal) {
        if (animal instanceof Gato) {
            return new GatoCria().nacer();
        } else if (animal instanceof Perro) {
            return new PerroCria().nacer();
        } else {
            return new RatonCria().nacer();

        }
    }

    public Animal() {
            this.energia = Configuracion.ENERGIA_INICIAL_ANIMAL;
            this.edad = Configuracion.EDAD_INICIAL_ANIMAL;
            this.edadMaxima = Configuracion.EDAD_MAX_ANIMAL;
            this.energiaComida = Configuracion.ENERGIA_COMIDA;
        }

        @Override
        public void pasoDelTiempo () {
            edad++;
            energia--;
        }


        @Override
        public boolean estaVivo () {
            return edad <= edadMaxima && energia > 0;
        }

        public boolean estanEnEdadReproductiva (Animal animal){
            return animal.getEdad() >= Configuracion.EDAD_REPRODUCTIVA
                    && this.getEdad() >= Configuracion.EDAD_REPRODUCTIVA;
        }
        public boolean tieneEnergiaReproductiva () {
            return this.getEnergia() > Configuracion.ENERGIA_REPRODUCTIVA;
        }
        public void consumirEnergiaPorReproduccion () {
            this.setEnergia(this.getEnergia() - Configuracion.ENERGIA_REPRODUCTIVA);
        }

        public void consumirEnergiaPorInteraccion () {
            this.setEnergia(this.getEnergia() - Configuracion.ENERGIA_INTERACCION_ANIMAL);
        }

        public int getEdad () {
            return edad;
        }

        public void setEdad ( int edad){
            this.edad = edad;
        }

        public int getEdadMaxima () {
            return edadMaxima;
        }
    }

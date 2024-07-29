package AutomataCelular.SeresVivos;

import AutomataCelular.Configuracion;
/*
Esta clase hereda la clase abstracta SerVivo e implementa los métodos pasoDelTiempo(),
sonDeLaMismaEspecie() y estaVivo() para definir el comportamiento de una planta.
 */

public class Planta extends SerVivo {

    public Planta() {
        this.energia = Configuracion.ENERGIA_INICIAL_PLANTA;
    }

    @Override
    public void pasoDelTiempo() {
        if (this.energia < Configuracion.ENERGIA_MAX_PLANTA) {
            this.energia++;
        }
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
        return serVivo instanceof Planta;
    }

    @Override
    public boolean estaVivo() {
        return this.energia > 0;
    }
}

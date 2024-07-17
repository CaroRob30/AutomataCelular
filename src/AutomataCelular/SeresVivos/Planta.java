package AutomataCelular.SeresVivos;

import AutomataCelular.Configuracion;

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

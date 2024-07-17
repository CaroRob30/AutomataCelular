package AutomataCelular.SeresVivos;

import AutomataCelular.SeresVivos.Crias.RatonCria;

public class Raton extends Animal {

    public Raton() {
        super();
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
        return serVivo instanceof Raton;
    }
}

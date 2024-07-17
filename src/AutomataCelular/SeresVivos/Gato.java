package AutomataCelular.SeresVivos;

import AutomataCelular.SeresVivos.Crias.GatoCria;

public class Gato extends Animal {

    public Gato() {
        super();
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
        return serVivo instanceof Gato;
    }
}


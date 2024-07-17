package AutomataCelular.SeresVivos;

import AutomataCelular.SeresVivos.Crias.PerroCria;

public class Perro extends Animal {

    public Perro() {
        super();
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
       return serVivo instanceof Perro;
    }
}

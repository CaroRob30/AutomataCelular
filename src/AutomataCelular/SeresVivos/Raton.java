package AutomataCelular.SeresVivos;
/*
Esta clase  también hereda la clase abstracta Animal y representa a un Raton.
Se incializan los atributos de la clase Animal.
Implementa el método sonDeLaMismaEspecie() para comparar si dos seres vivos son de la misma especie.
 */
public class Raton extends Animal {

    public Raton() {
        super();
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
        return serVivo instanceof Raton;
    }
}

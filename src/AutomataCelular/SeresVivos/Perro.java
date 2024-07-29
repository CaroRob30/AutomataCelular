package AutomataCelular.SeresVivos;
/*
Esta clase hereda la clase abstracta Animal e implementa el método sonDeLaMismaEspecie()
para comparar si dos seres vivos son de la misma especie.
De igual forma se heredan los atributos de la clase Animal y representa a un perro.
 */

public class Perro extends Animal {

    public Perro() {
        super();
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
       return serVivo instanceof Perro;
    }
}

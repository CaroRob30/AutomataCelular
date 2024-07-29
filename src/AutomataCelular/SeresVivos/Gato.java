package AutomataCelular.SeresVivos;
/*
Esta clase extiende de la clase Animal y representa a un gato. Su constructor llama al constructor
de la clase Animal para inicializar los atributos.
Implementa el método sonDeLaMismaEspecie() que devuelve true si el ser vivo pasado como argumento es un gato.
 */

public class Gato extends Animal {

    public Gato() {
        super();
    }

    @Override
    public boolean sonDeLaMismaEspecie(SerVivo serVivo) {
        return serVivo instanceof Gato;
    }
}


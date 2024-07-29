package AutomataCelular.SeresVivos;
/*
La clase abstracta 'SerVivo' define los métodos abstractos que deben de ser implementados pos las clases hijas.
Como es el método 'estaVivo()', 'pasoDelTiempo()' y 'sonDeLaMismaEspecie()'.
De igual manera la clase maneja la energía del ser vivo a través de getters y setters.
También se implemento un identificador unico para
 */

public abstract class SerVivo {
    protected int energia;
    private final int id;
    private static int contador = 1;

    public SerVivo() {
        this.id = contador++;
    }

    public abstract boolean estaVivo();

    public abstract void pasoDelTiempo();

    public abstract boolean sonDeLaMismaEspecie(SerVivo serVivo);

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getId() {
        return id;
    }
}

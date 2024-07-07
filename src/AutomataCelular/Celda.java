package AutomataCelular;

public class Celda {

    private SerVivo serVivo;

    public Celda() {

        this.serVivo = null;
    }

    public SerVivo getSerVivo() {
        return serVivo;
    }

    public void setSerVivo(SerVivo serVivo) {
        this.serVivo = serVivo;
    }

    public boolean estaVacia() {
        return serVivo == null;
    }

}

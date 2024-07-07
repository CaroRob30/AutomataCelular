package AutomataCelular;

public abstract class Animal extends SerVivo {

    protected int edad;
    protected int edadMaxima;

    public Animal(int energiaInicial, int edadMaxima) {
        this.energia = energiaInicial;
        this.edad = 0;
        this.edadMaxima = edadMaxima;
    }

    public abstract void mover(Celda[][] tablero, int fila, int columna);

    @Override
    public void pasoDelTiempo() {
        edad++;
        energia--;
    }

    public abstract void comer();

    public abstract void reproducir();

    public boolean estaMuerto() {
        return energia <= 0 || edad >= edadMaxima;
    }
}

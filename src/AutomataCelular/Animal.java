package AutomataCelular;

public abstract class Animal extends SerVivo {

    protected int edad;
    protected int edadMaxima = Configuracion.EDAD_MAXIMA;

    public Animal() {
        this.energia = Configuracion.ENERGIA_INICIAL;
        this.edad = Configuracion.EDAD_INICIAL;
    }

    public abstract void mover(Celda[][] tablero, int fila, int columna);

    public abstract void comer();

    public abstract void reproducir();

    @Override
    public void pasoDelTiempo() {
        edad++;
        energia--;
    }


    @Override
    public boolean estaMuerto() {
        if (edad <= 0 || edad >= edadMaxima) {
            return true;
        }
        return false;
    }
}

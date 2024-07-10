package AutomataCelular;

public abstract class Animal extends SerVivo {
    protected int energiaReproductiva;
    protected int energiaInicialCria;
    protected int energiaComida;
    protected int edad;
    protected int edadMaxima;
    protected int edadReproductiva;

    public Animal() {
        this.energia = Configuracion.ENERGIA_INICIAL;
        this.edad = Configuracion.EDAD_INICIAL;
        this.edadMaxima = Configuracion.EDAD_MAXIMA;
        this.energiaReproductiva = Configuracion.ENERGIA_REPRODUCTIVA;
        this.edadReproductiva = Configuracion.EDAD_REPRODUCTIVA;
        this.energiaComida = Configuracion.ENERGIA_COMIDA;
    }

    public abstract void mover(Celda[][] tablero, int fila, int columna);

    public abstract void comer();

    public abstract void reproducir();

    @Override
    public void pasoDelTiempo() {
        setEnergia(energia - 1);
        setEdad(edad+1);
    }


    @Override
    public boolean estaMuerto() {
        if (edad <= 0 || edad >= edadMaxima) {
            return true;
        }
        return false;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

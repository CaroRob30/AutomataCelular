package AutomataCelular;

public class Planta extends SerVivo {
    private final int energiaMaxima;

    public Planta(int energiaInicial, int energiaMaxima) {
        this.energia = energiaInicial;
        this.energiaMaxima = energiaMaxima;
    }

    @Override
    public void pasoDelTiempo() {
        if (energia < energiaMaxima) {
            energia++;
        }

    }
}

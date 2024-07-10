package AutomataCelular;

public class Planta extends SerVivo {
    private final int energiaMaxima;

    public Planta() {
        this.energia = Configuracion.ENERGIA_INICIAL;
        this.energiaMaxima = Configuracion.ENERGIA_MAXIMA;


    }

    @Override
    public boolean estaMuerto() {
        if (energia <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public void pasoDelTiempo() {
        if (energia < energiaMaxima) {
            energia++;
            if (energia >= energiaMaxima) {
                energia = energiaMaxima;

            }
        } else if (energia <= 0) {
            morir();
        }
    }

    public void morir() {
        energia = 0;
    }
}

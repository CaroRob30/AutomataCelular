package AutomataCelular;

public class Planta extends SerVivo {

    public Planta() {
        this.energia = Configuracion.ENERGIA_INICIAL;

    }

    @Override
    public void pasoDelTiempo() {
        if (energia < Configuracion.ENERGIA_MAXIMA) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            energia++;
        } else if (energia == Configuracion.ENERGIA_MAXIMA) {
        //lo se que deberia hacer es que si se llega a energia máxima, entonces la Planta muere y la celda queda null
        }

    }
}

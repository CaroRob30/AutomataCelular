package AutomataCelular;


public abstract class SerVivo {
    protected int energia;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public abstract boolean estaMuerto();


    public abstract void pasoDelTiempo();
}

package AutomataCelular.SeresVivos;


public abstract class SerVivo {
    protected int energia;

    public abstract boolean estaVivo();
    public abstract void pasoDelTiempo();
    public abstract boolean sonDeLaMismaEspecie(SerVivo serVivo);

    public int getEnergia() {
        return energia;
    }
    public void setEnergia(int energia) {
        this.energia = energia;
    }
}

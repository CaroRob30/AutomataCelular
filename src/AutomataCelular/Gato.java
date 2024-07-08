package AutomataCelular;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gato extends Animal {
    private static final int ENERGIA_REPRODUCTIVA = 3;
    private static final int ENERGIA_INICIAL_CRIA = 2;
    private static final int ENERGIA_COMIDA = 1;

    public Gato() {
        super();
    }

    @Override
    public void mover(Celda[][] tablero, int fila, int columna) {
        List<int[]> vecinos = obtenerCeldaVecina(tablero, fila, columna);
        if (vecinos.isEmpty()) return;

        Random random = new Random();
        int[] destino = vecinos.get(random.nextInt(vecinos.size()));
        int dx = destino[0];
        int dy = destino[1];
        Celda celdaDestino = tablero[dx][dy];
        this.energia--;
        if (celdaDestino.estaVacia()) {
            // Si la celda está vacía, simplemente se mueve
            tablero[dx][dy].setSerVivo(this);
            tablero[fila][columna].setSerVivo(null);
        } else {
            SerVivo serVivoDestino = celdaDestino.getSerVivo();

            if (serVivoDestino instanceof Planta) {
                // Si se mueve hacia una planta, comer la planta
                Planta planta = (Planta) serVivoDestino;
                int energiaComida = Math.min(ENERGIA_COMIDA, planta.getEnergia());
                this.energia += energiaComida;
                planta.setEnergia(planta.getEnergia() - energiaComida);

                // Mover el gato a la celda
                tablero[dx][dy].setSerVivo(this);
                tablero[fila][columna].setSerVivo(null);

                if (planta.getEnergia() <= 0) {
                    tablero[dx][dy].setSerVivo(null);
                }

            } else if (serVivoDestino instanceof Gato) {
                // Si se mueve hacia otro gato, intentar reproducirse
                Gato otroGato = (Gato) serVivoDestino;
                if (this.energia >= ENERGIA_REPRODUCTIVA && otroGato.getEnergia() >= ENERGIA_REPRODUCTIVA) {
                    List<int[]> celdasLibres = obtenerCeldasLibres(tablero, dx, dy);
                    if (!celdasLibres.isEmpty()) {
                        int[] celdaCria = celdasLibres.get(random.nextInt(celdasLibres.size()));
                        tablero[celdaCria[0]][celdaCria[1]].setSerVivo(new Gato());
                        this.energia -= ENERGIA_REPRODUCTIVA;
                        otroGato.setEnergia(otroGato.getEnergia() - ENERGIA_REPRODUCTIVA);
                    }
                }

                // Mover el gato a la celda
                tablero[dx][dy].setSerVivo(this);
                tablero[fila][columna].setSerVivo(null);

            } else if (serVivoDestino instanceof Raton) {
                // Si se mueve hacia un ratón, comer el ratón
                this.energia += serVivoDestino.getEnergia();
                tablero[dx][dy].setSerVivo(this);
                tablero[fila][columna].setSerVivo(null);

            } else if (serVivoDestino instanceof Perro) {
                // Si se mueve hacia un perro, el perro obtiene la energía del gato
                Perro perro = (Perro) serVivoDestino;
                perro.setEnergia(perro.getEnergia() + this.energia);
                this.energia = 0;
            }
        }
    }

    private List<int[]> obtenerCeldaVecina(Celda[][] tablero, int x, int y) {
        List<int[]> vecinos = new ArrayList<>();
        int filas = tablero.length;
        int columnas = tablero[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nuevoX = x + dx[i];
            int nuevoY = y + dy[i];

            if (nuevoX >= 0 && nuevoX < filas && nuevoY >= 0 && nuevoY < columnas) {
                vecinos.add(new int[]{nuevoX, nuevoY});
            }
        }

        return vecinos;
    }

    private List<int[]> obtenerCeldasLibres(Celda[][] tablero, int x, int y) {
        List<int[]> celdasLibres = new ArrayList<>();
        List<int[]> vecinos = obtenerCeldaVecina(tablero, x, y);

        for (int[] vecino : vecinos) {
            if (tablero[vecino[0]][vecino[1]].estaVacia()) {
                celdasLibres.add(vecino);
            }
        }

        return celdasLibres;


    }

    @Override
    public void comer() {

    }

    @Override
    public void reproducir() {

    }
}


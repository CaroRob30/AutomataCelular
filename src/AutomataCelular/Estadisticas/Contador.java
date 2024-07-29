package AutomataCelular.Estadisticas;

import java.util.HashMap;
import java.util.Map;

/*
La clase 'Contador' se encarga de gestionar el conteo de seres vivos en la simulación utilizando un HashMap.
Tiene métodos para incrementar y decrementar el contador de seres vivos, además de un método para obtener
el conteo actual de seres vivos.
 */
public class Contador {
    private static final Map<String, Integer> contadorDeSeresVivos = new HashMap<>();

    public static Map<String, Integer> getContadorDeSeresVivos() {
        return contadorDeSeresVivos;
    }

    public static void incrementarContador(String especie) {
        contadorDeSeresVivos.put(especie, contadorDeSeresVivos.getOrDefault(especie, 0) + 1);
    }

    public static void decrementarContador(String especie) {
        contadorDeSeresVivos.put(especie, contadorDeSeresVivos.getOrDefault(especie, 0) - 1);
        if (contadorDeSeresVivos.get(especie) <= 0) {
            contadorDeSeresVivos.remove(especie);
        }
    }

    public static void actualizarContador(String especie, boolean incrementar) {
        if (incrementar) {
            incrementarContador(especie);
        } else {
            decrementarContador(especie);
        }
    }
}
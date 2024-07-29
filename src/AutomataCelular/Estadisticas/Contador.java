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

    public static void actualizarContador(String especie, boolean incrementar) {
        Integer contador = contadorDeSeresVivos.get(especie);
        if (contador == null) {
            contador = 0;
        }
        contadorDeSeresVivos.put(especie, incrementar ? ++contador : --contador);
    }

    public static Map<String, Integer> getContadorDeSeresVivos() {
        return contadorDeSeresVivos;
    }
}
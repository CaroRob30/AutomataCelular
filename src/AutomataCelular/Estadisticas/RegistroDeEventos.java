package AutomataCelular.Estadisticas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
La clase 'RegistroDeEventos' actúa como un Singleton que gestiona y almacena los eventos durante la simulación,
como los nacimientos o muertes de los seres vivos. Contiene una lista de registros de eventos y un mapa que
organiza los eventos por ciclo. La variable 'cicloActual' se incrementa con cada llamada al método
'incrementarCiclo', que también actualiza las estadísticas del ciclo y limpia los IDs de muertes registradas.
La clase se asegura de que los eventos se registren una única vez por ID mediante un conjunto para evitar
duplicados.
También los métodos para recuperar los registros y eventos por ciclo, son utilizados para generar un archivo CSV.

 */

public class RegistroDeEventos {
    private static final List<String> registros = new ArrayList<>();
    private static final Map<Integer, List<String>> eventosPorCiclo = new HashMap<>();
    private static final Set<Integer> idsRegistradosMuerte = new HashSet<>();
    private static RegistroDeEventos registroDeEventos;
    private static int cicloActual = 0;

    public static RegistroDeEventos getInstancia() {
        if (registroDeEventos == null) {
            registroDeEventos = new RegistroDeEventos();
        }
        return registroDeEventos;
    }

    public void incrementarCiclo() {
        cicloActual++;
        RegistroDeEstadisticas.getRegistroDeEstadisticas().registrarEstadisticas(cicloActual, registros);
        idsRegistradosMuerte.clear();
    }

    public void registrarNacimiento(String especie, int id, int[] posicion) {
        String evento = "Nacimiento; " + especie + " n° " + id + "; " + cicloActual
                + "; [" + posicion[0] + "; " + posicion[1] + "]";
        eventosPorCiclo.computeIfAbsent(cicloActual, k -> new ArrayList<>()).add(evento);
    }

    public void registrarMuerte(String especie, int id, int[] posicion) {
        if (!idsRegistradosMuerte.contains(id)) {
            String evento = "Muerte; " + especie + " n° " + id + "; "
                    + cicloActual + "; [" + posicion[0] + "; " + posicion[1] + "]";
            eventosPorCiclo.computeIfAbsent(cicloActual, k -> new ArrayList<>()).add(evento);
            idsRegistradosMuerte.add(id);
        }
    }

    public static List<String> getRegistros() {
        return registros;
    }

    public static Map<Integer, List<String>> getEventosPorCiclo() {
        return eventosPorCiclo;
    }

}
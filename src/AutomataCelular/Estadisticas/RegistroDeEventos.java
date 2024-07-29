package AutomataCelular.Estadisticas;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        idsRegistradosMuerte.clear(); // Limpiar los IDs registrados al inicio de cada ciclo
    }

    public void registrarNacimiento(String especie, int id, int[] posicion) {
        String evento = "Nacimiento; " + especie + ": " + id + "; " + cicloActual + "; [" + posicion[0] + "; " + posicion[1] + "]";
        eventosPorCiclo.computeIfAbsent(cicloActual, k -> new ArrayList<>()).add(evento);
    }

    public void registrarMuerte(String especie, int id, int[] posicion) {
        if (!idsRegistradosMuerte.contains(id)) { // Verificar si el ID ya fue registrado
            String evento = "Muerte; " + especie + ": " + id + "; " + cicloActual + "; [" + posicion[0] + "; " + posicion[1] + "]";
            eventosPorCiclo.computeIfAbsent(cicloActual, k -> new ArrayList<>()).add(evento);
            idsRegistradosMuerte.add(id); // Añadir el ID al conjunto para evitar duplicados
        }
    }

    public static List<String> getRegistros() {
        return registros;
    }

    public static Map<Integer, List<String>> getEventosPorCiclo() {
        return eventosPorCiclo;
    }

}
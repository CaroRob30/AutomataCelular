package AutomataCelular.Estadisticas;

import java.util.List;
/*
Esta clase, mediante un Singleton, se encarga de registrar las estadísticas de la simulación en una lista.
Tiene el método 'registrarEstadisticas' que recibe el ciclo actual y la lista de registros y agrega
las estadísticas de la simulación a la lista.
 */

public class RegistroDeEstadisticas {
    private static RegistroDeEstadisticas registroDeEstadisticas;

    public static RegistroDeEstadisticas getRegistroDeEstadisticas() {
        if (registroDeEstadisticas == null) {
            registroDeEstadisticas = new RegistroDeEstadisticas();
        }
        return registroDeEstadisticas;
    }
    public void registrarEstadisticas(int cicloActual, List<String> registros) {
        int totalPlantas = ContadorDeSeresVivos.getTotalEspecie("Planta");
        int totalNacimientos = RegistroDeSeresVivos.getTotalDeSeresNacidos();
        int totalMuertes = RegistroDeSeresVivos.getTotalDeSeresMuertos();
        int totalAnimales = ContadorDeSeresVivos.getTotalDeSeresVivos() - totalPlantas;

        String estadisticas = cicloActual + ";" + totalAnimales + ";" + totalPlantas + ";"
                + totalNacimientos + ";" + totalMuertes + ";";
        registros.add(estadisticas);
    }
}

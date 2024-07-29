package AutomataCelular.Estadisticas;

/*
Esta clase lleva un registro de los seres vivos, muertos y nacidos en la simulación. Mantiene contadores
estáticos para el número total de seres vivos, muertos y nacidos. También tiene métodos para registrar
seres vivos, nacimientos y muertes, que actualizan estos contadores.
De igual manera, proporciona métodos para obtener el total de seres vivos, muertos y nacidos, permitiendo
un seguimiento de la población de seres vivos en la simulación.
 */

public class RegistroDeSeresVivos {
    private static int totalDeSeresVivos;
    private static int totalDeSeresMuertos;
    private static int totalDeSeresNacidos;

    public static void registrarSeresVivos(String especie) {
        Contador.actualizarContador(especie, true);
        totalDeSeresVivos++;
    }

    public static void registrarNacimiento(String especie) {
        Contador.actualizarContador(especie, true);
        Contador.actualizarContador(especie + "Nacidos", true);
        totalDeSeresVivos++;
        totalDeSeresNacidos++;
    }

    public static void registrarMuerte(String especie) {
        Contador.actualizarContador(especie + "Muerte", true);
        totalDeSeresMuertos++;
        totalDeSeresVivos--;
        Contador.actualizarContador(especie, false);
    }

    public static int getTotalDeSeresVivos() {
        return totalDeSeresVivos;
    }

    public static int getTotalDeSeresMuertos() {
        return totalDeSeresMuertos;
    }

    public static int getTotalDeSeresNacidos() {
        return totalDeSeresNacidos;
    }
}
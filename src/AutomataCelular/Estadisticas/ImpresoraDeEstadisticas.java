package AutomataCelular.Estadisticas;
/*
Esta clase, en caso de estar activa su funcionalidad en la clase Configuración, se encarga de imprimir
las estadísticas de la simulación al final de cada ciclo.
 */

public class ImpresoraDeEstadisticas {
    public static void imprimirEstadisticas() {
        System.out.println("Estadísticas al final del ciclo:");
        System.out.println("Total de Seres Vivos: " + RegistroDeSeresVivos.getTotalDeSeresVivos());
        System.out.println("Total de Nacimientos: " + RegistroDeSeresVivos.getTotalDeSeresNacidos());
        System.out.println("Total de Muertes: " + RegistroDeSeresVivos.getTotalDeSeresMuertos());
        Contador.getContadorDeSeresVivos().forEach((especie, contador)
                -> System.out.println("Total de " + especie + ": " + contador));
    }
}
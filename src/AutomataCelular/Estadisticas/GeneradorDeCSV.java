package AutomataCelular.Estadisticas;

import AutomataCelular.Configuracion;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
/*
La clase 'GeneradorDeCSV' es la encargada de crear archivos CSV para registrar los eventos y movimientos de la
simulación. El método 'generarEventosCSV' crea un archivo CSV con los eventos registrados en 'RegistroDeEventos'.
El método 'generarMovimientosCSV' crea un archivo CSV con los movimientos registrados en 'RegistroDeMovimientos'.
 */

public class GeneradorDeCSV {

    public static void generarEventosCSV() {
        String rutaArchivo = Configuracion.RUTA_DE_ARCHIVO;
        try (PrintWriter writer = new PrintWriter(rutaArchivo + "\\registroDeEventos.csv")) {
            writer.println("Tiempo; Animales; Plantas; Nacimientos; Muertes; Evento; Especie; ID; Ciclo; Fila; Columna");
            List<String> registros = RegistroDeEventos.getRegistros();
            Map<Integer, List<String>> eventosPorCiclo = RegistroDeEventos.getEventosPorCiclo();

            for (String registro : registros) {
                String[] partes = registro.split(";");
                int ciclo = Integer.parseInt(partes[0].trim());
                StringBuilder linea = new StringBuilder(registro);
                List<String> eventos = eventosPorCiclo.get(ciclo);
                if (eventos != null) {
                    for (String evento : eventos) {
                        linea.append(" // ").append(evento);
                    }
                }
                writer.println(linea.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generarMovimientosCSV() {
        String rutaArchivo = Configuracion.RUTA_DE_ARCHIVO;
        try (PrintWriter writer = new PrintWriter(rutaArchivo + "\\registroDeMovimientos.csv")) {
            writer.println("Evento; Especie; ID; Año; De [F, C]; A [F, C]");
            List<String> movimientos = RegistroDeMovimientos.getMovimientos();
            for (String movimiento : movimientos) {
                writer.println(movimiento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



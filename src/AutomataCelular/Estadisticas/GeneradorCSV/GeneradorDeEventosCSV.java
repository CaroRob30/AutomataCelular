package AutomataCelular.Estadisticas.GeneradorCSV;

import AutomataCelular.Estadisticas.RegistroDeEventos;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
/*
'GeneradorDeEventosCSV' extiende de la clase abstracta 'GeneradorCSV' y se encarga de generar un
archivo CSV que registra eventos de la simulación. El método 'getNombreArchivo' retorna el nombre del archivo.
Y el método 'escribirContenido' escribe el contenido del archivo CSV con los eventos registrados
en 'RegistroDeEventos'.
 */
public class GeneradorDeEventosCSV extends GeneradorCSV {

    @Override
    protected String getNombreArchivo() {
        return "registroDeEventos.csv";
    }

    @Override
    protected void escribirContenido(PrintWriter contenido) {
        contenido.println("Tiempo; Animales; Plantas; Nacimientos; " +
                "Muertes; Evento; Especie; ID; Ciclo; Fila; Columna");
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
            contenido.println(linea);
        }
    }
}
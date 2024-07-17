package AutomataCelular.Estadisticas;

import AutomataCelular.UbicacionSeresVivos.Celda;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RegistroDeEventos {
    private static final List<String> registros = new ArrayList<>();
    private static RegistroDeEventos registroDeEventos;

    public static RegistroDeEventos getInstancia() {
        if (registroDeEventos == null) {
            registroDeEventos = new RegistroDeEventos();
        }
        return registroDeEventos;
    }

    public void registrarNacimiento(String tipo, int ciclo, Celda celda) {
        registros.add("Registro de nacimiento: " + tipo
                + "; Año:  " + ciclo + "; [" + celda.toString() + "]");
    }

    public void registrarMuerte(String tipo, int ciclo, Celda celda) {
        registros.add("Registro de muerte: " + tipo
                + "; Año:  " + ciclo + "; [" + celda.toString() + "]");
    }

    public static void generarCSV(String rutaArchivo) {
        rutaArchivo = "D:\\Users\\Caro\\Projects IntelliJ\\AutomataCelular\\src\\AutomataCelular\\Registros";
        try (PrintWriter writer = new PrintWriter(rutaArchivo + "\\registroDeEventos.csv")) {
            writer.println("Evento;Tipo;Ciclo;Fila;Columna");
            for (String registro : registros) {
                writer.println(registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

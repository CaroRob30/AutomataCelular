package AutomataCelular.Estadisticas.GeneradorCSV;

import AutomataCelular.Configuracion;

import java.io.PrintWriter;
/*
La clase abstracta se facilita la generación de archivos CSV con información proporcionada.
Define dos métodos abstractos que deben ser implementados por las clases que hereden de esta.
El método 'getNombreArchivo' debe retornar el nombre del archivo CSV que se desea generar.
El método 'escribirContenido' debe escribir el contenido del archivo CSV.
El método 'generarCSV' se encarga de crear el archivo CSV en la ruta especificada en 'Configuracion'.
 */

public abstract class GeneradorCSV {

    protected abstract String getNombreArchivo();

    protected abstract void escribirContenido(PrintWriter contenido);

    public void generarCSV() {
        String rutaArchivo = Configuracion.RUTA_DE_ARCHIVO;
        try (PrintWriter writer = new PrintWriter(rutaArchivo + "\\" + getNombreArchivo())) {
            escribirContenido(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



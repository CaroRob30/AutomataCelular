package AutomataCelular.Utilidades;
/*
Esta clase muestra una descripción de la simulación al usuario. Dando un tiempo de
10 segundos para que el usuario pueda leer la descripción.
 */

public class Descripcion {

    public static void iniciar() {
        System.out.println("¡Bienvenido, humano!\n" +
                "Estas iniciando la simulación de un ecosistema con seres vivos.\n" +
                "En este ecosistema, existen cuatro tipos de seres vivos:\n" +
                "Plantas, Gatos, Perros y Ratones.\n" +
                "Cada ser vivo tiene una cantidad de energía y una edad.\n" +
                "No olvides ir a la clase Configuración para seleccionar:\n" +
                "La cantidad de seres vivos\n" +
                "Los valores de los seres vivos\n" +
                "Y la cantidad de iteraciones de la simulación.\n" +
                "¡Que comience la simulación!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

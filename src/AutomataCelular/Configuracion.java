package AutomataCelular;
/*
Esta clase establece parámetros estáticos para configurar una simulación de autómata celular.
Se debe definir la ruta del archivo para guardar los registros de cada ciclo de la simulación,
se establecen las dimensiones del tablero (filas y columnas) y la cantidad de ciclos de simulación.
Además, se especifica el número inicial de los diferentes tipos de seres vivos ya sean plantas o animales.
De igual forma hay parámetros para establecer las características de los seres vivos, como en las plantas es
su energia inicial y máxima. En cuanto a los animales se le agregan más parámetros como la edad inicial, máxima,
edad reproductiva, la energía necesaria para reproducirse, la cantidad de energia que absorben de las plantas
y la energía utilizada en interacciones entre animales.
 */

public class Configuracion {
    /*Inserte la ruta del archivo para guardar los registros.
     Se creó una carpeta llamada 'Registros' en el proyecto para guardar los archivos generados.
    Solamenete es una sugerencia de guardado, se puede cambiar la ruta según la necesidad del usuario.
     */
    public static final String RUTA_DE_ARCHIVO =
            "D:\\Users\\Caro\\Projects IntelliJ\\AutomataCelular\\src\\AutomataCelular\\Registros";

    //Configuración del tablero (Filas, Columnas y Ciclos)
    public static final int FILAS = 5;
    public static final int COLUMNAS = 5;
    public static final int CICLOS = 10;

    //Configuración de los seres vivos iniciales
    public static final int PLANTAS_INICIALES = 5;
    public static final int PERROS_INICIALES = 5;
    public static final int GATOS_INICIALES = 0;
    public static final int RATONES_INICIALES = 0;

    //Configuración de las Plantas
    public static final int ENERGIA_INICIAL_PLANTA = 10;
    public static final int ENERGIA_MAX_PLANTA = 15;
    public static final int ENERGIA_CONSUMIDA_DE_LA_PLANTA = 5;

    //Configuración inicial de los Animales
    public static final int EDAD_INICIAL_ANIMAL = 0;
    public static final int ENERGIA_INICIAL_ANIMAL = 10;
    public static final int EDAD_MAX_ANIMAL = 10;
    public static final int ENERGIA_MAX_ANIMAL = 15;

    //Configuracion adicional de los animales
    public static final int EDAD_PARA_PODER_REPRODUCIRSE = 4;
    public static final int ENERGIA_CONSUMIDA_POR_REPRODUCCION = 3;
    public static final int ENERGIA_CONSUMIDA_POR_INTERACTUAR_CON_ANIMALES = 2;

}

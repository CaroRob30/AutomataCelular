package AutomataCelular.Estadisticas;
/*
Esta clase se encarga de calcular y devolver el total de seres vivos de una especie en específico
y el total de seres vivos en la simulación.
'getTotalEspecie' devuelve el total de seres vivos de una especie en específico.
'getTotalDeSeresVivos' devuelve el total de seres vivos en la simulación.
 */
public class ContadorDeSeresVivos {
    public static int getTotalEspecie(String especie) {
        return Contador.getContadorDeSeresVivos().getOrDefault(especie, 0);
    }
}
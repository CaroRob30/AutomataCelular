package AutomataCelular.Estadisticas;

public class Estadisticas {
    private static int totalDeSeresVivos;
    private static int totalDePerros;
    private static int totalDeGatos;
    private static int totalDeRatones;
    private static int totalDePlantas;
    private static int totalDeSeresMuertos;
    private static int totalDeGatosMuertos;
    private static int totalDePerrosMuertos;
    private static int totalDeRatonesMuertos;
    private static int totalDePlantasMuertas;
    private static int totalDeSeresNacidos;
    private static int totalDeGatosNacidos;
    private static int totalDePerrosNacidos;
    private static int totalDeRatonesNacidos;

    public void actualizarEstadisticas() {
        System.out.println( "Seres aún vivos: " + getTotalDeSeresVivos()
                + "\nGatos: " + getTotalDeGatos() + " Perros: " + getTotalDePerros()
                + " Ratones: " + getTotalDeRatones() + " Plantas: " + getTotalDePlantas()
                + "\nSeres muertos: " + getTotalDeSeresMuertos() + "\nGatos: " + getTotalDeGatosMuertos()
                + " Perros: " + getTotalDePerrosMuertos() + " Ratones: " + getTotalDeRatonesMuertos()
                + " Plantas: " + getTotalDePlantasMuertas() + "\nSeres nacidos: " + getTotalDeSeresNacidos()
                + "\nGatos: " + getTotalDeGatosNacidos() + " Perros: " + getTotalDePerrosNacidos()
                + " Ratones: " + getTotalDeRatonesNacidos() + "");
    }


    public void registrarSeresVivos(String tipo) {
        incrementarContadorSeresVivos(tipo);
    }
    private void incrementarContadorSeresVivos(String tipo) {
        switch (tipo) {
            case "Gato":
                totalDeGatos++;
                break;
            case "Perro":
                totalDePerros++;
                break;
            case "Raton":
                totalDeRatones++;
                break;
            case "Planta":
                totalDePlantas++;
                break;
        }
        totalDeSeresVivos++;
    }

    private void incrementarContadorNacidos(String tipo) {
        switch (tipo) {
            case "Gato":
                totalDeGatosNacidos++;
                break;
            case "Perro":
                totalDePerrosNacidos++;
                break;
            case "Raton":
                totalDeRatonesNacidos++;
                break;
        }
        totalDeSeresVivos++;
    }

    private void incrementarContadorMuertos(String tipo) {
        switch (tipo) {
            case "Gato":
                totalDeGatosMuertos++;
                break;
            case "Perro":
                totalDePerrosMuertos++;
                break;
            case "Raton":
                totalDeRatonesMuertos++;
                break;
            case "Planta":
                totalDePlantasMuertas++;
                break;
        }
        totalDeSeresMuertos++;
    }

    private void decrementarContadorVivos(String tipo) {
        switch (tipo) {
            case "Gato":
                totalDeGatos--;
                break;
            case "Perro":
                totalDePerros--;
                break;
            case "Raton":
                totalDeRatones--;
                break;
            case "Planta":
                totalDePlantas--;
                break;
        }
        totalDeSeresVivos--;
    }

    public int getTotalDeSeresVivos() {
        return totalDeSeresVivos;
    }

    public int getTotalDePerros() {
        return totalDePerros;
    }

    public int getTotalDeGatos() {
        return totalDeGatos;
    }

    public int getTotalDeRatones() {
        return totalDeRatones;
    }

    public int getTotalDePlantas() {
        return totalDePlantas;
    }

    public int getTotalDeSeresMuertos() {
        return totalDeSeresMuertos;
    }

    public int getTotalDeGatosMuertos() {
        return totalDeGatosMuertos;
    }

    public int getTotalDePerrosMuertos() {
        return totalDePerrosMuertos;
    }

    public int getTotalDeRatonesMuertos() {
        return totalDeRatonesMuertos;
    }

    public int getTotalDePlantasMuertas() {
        return totalDePlantasMuertas;
    }

    public int getTotalDeSeresNacidos() {
        return totalDeSeresNacidos;
    }

    public int getTotalDeGatosNacidos() {
        return totalDeGatosNacidos;
    }

    public int getTotalDePerrosNacidos() {
        return totalDePerrosNacidos;
    }

    public int getTotalDeRatonesNacidos() {
        return totalDeRatonesNacidos;
    }
}
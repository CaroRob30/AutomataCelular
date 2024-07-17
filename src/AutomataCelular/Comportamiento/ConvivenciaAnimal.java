package AutomataCelular.Comportamiento;

import AutomataCelular.UbicacionSeresVivos.Celda;
import AutomataCelular.Estadisticas.RegistroDeEventos;
import AutomataCelular.SeresVivos.*;
import AutomataCelular.Tablero;
import AutomataCelular.UbicacionSeresVivos.RegistrarUbicacion;

public class ConvivenciaAnimal implements IConvivencia {
    private IPatronDeComportamiento patronDeReproduccion = new PatronDeReproduccion();
    private IPatronDeComportamiento patronDeAlimentacion = new PatronDeAlimentacion();
    private RegistroDeEventos registroDeEventos;

    public ConvivenciaAnimal() {
        Tablero tablero = Tablero.getInstancia();
        registroDeEventos = RegistroDeEventos.getInstancia();

    }
    @Override
    public void encuentro(Animal animal, SerVivo serVivo) {
        if (animal instanceof Gato || animal instanceof Perro || animal instanceof Raton) {
            if (serVivo instanceof Animal) {
                patronDeReproduccion.ejecutar(animal, serVivo);


            } else if (serVivo instanceof Planta) {
                patronDeAlimentacion.ejecutar(animal, serVivo);
                System.out.println("Comio: " + serVivo.getClass().getSimpleName());
                if (!serVivo.estaVivo()) {
                    Celda celdaActual = RegistrarUbicacion.obtenerUbicacion(serVivo);
                    if (celdaActual != null) {
                        celdaActual.eliminarSerVivo(serVivo);
                        registroDeEventos.registrarMuerte(serVivo.getClass().getSimpleName(), 1,
                                celdaActual);
                    }

                }

            }
        }
    }
}
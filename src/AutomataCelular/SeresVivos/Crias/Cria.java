package AutomataCelular.SeresVivos.Crias;

import AutomataCelular.SeresVivos.Animal;
/*
Esta clase abstracta se encarga de definir el método abstracto nacer() que será
implementado por las clases hijas.
Este método está diseñado para crear una instancia de la clase Animal,
que representa a un ser vivo recién nacido.
 */
public abstract class Cria {
    public abstract Animal nacer();
}

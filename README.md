# generador de Credenciales de Evento

## Estudiantes:
Hilary Varela – Patrones de Diseño Sección 1
Cristobal Martinez - Patrones de Diseño Sección 1

## Objetivo del Proyecto
Este sistema permite emitir credenciales personalizadas para un evento, a partir de una plantilla clonable. Se aplican los patrones de diseño **Prototype** (para clonar credenciales) y **Singleton** (para configuración global del evento).

## Cómo ejecutar

Clona el repositorio con:

```bash
git clone https://github.com/cristobalx8ch/GeneradorCredencialesEvento.git
cd GeneradorCredencialesEvento
javac Main.java
java Main
```



### Patrón Prototype – Aplicación

Este patrón permite **clonar una credencial ya existente** sin necesidad de crear una desde cero. La clase Credencial implementa Cloneable y define un método clonar() que crea una copia exacta del objeto.

### ¿Dónde se usa?

En el menú de consola, al seleccionar la opción 3:

```java
Credencial seleccionado = lista.get(option - 1);
// aquí se aplica el patrón Prototype
Credencial clon = seleccionado.clonar();
generador.agregarCredenciales(clon);
```


##  Patrón Singleton – Aplicación

Este patrón se utiliza para asegurar que exista una única instancia del generador de credenciales durante toda la ejecución del programa. Así se mantiene una sola lista de credenciales compartida.

###  ¿Cómo se aplica?

La clase `GeneradorCredenciales` tiene:

- Una **instancia privada estática**.
- Un **constructor privado**.
- Un **método público estático** llamado `obtenerInstancia()` que garantiza una única instancia.

###  Fragmento del código:

```java
private static GeneradorCredenciales instancia;

private GeneradorCredenciales() {
    this.credenciales = new ArrayList<>();
}

public static GeneradorCredenciales obtenerInstancia() {
    if (instancia == null) {
        // ← se crea solo una vez
        instancia = new GeneradorCredenciales();
    }
    return instancia;
}
```


##  Menú por Consola

Este sistema funciona completamente desde la consola y permite al usuario gestionar credenciales de forma interactiva. Al ejecutarse, se despliega el siguiente menú:

```text
--- Menu generador de Credenciales ---
1. Agregar credenciales
2. Mostrar credenciales
3. Clonar una credencial existente
4. Salir
Elije una opcion:
```
##  Diagrama de Clases (UML)

Este es el diagrama de clases del sistema que representa las relaciones entre los componentes principales y el uso de los patrones de diseño Singleton y Prototype.
![Diagrama de clases del sistema](/img/image.png)




Diagrama de Clases (UML)
El siguiente diagrama representa la estructura de clases del sistema, destacando los patrones de diseño utilizados: Prototype y Singleton.


Componentes del Diagrama
1. Prototype
        Define el método clonar().

        Representa el patrón Prototype, que permite duplicar objetos existentes.

2. Credencial
        Clase concreta que implementa Prototype.

        Atributos: nombre, cargo, rut.

        Implementa clonar() para realizar una copia profunda del objeto.

3. GeneradorCredenciales
        Implementa el patrón Singleton:

        Tiene una instancia privada instancia.

        Se accede con el método obtenerInstancia().

        Almacena una lista de Credencial.

        Métodos para agregar y mostrar credenciales.

4. MenuConsola
        Clase auxiliar que gestiona el menú por consola.

        Interactúa con GeneradorCredenciales para manipular credenciales desde la línea de comandos.


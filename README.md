# Proyecto Simulación Gestión de Cultivos de Bacterias
## Descripción
Este proyecto es una simulación de aplicación de escritorio en Java para gestionar cultivos de bacterias. Permite crear y manejar experimentos con diferentes poblaciones de bacterias, simular patrones de alimentación y realizar simulaciones de Montecarlo. La aplicación utiliza Swing para la interfaz gráfica y soporta la persistencia de datos mediante archivos de texto.
## Inicialización
Para inicializar el proyecto, se debe clonar el repositorio y abrirlo en un IDE de Java. Hay dos formas de ejecutar la aplicación:
1. Ejecutar el archivo `Main.java` en la carpeta `src/main/java` desde el IDE.
2. Ejecutar el archivo `Proyecto.jar` en la carpeta `target` desde la terminal con el comando `java -jar Proyecto.jar`.
## Características

- **Crear Nuevos Experimentos:** Permite crear y guardar nuevos experimentos.
- **Agregar Poblaciones:** Posibilidad de añadir poblaciones de bacterias a los experimentos existentes.
- **Visualizar Poblaciones:** Muestra los nombres de todas las poblaciones en un experimento.
- **Eliminar Poblaciones:** Permite eliminar una población de un experimento.
- **Ver Detalles de Poblaciones:** Muestra información detallada de una población específica.
- **Simulación de Montecarlo:** Realiza simulaciones de Montecarlo para estimar el crecimiento de la población.

## Clases
- **org.example.UI:**

InterfazGrafica.java: Define la interfaz gráfica de usuario (GUI) de la aplicación con botones para gestionar experimentos y poblaciones.

- **logica_de_negocio:**

ComidaDialogo.java: Muestra un cuadro de diálogo con una tabla de la cantidad de comida diaria de una población.

Experimento.java: Representa un experimento que contiene varias poblaciones de bacterias.

ExperimentoDialogo.java: Muestra y permite editar los detalles de un experimento.

PatronAlimentacionAlterno.java: Implementa un patrón de alimentación alterno (un día con comida, otro sin).

PatronAlimentacionConstante.java: Implementa un patrón de alimentación constante.

PatronAlimentacionDecrementoIncremento.java: Implementa un patrón de alimentación con incremento y luego decremento.

PatronAlimentacionIncremento.java: Implementa un patrón de alimentación con incremento lineal.

PatronDeComida.java: Interfaz que define el método para obtener la cantidad de comida diaria.

Poblacion.java: Representa una población de bacterias con atributos como nombre, fechas, número de bacterias y patrón de alimentación.

PoblacionDialogo.java: Muestra un cuadro de diálogo con detalles de una población.

SimulacionMontecarlo.java: Realiza simulaciones de Montecarlo para estimar el crecimiento de la población.
- **persistencia:**

GestorDatos.java: Maneja la persistencia de datos para guardar y cargar experimentos desde archivos de texto.
## Autor
**Juan Pablo Lobato**
# 2017-jm-group-05
Repositorio de TPs del grupo 05

## Decisiones de Diseno

Para la corrección de la primer entrega, cambiamos completamente el modelo. Ahora existe una empresa que tiene una lista de cuentas. Para mostrarlo, decidimos utilizar un selector de empresas y, cuando se selecciona una empresa, se debe tocar el botón "Mostrar Cuentas", el cual carga en una tabla los datos de las cuentas.
Decidimos mantener la pantalla inicial como Menú ya que para futuras iteraciones habrá más opciones disponibles. 

## Entrega 2:

Párametros: decidimos modelar los parámetros con un valor y un nombre, sin importar si es una cuenta, un valor u otro indicador. La razón por la que hicimos esto es porque no nos interesa qué es el parámetro, si no solo conocer su valor. Si su valor depende de cosas que todavía no están cargadas, con el nombre del parámetro las podemos cargar. 

Cuentas: utilizados un strategy para validar que operación debía realizar el indicador, ya que nos pareció lo más sencillo definir los algoritmos por fuera de la clase para desacoplar, pero que pueda cambiar dinámicamente de algoritmo dependiendo de sus parámetros. 

Indicador: utilizamos un Builder para el indicador para poder ir creandolo por partes pudiendo así validar que al menos tenga un parametro ingresado y no tenga un estado inconsistente en el sistema.

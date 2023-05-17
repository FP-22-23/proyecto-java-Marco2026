# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Marco Antonio Herrera  |  uvus:marherluj

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp.tipos**: Paquete que contiene los tipos del proyecto.
  * **fp.tipos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **DatosProyecto.csv**: Archivo csv que contiene datos de diferentes compras.

## Estructura del *dataset*

El dataset original E-Commerce Data se puede obtener de la URL [https://www.kaggle.com/datasets/carrie1/ecommerce-data](https://www.kaggle.com/datasets/carrie1/ecommerce-data). Originalmente tiene 8 columnas y cada fila contiene datos sobre una compra realizada en un determinado e-commerce. El dataset usado en este proyecto tiene 8 columnas, 7 se han tomado del dataset original, y una, de tipo booleana, se ha generado de forma aleatoria. A continuación se describen las 8 columnas del dataset:

* **StockCode**: de tipo String, indica el código de Stock del producto comprado. Tiene entre 5 y 7 caracteres, uno puede ser una letra y los demás números.
* **Description**: de tipo String, es la descripción del producto que ha sido comprado.
* **Quantity**: de tipo Integer, indica la cantidad, en números enteros, de productos del mismo tipo que han  sido comprados.
* **UnitPrice**: de tipo Double, es el precio que cuesta cada unidad del producto comprado.
* **PurchaseDate**: de tipo LocalDateTime, contiene la fecha y hora exactas a la que se compró el determinado producto.
* **CustomerID**: de tipo String, indica el ID de comprador.
* **Country**: de tipo String, es el país de procedencia del comprador.
* **Satisfied**: de tipo Boolean, indica si el cliente está satisfecho con el producto. Puede tomar los valores VERDADERO o FALSO.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Compra
Consiste en una compra concreta.

**Propiedades**:

- _stockCode_, de tipo _String_, consultable y modificable.
- _description_, de tipo _String_, consultable.
- _purchase_, de tipo _Purchase_, consultable.
- _purchaseDate_, de tipo _LocalDateTime_, consultable y modificable.
- _customerId_, de tipo _Integer_, consultable y modificable.
- _country_, de tipo _TypeCountry_, consultable.
- _satisfied_, de tipo _Boolean_, consultable y modificable. Contiene el rating del jugador de negras.
- _survey_, de tipo _String_, consultable. Cadena de texto con la descripción del producto y el grado de satisfacción del comprador.
- _finalPrice_, de tipo _Double_, consultable. Precio final que resulta de sumar los impuestos de cada país al precio de la compra.
- _keywords_, de tipo _List<String>_, consultable. Lista con las palabras de más de 3 caracteres incluidas en la descripción de la compra.


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Compra a partir de los siguientes parámetros: ```String description, Integer customerId, Boolean satisfied```.

**Restricciones**:
 
- R1: El código de Stock no puede tener más de 7 caracteres.
- R2: La propiedad satisfied no puede tomar un valor null.
- R3: La fecha y hora de compra no puede ser después de la fecha y hora actual.
- R4: El ID del comprador debe tener 5 números.

**Criterio de igualdad**: Dos compras son iguales si todas sus propiedades básicas, excepto _purchase_, son iguales.

**Criterio de ordenación**: Utilizando las mismas propiedades que en el criterio de igualdad.

**Otras operaciones**:

- _Double getFee()_: Devuelve las tasas que deben pagar los compradores según el país desde el que compren. Está regulado por un switch.

#### Tipos auxiliares

- _TypeCountry_, de tipo _Enum_. Puede tomar los valores *GERMANY, AUSTRALIA, EIRE, FRANCE, UNITED_KINGDOM, NORWAY, NETHERLANDS, OTHER*.
- _Purchase_, de tipo _record_. Formado por las propiedades _quantity_ y _unitPrice_.

### Factoría - FactoriaCompras
Clase de Factoría para construir objetos de tipo Compras
- Compras leerCompras(String nombreFichero): Crea un objeto de tipo Compras a partir de los datos obtenidos en el archivo csv, cuya ruta es dada como parámetro.

### Tipo Contenedor - Compras
Clase contenedora de los objetos de tipo Compra.

**Propiedades:**
- compras, de tipo List<Compra>, consultable. Lista de compras.

**Constructores:**
- C1: Constructor por defecto. Crea un objeto de tipo Compras sin ninguna compra almacenada.
- C2: Constructor con un parámetro de tipo Collection<Compra>. Crea un objeto de tipo Compras con las compras incluidas en la colección dada como parámetro.
- C3: Constructor con un parámetro de tipo Stream<Compra>. Crea un objeto de tipo Compras con las compras incluidas en el Stream dado.

**Criterio de igualdad:** Dos compras son iguales si lo son sus propiedades compras.

**Otras operaciones:**
- _Integer getNumElem()_: Devuelve el número de compras almacenado en el objeto Compras.
- _void agregarElem(Compra c)_; Añade una compra al objeto Compras.
- _void anadirColeccion(Collection<Compra> c)_: Añade todos los elementos de una colección al Objeto Compras.
- _void eliminarElem(Compra c)_: Elimina un elemento del objeto Compras dada la Compra.
- _void eliminarElem(int indice)_: Elimina un elemento del objeto Compras dado su índice.
- _Boolean clienteCompraMenosDe(Integer customerId, Integer n)_: Devuelve si el cliente ha comprado en alguna de sus compras menos unidades que el numero n.
- _Integer numComprasPorCliente(Integer customerId)_: Devuelve el número de compras realizadas por un cliente dado.
- _List<Compra> encuentraComprasMayoresPorPais(TypeCountry country, Double n)_: Devuelve las compras que fueron mas caras que n en el pais country.
- _SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPais()_: Devuelve las compras que fueron mas caras que n en el pais country.
- _SortedMap<Integer, Double> cuentaGastoPorCliente()_: Devuelve El gasto total de cada cliente.
- _Boolean clienteCompraMenosDeStream(Integer customerId, Integer n)_: Devuelve true si el cliente ha comprado en alguna de sus compras menos unidades que el numero n.
- _Integer numComprasPorClienteStream(Integer customerId)_: Devuelve el numero de compras realizadas por un cliente dado.
- _List<Compra> encuentraComprasMayoresPorPaisStream(TypeCountry country, Double n)_: Devuelve las compras que fueron mas caras que n en el pais country.
- _Compra getCompraMayorPorCliente(Integer customerId)_: Devuelve la compra mas cara del cliente dado como parametro.
- _List<Integer> getIdClientesPorPaisOrdenados(TypeCountry Country)_: Devuelve una lista ordenada por el orden natural de Integer de los ID de los clientes.
- _SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPaisStream()_: Devuelve un Map en el que las claves son los paises y los valores son conjuntos de palabras clave usadas por clientes de ese pais.
- _Map<LocalDateTime, Compra> getCompraMasCaraPorFecha()_: Devuelve un Map en el que las claves son las fechas de compra y los valores son la compra más cara que se realizo.
- _Map<Integer, Compra> getCompraMasBarataPorCliente()_: Devuelve un Map en el que las claves son los Id de los clientes y los valores son la compra más barata que realizaron.
- _SortedMap<TypeCountry, List<String>> getNDescripcionesMasCortasPorPais(Integer n)_: Devuelve un diccionario con paises como clave y una lista de n descripciones mas cortas por pais como valores.
- _LocalDateTime compraMasCaraPorHora()_: Devuelve una clave del tipo LocalDateTime asociada a un valor de tipo Purchase, el mas caro de todo el Map.

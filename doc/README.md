# Proyecto del Segundo Cuatrimestre Fundamentos de Programaci�n (Curso 2022/23)
Autor/a: Marco Antonio Herrera  |  uvus:marherluj

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el c�digo fuente.
  * **fp.tipos**: Paquete que contiene los tipos del proyecto.
  * **fp.tipos.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **DatosProyecto.csv**: Archivo csv que contiene datos de diferentes compras.

## Estructura del *dataset*

El dataset original E-Commerce Data se puede obtener de la URL [https://www.kaggle.com/datasets/carrie1/ecommerce-data](https://www.kaggle.com/datasets/carrie1/ecommerce-data). Originalmente tiene 8 columnas y cada fila contiene datos sobre una compra realizada en un determinado e-commerce. El dataset usado en este proyecto tiene 8 columnas, 7 se han tomado del dataset original, y una, de tipo booleana, se ha generado de forma aleatoria. A continuaci�n se describen las 8 columnas del dataset:

* **StockCode**: de tipo String, indica el c�digo de Stock del producto comprado. Tiene entre 5 y 7 caracteres, uno puede ser una letra y los dem�s n�meros.
* **Description**: de tipo String, es la descripci�n del producto que ha sido comprado.
* **Quantity**: de tipo Integer, indica la cantidad, en n�meros enteros, de productos del mismo tipo que han  sido comprados.
* **UnitPrice**: de tipo Double, es el precio que cuesta cada unidad del producto comprado.
* **PurchaseDate**: de tipo LocalDateTime, contiene la fecha y hora exactas a la que se compr� el determinado producto.
* **CustomerID**: de tipo String, indica el ID de comprador.
* **Country**: de tipo String, es el pa�s de procedencia del comprador.
* **Satisfied**: de tipo Boolean, indica si el cliente est� satisfecho con el producto. Puede tomar los valores VERDADERO o FALSO.

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
- _survey_, de tipo _String_, consultable. Cadena de texto con la descripci�n del producto y el grado de satisfacci�n del comprador.
- _finalPrice_, de tipo _Double_, consultable. Precio final que resulta de sumar los impuestos de cada pa�s al precio de la compra.
- _keywords_, de tipo _List<String>_, consultable. Lista con las palabras de m�s de 3 caracteres incluidas en la descripci�n de la compra.


**Constructores**: 

- C1: Tiene un par�metro por cada propiedad b�sica del tipo.
- C2: Crea un objeto de tipo Compra a partir de los siguientes par�metros: ```String description, Integer customerId, Boolean satisfied```.

**Restricciones**:
 
- R1: El c�digo de Stock no puede tener m�s de 7 caracteres.
- R2: La propiedad satisfied no puede tomar un valor null.
- R3: La fecha y hora de compra no puede ser despu�s de la fecha y hora actual.
- R4: El ID del comprador debe tener 5 n�meros.

**Criterio de igualdad**: Dos compras son iguales si todas sus propiedades b�sicas, excepto _purchase_, son iguales.

**Criterio de ordenaci�n**: Utilizando las mismas propiedades que en el criterio de igualdad.

**Otras operaciones**:

- _Double getFee()_: Devuelve las tasas que deben pagar los compradores seg�n el pa�s desde el que compren. Est� regulado por un switch.

#### Tipos auxiliares

- _TypeCountry_, de tipo _enum_. Puede tomar los valores *GERMANY, AUSTRALIA, EIRE, FRANCE, UNITED_KINGDOM, NORWAY, NETHERLANDS, OTHER*.
- _Purchase_, de tipo _record_. Formado por las propiedades _quantity_ y _unitPrice_.

### Factor�a - FactoriaCompras
Clase de Factor�a para construir objetos de tipo Compras
- Compras leerCompras(String nombreFichero): Crea un objeto de tipo Compras a partir de los datos obtenidos en el archivo csv, cuya ruta es dada como par�metro.

### Tipo Contenedor - Compras
Clase contenedora de los objetos de tipo Compra.

**Propiedades:**
- compras, de tipo List<Compra>, consultable. Lista de compras.

**Constructores:**
- C1: Constructor por defecto. Crea un objeto de tipo Compras sin ninguna compra almacenada.
- C2: Constructor con un par�metro de tipo Collection<Compra>. Crea un objeto de tipo Compras con las compras incluidas en la colecci�n dada como par�metro.
- C3: Constructor con un par�metro de tipo Stream<Compra>. Crea un objeto de tipo Compras con las compras incluidas en el Stream dado.

**Criterio de igualdad:** Dos compras son iguales si lo son sus propiedades compras.

**Otras operaciones:**
- _Integer getNumElem()_: Devuelve el n�mero de compras almacenado en el objeto Compras.
- _void agregarElem(Compra c)_; A�ade una compra al objeto Compras.
- _void anadirColeccion(Collection<Compra> c)_: A�ade todos los elementos de una colecci�n al Objeto Compras.
- _void eliminarElem(Compra c)_: Elimina un elemento del objeto Compras dada la Compra.
- _void eliminarElem(int indice)_: Elimina un elemento del objeto Compras dado su �ndice.
- _Boolean clienteCompraMenosDe(Integer customerId, Integer n)_: Devuelve si el cliente ha comprado en alguna de sus compras menos unidades que el numero n.
- _Integer numComprasPorCliente(Integer customerId)_: Devuelve el n�mero de compras realizadas por un cliente dado.
- _List<Compra> encuentraComprasMayoresPorPais(TypeCountry country, Double n)_: Devuelve las compras que fueron mas caras que n en el pais country.
- _SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPais()_: Devuelve las compras que fueron mas caras que n en el pais country.
- _SortedMap<Integer, Double> cuentaGastoPorCliente()_: Devuelve El gasto total de cada cliente.

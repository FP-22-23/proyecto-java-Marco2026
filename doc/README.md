# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Marco Antonio Herrera   uvus:marherluj

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
* **Satisfied**: de tipo Boolean, indica si el cliente esta satisfecho con el producto. Puede tomar los valores VERDADERO o FALSO.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Compras
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
- _keywords_, de tipo _List\<String\>_, consultable. Lista con las palabras de más de 3 caracteres incluidas en la descripción de la compra.


**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo Compra a partir de los siguientes parámetros: ```String description, Integer customerId, Boolean satisfied```.

**Restricciones**:
 
- R1: El código de Stock no puede tener más de 6 caracteres.
- R2: Satisfied no puede tomar un valor null.
- R3: La fecha y hora de compra no puede ser después de la fecha y hora actual.
- R4: El ID del comprador debe tener 5 números.
***Criterio de igualdad**: Dos compras son iguales si todas sus propiedades básicas excepto purchase son iguales.

**Criterio de ordenación**: Utilizando las mismas propiedades que en el criterio de igualdad.

**Otras operaciones**:

- _Double getFee()_: Devuelve las tasas que deben pagar los compradores según el país desde el que compren. Está regulado por un switch.

#### Tipos auxiliares

- TypeCountry, enum. Puede tomar los valores GERMANY, AUSTRALIA, EIRE, FRANCE, UNITED_KINGDOM, NORWAY, NETHERLANDS, OTHER.
- Purchase, record. Formado por las propiedades quantity y unitPrice.

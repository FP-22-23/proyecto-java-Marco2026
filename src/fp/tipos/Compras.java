package fp.tipos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import fp.common.TypeCountry;

public interface Compras {

	//Entrega 2
	/**
	 * @return Lista de Compras
	 */
	List<Compra> getCompras();

	/**
	 * @return El numero de compras almacenado en el objeto Compras.
	 */
	Integer getNumElem();

	/**
	 * @param c compra
	 * AÃ±ade una compra al objeto
	 */
	void agregarElem(Compra c);
	
	/**
	 * @param c Coleccion con objetos tipo Compra
	 * Añade una coleccion al objeto
	 */
	void anadirColeccion(Collection<Compra> c);

	/**
	 * @param c
	 * Elimina un elemento del objeto
	 */
	void eliminarElem(Compra c);
	
	/**
	 * @param c
	 * Elimina un elemento del objeto
	 */
	void eliminarElem(int indice);
	
	/**
	 * FUNCION TIPO 1
	 * 
	 * Tipo: existe
	 * 
	 * @param customerId: ID del cliente que realiza la compra
	 * @param n: numero del que se quiere saber si se ha comprado menos del numero n de unidades
	 * @return si el cliente ha comprado en alguna de sus compras menos unidades que el numero n
	 */
	Boolean clienteCompraMenosDe(Integer customerId, Integer n);
	
	/**
	 * FUNCION TIPO 2
	 * 
	 * Tipo: contador
	 * 
	 * @param customerId: ID del cliente que realiza la compra
	 * @return el numero de compras realizadas por un cliente dado
	 */
	Integer numComprasPorCliente(Integer customerId);
	
	/**
	 * FUNCION TIPO 3
	 * 
	 * Tipo: seleccion con filtrado
	 * 
	 * @param country: Pais en el que se buscan las compras
	 * @param n: Dinero minimo sobre el que se quiere saber si una compra ha sido mas cara
	 * @return las compras que fueron mas caras que n en el pais country
	 */
	List<Compra> encuentraComprasMayoresPorPais(TypeCountry country, Double n);
	
	/**
	 * FUNCION TIPO 4
	 * 
	 * Tipo: Agrupacion en Map
	 * 
	 * @return las compras que fueron mas caras que n en el pais country
	 */
	SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPais();
	
	/**
	 * FUNCION TIPO 5
	 * 
	 * Tipo: Conteo en Map
	 * 
	 * @return El gasto total de cada cliente
	 */
	SortedMap<Integer, Double> cuentaGastoPorCliente();
	
	//Entrega 3
	/**
	 * FUNCION TIPO 1
	 * 
	 * Tipo: existe
	 * 
	 * @param customerId: ID del cliente que realizo la compra
	 * @param n: numero del que se quiere saber si se ha comprado menos del numero n de unidades
	 * @return si el cliente ha comprado en alguna de sus compras menos unidades que el numero n
	 */
	Boolean clienteCompraMenosDeStream(Integer customerId, Integer n);
	
	/**
	 * FUNCION TIPO 2
	 * 
	 * Tipo: contador
	 * 
	 * @param customerId: ID del cliente que realizo la compra
	 * @return el numero de compras realizadas por un cliente dado
	 */
	Integer numComprasPorClienteStream(Integer customerId);
	
	/**
	 * FUNCION TIPO 3
	 * 
	 * Tipo: seleccion con filtrado
	 * 
	 * @param country: Pais en el que se buscan las compras
	 * @param n: Dinero minimo sobre el que se quiere saber si una compra ha sido mas cara
	 * @return las compras que fueron mas caras que n en el pais country
	 */
	List<Compra> encuentraComprasMayoresPorPaisStream(TypeCountry country, Double n);
	
	/**
	 * FUNCION TIPO 4
	 * 
	 * Tipo: Un máximo con filtrado
	 * 
	 * @param customerId: Id del cliente sobre el que queremos encontrar su compra más cara
	 * @return la compra mas cara del cliente dado como parametro
	 */
	Compra getCompraMayorPorCliente(Integer customerId);
	
	/**
	 * FUNCION TIPO 5
	 * 
	 * Tipo: Una selección con ordenación y filtrado
	 * 
	 * @return una lista ordenada por el orden natural de Integer de los ID de los clientes
	 */
	List<Integer> getIdClientesPorPaisOrdenados(TypeCountry Country);
	
	/**
	 * FUNCION TIPO 6
	 * 
	 * Tipo: Funcion tipo 4 de la entrega 2
	 * 
	 * @return Devuelve un Map en el que las claves son los paises y 
	 * 		   los valores son conjuntos de palabras clave usadas por clientes de ese pais
	 */
	SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPaisStream();
	
	/**
	 * FUNCION TIPO 7
	 * 
	 * Tipo: Método que usa collectingAndThen
	 * 
	 * @return Un Map en el que las claves son las fechas de compra y
	 * 		   los valores son la compra más cara que se realizo
	 */
	Map<LocalDateTime, Compra> getCompraMasCaraPorFecha();
	
	/**
	 * FUNCION TIPO 8
	 * 
	 * Tipo: Funcion que agrupa en un Map por atributo junto con un minimo
	 * 
	 * @return Un Map en el que las claves son los Id de los clientes y
	 * 		   los valores son la compra más barata que realizaron
	 */
	Map<Integer, Compra> getCompraMasBarataPorCliente();
	
	/**
	 * FUNCION TIPO 9
	 * 
	 * Tipo: Funcion que devuelve un SortedMap con un atributo como clave 
	 * 		 y listas con los n mejores elementos como valores
	 *       
	 * @return Un diccionario con paises como clave y una lista de n descripciones mas cortas por pais como valores
	 */
	SortedMap<TypeCountry, List<String>> getNDescripcionesMasCortasPorPais(Integer n);
	
	/**
	 * FUNCION TIPO 10
	 * 
	 * Tipo: Funcion que calcula un Map y devuelve la clave con el valor 
	 * 		 asociado mayor o menor de todo el Map
	 *      
	 * @return una clave del tipo LocalDateTime asociada a un valor de tipo Purchase, el mas caro de todo el Map
	 */
	LocalDateTime compraMasCaraPorHora();

}
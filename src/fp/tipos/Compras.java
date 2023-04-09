package fp.tipos;

import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;

import fp.common.TypeCountry;

public interface Compras {

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

}
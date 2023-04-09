package fp.tipos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.common.TypeCountry;
import fp.utiles.Checkers;

public class ComprasImpl implements Compras {

	//Atributos
	private List<Compra> compras;
	
	//Constructores
	/**
	 * Crea un objeto Compras vacio
	 */
	public ComprasImpl() {
		compras = new LinkedList<Compra>();
	}		
	
	/**
	 * @param compras coleccion de compras
	 * Crea un objeto a partir de una coleccion de compras
	 */
	public ComprasImpl(Collection<Compra> compras) {
		this.compras = new LinkedList<Compra>(compras);
	}
	
	/**
	 * @param compras Stream de compras
	 * Crea un objeto Compras a partir de un Stream de compras
	 */
	public ComprasImpl(Stream<Compra> compras) {
		this.compras = compras.collect(Collectors.toList());
	}

	//getters
	public List<Compra> getCompras() {
		return compras;
	}
	
	//Equals y hashCode
	public int hashCode() {
		return Objects.hash(compras);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComprasImpl other = (ComprasImpl) obj;
		return Objects.equals(compras, other.compras);
	}

	//Operaciones a, b, c, d
	public Integer getNumElem() {
		return compras.size();
	}

	public void agregarElem(Compra c) {
		compras.add(c);
	}

	public void anadirColeccion(Collection<Compra> c) {
		compras.addAll(c);
	}

	public void eliminarElem(Compra c) {
		compras.remove(c);
	}
	
	public void eliminarElem(int indice) {
		Checkers.check("Içndice fuera de los limites", indice < compras.size());
		compras.remove(indice);
	}
	
	//Funciones 1, 2, 3, 4, 5
	/**
	 * FUNCION TIPO 1
	 * 
	 * Tipo: existe
	 * 
	 * @param customerId: ID del cliente que realizo la compra
	 * @param n: numero del que se quiere saber si se ha comprado menos del numero n de unidades
	 * @return si el cliente ha comprado en alguna de sus compras menos unidades que el numero n
	 */
	public Boolean clienteCompraMenosDe(Integer customerId, Integer n) {
		Boolean res = false;
		for(Compra compra:compras) {
			if(customerId.equals(compra.getCustomerId()) && compra.getPurchase().quantity() < n) {						
				res = true;
				break;
			}
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO 2
	 * 
	 * Tipo: contador
	 * 
	 * @param customerId: ID del cliente que realizo la compra
	 * @return el numero de compras realizadas por un cliente dado
	 */
	public Integer numComprasPorCliente(Integer customerId) {
		Integer res = 0;
		for(Compra compra:compras) {
			if(compra.getCustomerId().equals(customerId)) {
				res++;
			}
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO 3
	 * 
	 * Tipo: seleccion con filtrado
	 * 
	 * @param country: Pais en el que se buscan las compras
	 * @param n: Dinero minimo sobre el que se quiere saber si una compra ha sido mas cara
	 * @return las compras que fueron mas caras que n en el pais country
	 */
	public List<Compra> encuentraComprasMayoresPorPais(TypeCountry country, Double n) {
		List<Compra> res = new LinkedList<Compra>();
		for(Compra compra:compras) {
			if(compra.getCountry().equals(country) && compra.getFinalPrice() > n) {
				res.add(compra);
			}
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO 4
	 * 
	 * Tipo: Agrupacion en Map
	 * 
	 * @return las compras que fueron mas caras que n en el pais country
	 */
	public SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPais() {
		SortedMap<TypeCountry, SortedSet<String>> res = new TreeMap<>();
		for(Compra compra:compras) {
			TypeCountry clave = compra.getCountry();
			if(res.containsKey(clave)) {
				res.get(clave).addAll(compra.getKeywords());
			} else {
				SortedSet<String> ss = new TreeSet<>();
				ss.addAll(compra.getKeywords());
				res.put(clave, ss);
			}
		}
		return res;
	}
	
	/**
	 * FUNCION TIPO 5
	 * 
	 * Tipo: Conteo en Map
	 * 
	 * @return El gasto total de cada cliente
	 */
	public SortedMap<Integer, Double> cuentaGastoPorCliente() {
		SortedMap<Integer, Double> res = new TreeMap<>();
		for(Compra compra:compras) {
			Integer clave = compra.getCustomerId();
			if(res.containsKey(clave)) {
				res.put(clave, res.get(clave) + compra.getFinalPrice()); 
			} else {
				Double gasto = compra.getFinalPrice();
				res.put(clave, gasto);
			}
		}
		return res;
	}
}

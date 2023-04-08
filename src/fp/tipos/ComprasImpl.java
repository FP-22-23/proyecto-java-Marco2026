package fp.tipos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.biblioteca.Libro;
import fp.common.TypeCountry;
import fp.utiles.Checkers;

public class ComprasImpl implements Compras {

	private List<Compra> compras;
	//Constructores

	/**
	 * Crea un objeto Compras vacío
	 */
	public ComprasImpl() {
		compras = new LinkedList<Compra>();
	}
	
	/**
	 * @param compras colección de compras
	 * Crea un objeto a partir de una colección de compras
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
		Checkers.check("Índice fuera de los límites", indice < compras.size());
		compras.remove(indice);
	}
	
	//Funciones 1, 2, 3, 4, 5
	/**
	 * FUNCION TIPO 1
	 * 
	 * Tipo: existe
	 * 
	 * @param customerId: ID del cliente que realizó la compra
	 * @param n: número del que se quiere saber si se ha comprado menos del número n de unidades
	 * Esta función dice si el cliente ha comprado en alguna de sus compras menos unidades que el numero n
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
	 * @param customerId: ID del cliente que realizó la compra
	 * Esta función cuenta el numero de compras realizadas por un cliente dado
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
	 * Tipo: selección con filtrado
	 * 
	 * @param customerId: ID del cliente que realizó la compra
	 * @param n: número del que se quiere saber si se ha comprado menos del número n de unidades
	 * Esta función dice si el cliente ha comprado en alguna de sus compras menos unidades que el numero n
	 */
	public List<Compra> encuentraComprasMayoresPorPais(TypeCountry country, Double n) {
		List<Compra> res = new LinkedList<Compra>();
		for(Compra compra:compras) {
			if(compra.getCountry().equals(country) && compra.getPurchase().getTotalPurchase() > n) {
				res.add(compra);
			}
		}
		return res;
	}
	
	
	
	
	
	
	
}

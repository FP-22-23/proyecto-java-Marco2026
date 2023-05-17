package fp.tipos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.common.Purchase;
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

	//Entrega 2
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
	 * @return Devuelve un Map en el que las claves son los paises y 
	 * 		   los valores son conjuntos de palabras clave usadas por clientes de ese pais
	 */
	public SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPais() {
		SortedMap<TypeCountry, SortedSet<String>> res = new TreeMap<>(); //Creamos el SortedMap
		for(Compra compra:compras) { //Recorremos el bucle
			TypeCountry clave = compra.getCountry(); //Asignamos el valor de la clave
			if(res.containsKey(clave)) { //La clave ya est· en el Map
				res.get(clave).addAll(compra.getKeywords()); //Anyado al SortedSet los nuevos valores
			} else { //La clave a˙n no est· en el Map
				SortedSet<String> ss = new TreeSet<>(); //Creamos un SortedSet
				ss.addAll(compra.getKeywords()); //Le anyado las keywords
				res.put(clave, ss); //Pongo la pareja de clave y el valor con el SortedSet en el Map
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
	public Boolean clienteCompraMenosDeStream(Integer customerId, Integer n) {
		return compras.stream() //Stream<Compra>
					  .anyMatch(v -> v.getCustomerId().equals(customerId) && v.getPurchase().quantity() < n); //Boolean
					//anyMatch se encarga de encontrar al menos 1 valor que cumpla los requisitos indicados
	}
	
	/**
	 * FUNCION TIPO 2
	 * 
	 * Tipo: contador
	 * 
	 * @param customerId: ID del cliente que realizo la compra
	 * @return el numero de compras realizadas por un cliente dado
	 */
	public Integer numComprasPorClienteStream(Integer customerId) {
		Long res = compras.stream() //Stream<Compra>
					  	  .filter(c -> c.getCustomerId().equals(customerId)) //Stream<Compra> filtrado
					  	  .count(); //Long
		return res.intValue(); //Devolvemos res.intValue() para deshacernos del Long
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
	public List<Compra> encuentraComprasMayoresPorPaisStream(TypeCountry country, Double n) {
		return compras.stream() //Stream<Compra>
					  .filter(c -> c.getCountry().equals(country) && c.getFinalPrice() > n) //Stream<Compra> filtrado
					  .collect(Collectors.toList()); //List<Compra>
	}
	
	/**
	 * FUNCION TIPO 4
	 * 
	 * Tipo: Un m·ximo con filtrado
	 * 
	 * @param customerId: Id del cliente sobre el que queremos encontrar su compra mas cara
	 * @return la compra mas cara del cliente dado como parametro
	 */
	public Compra getCompraMayorPorCliente(Integer customerId) {
		Comparator<Compra> comp = Comparator.comparing(Compra::getFinalPrice); //Comparator que compara los objetos de tipo Compra por su propiedad derivada getFinalPrice()
		return compras.stream() //Stream<Compra>
					  .filter(c -> c.getCustomerId().equals(customerId)) //Stream<Compra> filtrado
					  .max(comp) //Optional<Compra>
					  .orElse(null); //Compra / null
	}
	
	/**
	 * FUNCION TIPO 5
	 * 
	 * Tipo: Una selecciÛn con ordenaciÛn y filtrado
	 * 
	 * @return una lista ordenada por el orden natural de Integer de los ID de los clientes
	 */
	public List<Integer> getIdClientesPorPaisOrdenados(TypeCountry Country) {
		return compras.stream() //Stream<Compra>
					  .filter(c -> c.getCountry().equals(Country)) //Stream<Compra> filtrado
					  .map(Compra::getCustomerId) //Stream<Integer>
					  .distinct() //Stream<Integer> sin duplicados
					  .sorted() //Stream<Integer> ordenado
					  .collect(Collectors.toList()); //List<Integer>
	}
	
	/**
	 * FUNCION TIPO 6
	 * 
	 * Tipo: Funcion tipo 4 de la entrega 2
	 * 
	 * @return Devuelve un Map en el que las claves son los paises y 
	 * 		   los valores son conjuntos de palabras clave usadas por clientes de ese pais
	 */
	public SortedMap<TypeCountry, SortedSet<String>> agrupaKeywordsPorPaisStream() {
		 return compras.stream() //Stream<Compra>
				 	   .collect(Collectors.groupingBy( //Agrupamos en un SortedMap
						         Compra::getCountry, //Funcion claves
						         TreeMap::new, //Recipiente de la informacion
						         Collectors.flatMapping( //"Aplanamos" los valores
						        		 c -> c.getKeywords().stream(), //Metemos las keywords en streams
						        		 Collectors.toCollection(TreeSet::new) //El resultado de "aplanar" los streams se mete en un nuevo SortedSet
						        		 )
							     ));
	}

	/**
	 * FUNCION TIPO 7
	 * 
	 * Tipo: MÈtodo que usa collectingAndThen
	 * 
	 * @return Un Map en el que las claves son las fechas de compra y
	 * 		   los valores son la compra m·s cara que se realizo
	 */
	public Map<LocalDateTime, Compra> getCompraMasCaraPorFecha() {
	Comparator<Compra> comp = Comparator.comparing(Compra::getFinalPrice); //Comparator que compara el objeto de tipo Compra por su propiedad derivada getFinalPrice
	return compras.stream() //Stream<Compra>
				  .collect(Collectors.groupingBy( //Agrupamos el Stream
						   Compra::getPurchaseDate, //Funcion claves (por fecha)
						   Collectors.collectingAndThen( //Usamos collectingAndThen para transformar y luego recolectar
							 	   Collectors.maxBy(comp), //Transformacion: Obtener el maximo
								   Optional::get //Tomamos ese maximo (que viene dado en Optional<Compra>
								   )
						   ));
	}
	
	/**
	 * FUNCION TIPO 8
	 * 
	 * Tipo: Funcion que agrupa en un Map por atributo junto con un minimo
	 * 
	 * @return Un Map en el que las claves son los Id de los clientes y
	 * 		   los valores son la compra m·s barata que realizaron
	 */
	public Map<Integer, Compra> getCompraMasBarataPorCliente() {
	Comparator<Compra> comp = Comparator.comparing(Compra::getFinalPrice); //Comparator que compara el objeto de tipo Compra por su propiedad derivada getFinalPrice
	return compras.stream() //Stream<Compra>
				  .collect(Collectors.groupingBy( //Agrupamos el Stream
						   Compra::getCustomerId, //Funcion claves (Integer customerId)
						   Collectors.collectingAndThen( //Usamos collectingAndThen para transformar y luego recolectar
							 	   Collectors.minBy(comp), //Aplicamos el valor minimo a cada Compra
								   Optional::get //Tomamos el valor desenvolviendo el Optional<Compra>
								   )
						   ));
	}
	
	/**
	 * FUNCION TIPO 9
	 * 
	 * Tipo: Funcion que devuelve un SortedMap con un atributo como clave 
	 * 		 y listas con los n mejores elementos como valores
	 *       
	 * @return Un diccionario con paises como clave y una lista de n descripciones mas cortas por pais como valores
	 */
	public SortedMap<TypeCountry, List<String>> getNDescripcionesMasCortasPorPais(Integer n) {
		Comparator<String> comp = Comparator.comparing(String::length); //Comparator que compara los String por su atributo length
		
		//Primero creamos un diccionario auxiliar con clave pais y valor lista de descripciones
		Map<TypeCountry, List<String>> aux = compras.stream()
					  								.collect(Collectors.groupingBy(
															Compra::getCountry, //Funcion claves (por pais)
															Collectors.mapping( //Transformamos los valores y los recolectamos
																	Compra::getDescription, //Transformamos la compra en su descripcion
																	Collectors.toList()) //Las vamos metiendo en una lista
															));
		
		//Recorremos el diccionario por parejas para poder realizar los cambios necesarios en los valores
		return aux.entrySet()
				  .stream()
				  .collect(Collectors.groupingBy(
						  Map.Entry::getKey, //Tomamos como clave cada clave del Map anterior
						  TreeMap::new, //Metemos las claves y los valores en un SortedMap
						  Collectors.flatMapping( //Hacemos un flatMapping para poder editar los valores mas facilmente
								  c -> c.getValue().stream().sorted(comp.reversed()).limit(n), //Convertimos a Stream las listas de los valores y las ordenamos y limitamos
								  Collectors.toList() //Volvemos a meter todo en una lista
								  )
						  
						  ));
						  
	}
	
	/**
	 * FUNCION TIPO 10
	 * 
	 * Tipo: Funcion que calcula un Map y devuelve la clave con el valor 
	 * 		 asociado mayor o menor de todo el Map
	 *      
	 * @return una clave del tipo LocalDateTime asociada a un valor de tipo Purchase, el mas caro de todo el Map
	 */
	public LocalDateTime compraMasCaraPorHora() {
		Comparator<Purchase> comp = Comparator.comparing(Purchase::getTotalPurchase); //Comparator que compara los objetos de tipo Purchase por su propiedad getTotalPurchase
		
		//Primero creamos un diccionario auxiliar que agrupe las claves (fecha) y transforme los valores de Compra a Purchase
	    Map<LocalDateTime, List<Purchase>> aux = compras.stream()
	    												.collect(Collectors.groupingBy(
	    														Compra::getPurchaseDate,
	    														Collectors.mapping(Compra::getPurchase, Collectors.toList())
	    														));
	    
	    //Creamos un segundo Map auxiliar que a cada lista valor del map la reduzca a un valor, el m·ximo
	    Map<LocalDateTime, Purchase> aux2 = aux.entrySet().stream()
			    									   	  .collect(Collectors.toMap(
			    									   			  Map.Entry::getKey,
			    									   			  c -> c.getValue().stream().collect(Collectors.maxBy(comp)).orElse(null)
			    									   			  ));
			    
	    //Devolvemos solo la clave asociada al valor mayor
	    return aux2.entrySet()
	    		   .stream()
	    		   .max(Map.Entry.comparingByValue(comp))
	    		   .map(Map.Entry::getKey)
	    		   .orElse(null);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

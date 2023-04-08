package fp.tipos;

import java.util.Collection;

public interface Compras {

	/**
	 * @return El número de compras almacenado en el objeto Compras.
	 */
	Integer getNumElem();

	/**
	 * @param c compra
	 * Añade una compra al objeto
	 */
	void agregarElem(Compra c);
	
	/**
	 * @param c Colección con objetos tipo Compra
	 * Añade una colección al objeto
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
	
	

}
package fp.tipos.test;

import fp.common.TypeCountry;
import fp.tipos.Compra;
import fp.tipos.Compras;
import fp.tipos.FactoriaCompras;

public class TestCompras {

	public static void main(String[] args) {
		Compras compras = FactoriaCompras.leerCompras("data/DatosProyecto.csv");
		
		//Test del objeto Compras
		testObjetoCompras(compras);
		
		//Test de la Funcion 1
		System.out.println("\nTest de la Funcion 1: clienteCompraMenosDe");
		testFuncion1(compras, 15165, 3);
		testFuncion1(compras, 15165, 1);
		
		//Test de la Funcion 2
		System.out.println("\nTest de la Funcion 2: numComprasPorCliente");
		testFuncion2(compras, 15165);
		testFuncion2(compras, 17511);
		
		//Test de la Funcion 3
		System.out.println("\nTest de la Funcion 3: encuentraComprasMayoresPorPais");
		testFuncion3(compras, TypeCountry.UNITED_KINGDOM, 260.0);
		testFuncion3(compras, TypeCountry.GERMANY, 235.0);
		
		//Test de la Funcion 4
		System.out.println("\nTest de la Funcion 4: agrupaKeywordsPorPais");
		testFuncion4(compras);
		
		//Test de la Funcion 5
		System.out.println("\nTest de la Funcion 5: cuentaGastoPorCliente");
		testFuncion5(compras);
	
	}

	private static void testObjetoCompras(Compras compras) {
		System.out.println("-------------------- testObjetoCompras --------------------");
		System.out.println("- Todas las compras: " + compras.getCompras());
		System.out.println("- Numero de elementos leidos: " + compras.getNumElem());
		
		System.out.println("- Se agregan y se eliminan los objetos Compra:");
		System.out.println("\t- Ultimo elemento antes de agregar: " + compras.getCompras().get(compras.getNumElem()-1));
		
		Compra c = new Compra("Por defecto", 12345, true);
		compras.agregarElem(c);
		
		System.out.println("\t- Ultimo elemento tras agregar: " + compras.getCompras().get(compras.getNumElem() - 1));
		
		compras.eliminarElem(compras.getNumElem() - 1);
		
		System.out.println("\t- Ultimo elemento tras eliminar: " + compras.getCompras().get(compras.getNumElem() - 1));
	}
	
	private static void testFuncion1(Compras compras, Integer customerId, Integer n) {
		System.out.println(compras.clienteCompraMenosDe(customerId, n));
	}
	
	private static void testFuncion2(Compras compras, Integer customerId) {
		System.out.println(compras.numComprasPorCliente(customerId));
	}
	
	private static void testFuncion3(Compras compras, TypeCountry country, Double n) {
		System.out.println(compras.encuentraComprasMayoresPorPais(country, n));
	}
	
	private static void testFuncion4(Compras compras) {
		System.out.println(compras.agrupaKeywordsPorPais());
	}
	
	private static void testFuncion5(Compras compras) {
		System.out.println(compras.cuentaGastoPorCliente());
	}
	
}
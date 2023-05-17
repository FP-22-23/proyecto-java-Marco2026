package fp.tipos.test;

import fp.common.TypeCountry;
import fp.tipos.Compra;
import fp.tipos.Compras;
import fp.tipos.FactoriaCompras;

public class TestCompras {

	public static void main(String[] args) {
		
		try {
			
			//Entrega 2
			System.out.println("\n========== Entrega 2 ==========\n");
			//Lista de Compras
			Compras compras = FactoriaCompras.leerCompras("data/DatosProyecto.csv");
			
			//Test del objeto Compras
			testObjetoCompras(compras);
			
			//Test de la Funcion 1
			System.out.println("\nTest de la Funcion 1: clienteCompraMenosDe");
			testClienteCompraMenosDe(compras, 15165, 3);
			testClienteCompraMenosDe(compras, 15165, 1);
			
			//Test de la Funcion 2
			System.out.println("\nTest de la Funcion 2: numComprasPorCliente");
			testNumComprasPorCliente(compras, 15165);
			testNumComprasPorCliente(compras, 17511);
			
			//Test de la Funcion 3
			System.out.println("\nTest de la Funcion 3: encuentraComprasMayoresPorPais");
			testEncuentraComprasMayoresPorPais(compras, TypeCountry.UNITED_KINGDOM, 260.0);
			testEncuentraComprasMayoresPorPais(compras, TypeCountry.GERMANY, 235.0);
			
			//Test de la Funcion 4
			System.out.println("\nTest de la Funcion 4: agrupaKeywordsPorPais");
			testAgrupaKeywordsPorPais(compras);
			
			//Test de la Funcion 5
			System.out.println("\nTest de la Funcion 5: cuentaGastoPorCliente");
			testCuentaGastoPorCliente(compras);
			
			
			//Entrega 3
			System.out.println("\n========== Entrega 3 ==========\n");
			//Test de la Funcion 1
			System.out.println("\nTest de la Funcion 1: clienteCompraMenosDeStream");
			testClienteCompraMenosDeStream(compras, 15165, 3);
			testClienteCompraMenosDeStream(compras, 15165, 1);
			
			//Test de la Funcion 2
			System.out.println("\nTest de la Funcion 2: numComprasPorClienteStream");
			testNumComprasPorClienteStream(compras, 15165);
			testNumComprasPorClienteStream(compras, 17511);
			
			//Test de la Funcion 3
			System.out.println("\nTest de la Funcion 3: encuentraComprasMayoresPorPaisStream");
			testEncuentraComprasMayoresPorPaisStream(compras, TypeCountry.UNITED_KINGDOM, 260.0);
			testEncuentraComprasMayoresPorPaisStream(compras, TypeCountry.GERMANY, 235.0);
			
			//Test de la Funcion 4
			System.out.println("\nTest de la Funcion 4: getCompraMayorPorCliente");
			testGetCompraMayorPorCliente(compras, 17511);
			
			//Test de la Funcion 5
			System.out.println("\nTest de la Funcion 5: getIdClientesPorPaisOrdenados");
			testGetIdClientesPorPaisOrdenados(compras, TypeCountry.OTHER);
			
			//Test de la Funcion 6
			System.out.println("\nTest de la Funcion 6: agrupaKeywordsPorPaisStream");
			testAgrupaKeywordsPorPaisStream(compras);
			
			//Test de la Funcion 7
			System.out.println("\nTest de la Funcion 7: getCompraMasCaraPorFecha");
			testGetCompraMasCaraPorFecha(compras);
			
			//Test de la Funcion 8
			System.out.println("\nTest de la Funcion 8: getCompraMasBarataPorCliente");
			testGetCompraMasBarataPorCliente(compras);
			
			//Test de la Funcion 9
			System.out.println("\nTest de la Funcion 9: getNDescripcionesMasCortasPorPais");
			testGetNDescripcionesMasCortasPorPais(compras, 2);
			
			//Test de la Funcion 10
			System.out.println("\nTest de la Funcion 10: compraMasCaraPorHora");
			testCompraMasCaraPorHora(compras);
			
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}

	private static void testObjetoCompras(Compras compras) {
		
		try {
			
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
			
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testClienteCompraMenosDe(Compras compras, Integer customerId, Integer n) {
		try {
			System.out.println(compras.clienteCompraMenosDe(customerId, n));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testNumComprasPorCliente(Compras compras, Integer customerId) {
		try {
			System.out.println(compras.numComprasPorCliente(customerId));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
		
	}
	
	private static void testEncuentraComprasMayoresPorPais(Compras compras, TypeCountry country, Double n) {
		try {
			System.out.println(compras.encuentraComprasMayoresPorPais(country, n));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testAgrupaKeywordsPorPais(Compras compras) {
		try {
			System.out.println(compras.agrupaKeywordsPorPais());
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testCuentaGastoPorCliente(Compras compras) {
		try {
			System.out.println(compras.cuentaGastoPorCliente());
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	//Entrega 3
	private static void testClienteCompraMenosDeStream(Compras compras, Integer customerId, Integer n) {
		try {
			System.out.println(compras.clienteCompraMenosDeStream(customerId, n));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testNumComprasPorClienteStream(Compras compras, Integer customerId) {
		try {
			System.out.println(compras.numComprasPorClienteStream(customerId));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testEncuentraComprasMayoresPorPaisStream(Compras compras, TypeCountry country, Double n) {
		try {
			System.out.println(compras.encuentraComprasMayoresPorPaisStream(country, n));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testGetCompraMayorPorCliente(Compras compras, Integer customerId) {
		try {
			System.out.println(compras.getCompraMayorPorCliente(customerId));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testGetIdClientesPorPaisOrdenados(Compras compras, TypeCountry country) {
		try {
			System.out.println(compras.getIdClientesPorPaisOrdenados(country));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testAgrupaKeywordsPorPaisStream(Compras compras) {
		try {
			System.out.println(compras.agrupaKeywordsPorPaisStream());
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testGetCompraMasCaraPorFecha(Compras compras) {
		try {
			System.out.println(compras.getCompraMasCaraPorFecha());
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testGetCompraMasBarataPorCliente(Compras compras) {
		try {
			System.out.println(compras.getCompraMasBarataPorCliente());
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testGetNDescripcionesMasCortasPorPais(Compras compras, Integer n) {
		try {
			System.out.println(compras.getNDescripcionesMasCortasPorPais(n));
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
	private static void testCompraMasCaraPorHora(Compras compras) {
		try {
			System.out.println(compras.compraMasCaraPorHora());
		} catch(IllegalArgumentException iae) {
			System.out.println("Capturada excepción esperada: " + iae.getMessage());
		}
	}
	
}
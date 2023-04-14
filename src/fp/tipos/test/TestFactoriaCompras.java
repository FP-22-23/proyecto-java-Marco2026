package fp.tipos.test;

import fp.tipos.Compras;
import fp.tipos.FactoriaCompras;


public class TestFactoriaCompras {

	public static void main(String[] args) {
		
		testLeerCompras("data/DatosProyecto.csv");
		
	}

	private static void testLeerCompras(String fichero) {
		try {
			System.out.println("\n-------------------- TestLeerCompras ---------------------------");
			Compras compras = FactoriaCompras.leerCompras(fichero);
			System.out.println("Compras: "+ compras);
		} catch(Exception e) {
			System.out.println("Capturada excepción esperada: " + e.getMessage());
		}
	}
	
}

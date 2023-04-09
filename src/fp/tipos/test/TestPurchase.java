package fp.tipos.test;

import fp.common.Purchase;

public class TestPurchase {

	public static void main(String[] args) {
		
		testPurchase();

	}

	private static void testPurchase() {
		//Constructor del record
		Purchase p1 = new Purchase(6, 25.5);
		Purchase p2 = new Purchase(5, 33.9);
		
		System.out.println("Todos los métodos del tipo auxiliar Purchase: ");
		System.out.println("- Cantidad: " + p1.quantity());
		System.out.println("- Precio por unidad: " + p1.unitPrice() + "\n");
		System.out.println("Gasto total p1: " + p1.getTotalPurchase());
		System.out.println("Gasto total p2: " + p2.getTotalPurchase());
		System.out.println("\n¿Son iguales p1 y p2?: " + p1.equals(p2));
	}
}

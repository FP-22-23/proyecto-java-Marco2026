package fp.tipos.test;

import java.time.LocalDateTime;

import fp.common.Purchase;
import fp.common.TypeCountry;
import fp.tipos.Compra;

public class TestCompra {

	public static void main(String[] args) {
		//Creación de objetos
		
		////Tipo Auxiliar Purchase
		Purchase p1 = new Purchase(6, 25.5);
		Purchase p2 = new Purchase(6, 33.9);
		System.out.println("Todos los métodos del tipo auxiliar Purchase: ");
		System.out.println("- Cantidad: " + p1.quantity());
		System.out.println("- Precio por unidad: " + p1.unitPrice());
		System.out.println("-----------------------------------------------------------------------");
		
		////Constructor 1
		Compra c1 = new Compra("85123A", "WHITE HANGING HEART T-LIGHT HOLDER", p1, LocalDateTime.of(2010,1,12,8,26), 17850, TypeCountry.UNITED_KINGDOM, true);
		////Constructor 2
		Compra c2 = new Compra("WHITE METAL LANTERN", 17850, false);
		
		System.out.println("Todos los metodos get realizados en el Objeto Compra: ");
		System.out.println("\n- Código de Stock: " + c1.getStockCode());
		System.out.println("- Descripcion: " + c1.getDescription());
		System.out.println("- Compra: " + c1.getPurchase());
		System.out.println("- Fecha de la compra: " + c1.getPurchaseDate());
		System.out.println("- ID del comprador: " + c1.getCustomerId());
		System.out.println("- Pais del comprador: " + c1.getCountry());
		System.out.println("- Satisfecho: " + c1.getSatisfied() + "\n");
		System.out.println("Objeto c1: " + c1.toString() + "\n");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Todos los metodos set realizados en el Objeto Compra: ");
		System.out.println("Objeto c2 antes: " + c2.toString() + "\n");
		System.out.println("Codigo de Stock antes: " + c2.getStockCode());
		c2.setStockCode("29472J");
		System.out.println("Codigo de Stock despues: " + c2.getStockCode() + "\n");
		System.out.println("Satisfecho antes: " + c2.getSatisfied());
		c2.setSatisfied(!c2.getSatisfied());
		System.out.println("Satisfecho despues: " + c2.getSatisfied() + "\n");
		System.out.println("Fecha de compra antes: " + c2.getPurchaseDate());
		c2.setPurchaseDate(LocalDateTime.of(1999, 2, 13, 8, 30));
		System.out.println("Fecha de compra despues: " + c2.getPurchaseDate() + "\n");
		System.out.println("ID del comprador antes: " + c2.getCustomerId());
		c2.setCustomerId(50394);
		System.out.println("ID del comprador despues: " + c2.getCustomerId() + "\n");
		System.out.println("Objeto c2 despues: " + c2.toString() + "\n");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Propiedades derivadas: ");
		System.out.println("Encuestas al comprador 1 y 2:\n" + c1.getSurvey() + "\n" + c2.getSurvey() + "\n");
		System.out.println("Tasas a pagar segun el pais de comprador 1 y 2:\n" + c1.getFee() + "\n" + c2.getFee() + "\n");
		System.out.println("Precio final a pagar por los compradores 1 y 2:\n" + c1.getFinalPrice() + "\n" + c2.getFinalPrice() + "\n");
		System.out.println("Palabras clave de las descripciones de los productos comprados por los compradores 1 y 2:\n" + c1.getKeywords() + "\n" + c2.getKeywords());
		
		
	}

}

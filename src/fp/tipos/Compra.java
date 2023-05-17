package fp.tipos;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import fp.common.Purchase;
import fp.common.TypeCountry;
import fp.utiles.Checkers;

public class Compra implements Comparable<Compra>{
	//Atributos
	//Entrega 1
	private String stockCode; //Consultable y Modificable
	private String description; //Consultable
	private Purchase purchase; //Consultable
	private LocalDateTime purchaseDate; //Consultable y Modificable
	private Integer customerId; //Consultable y Modificable
	private TypeCountry country; //Consultable
	private Boolean satisfied; //Consultable y Modificable
	
	//Constructores
	//Entrega 1
	
	//Constructor con todos los parametros
	public Compra(String stockCode, String description, Purchase purchase, LocalDateTime purchaseDate, 
				  Integer customerId, TypeCountry country, Boolean satisfied) {
		setStockCode(stockCode);
		this.description = description;
		this.purchase = purchase;
		setPurchaseDate(purchaseDate);
		setCustomerId(customerId);
		this.country = country;
		setSatisfied(satisfied);
	}

	//Constructor con los parametros description, customerId, satisfied
	public Compra(String description, Integer customerId, Boolean satisfied) {
		this.stockCode = "000000";
		this.description = description;
		purchase = new Purchase(1, 1.0);
		this.purchaseDate = LocalDateTime.of(2020, 1, 1, 12, 00);
		this.customerId = customerId;
		this.country = TypeCountry.OTHER;
		this.satisfied = satisfied;
	}
	
	//getters and setters
	//Entrega 1
	public String getStockCode() {
		return stockCode;
	}

	public String getDescription() {
		return description;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public TypeCountry getCountry() {
		return country;
	}

	public Boolean getSatisfied() {
		return satisfied;
	}

	public void setStockCode(String stockCode) {
		Checkers.check("El codigo de stock no contiene el numero de caracteres correcto (<=7)", stockCode.length() <= 7);
		this.stockCode = stockCode;
	}

	public void setSatisfied(Boolean satisfied) {
		Checkers.checkNoNull("Satisfied no puede tomar el valor null",satisfied);
		this.satisfied = satisfied;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		Checkers.check("La fecha no es correcta", purchaseDate.isBefore(LocalDateTime.now()));
		this.purchaseDate = purchaseDate;
	}

	public void setCustomerId(Integer customerId) {
		Checkers.check("El ID del comprador debe tener cinco numeros", String.valueOf(customerId).length() == 5);
		this.customerId = customerId;
	}

	//derivadas
	//Entrega 1
	public String getSurvey() { //Devuelve la descripción del producto junto con el grado de satisfacción(como una encuesta (survey) al usuario)
		String res = "El cliente no está satisfecho";
		if(satisfied == true) {
			res = "El cliente está satisfecho";
		}
		return "La descripcion del producto: " + getDescription() + ". Satisfecho: " + res;
	}
	
	public Double getFee() {
		//Cuantas tasas hay que pagar según tu país correspondiente
		Double res;
		switch(country) {
			case GERMANY:
				res = 1.5;
				break;
			case AUSTRALIA:
				res = 2.65;
				break;
			case EIRE:
				res = 1.1;
				break;
			case FRANCE:
				res = 0.7;
				break;
			case UNITED_KINGDOM:
				res = 0.5;
				break;
			case NORWAY:case NETHERLANDS:
				res = 1.2;
				break;
			case OTHER:default:
				res = 3.0;			
		}
		return res;
	}

	public Double getFinalPrice() {
		//Nos da el precio final de la compra, multiplicando el total de la compra sin impuestos por las tasas
		return purchase.getTotalPurchase() + this.getFee();
	}

	//Representacion como cadena
	public String toString() {
		return "Compra [stockCode = " + getStockCode() + ", Description = " + getDescription() + ", purchase = " + "(" + "quantity = " + 
						purchase.quantity() + ", " + "unitPrice = " +  purchase.unitPrice() +")" + ", purchaseDate = " + getPurchaseDate() +
						", customerId = " + getCustomerId() + ", country = " + getCountry()	+ ", satisfied = " + getSatisfied() + "]";
	}
	
	public SortedSet<String> getKeywords(){
		//La propiedad derivada getKeywords recoge las palabras clave de la descripcion basandose en su longitud.
		SortedSet<String> keywords = new TreeSet<>();
		String splitDescription [] = description.split(" "); 
		for(String p:splitDescription) {
			p = p.trim();
			if(p.length() >= 4) {
				keywords.add(p.trim());	
			}
		}
		return keywords;
	}
	
	//Criterios de igualdad hashCode y equals
	public int hashCode() {
		return Objects.hash(country, customerId, description, purchaseDate, satisfied, stockCode);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return country == other.country && Objects.equals(customerId, other.customerId)
				&& Objects.equals(description, other.description) && Objects.equals(purchaseDate, other.purchaseDate)
				&& Objects.equals(satisfied, other.satisfied) && Objects.equals(stockCode, other.stockCode);
	}

	//Criterio de Orden natural
	public int compareTo(Compra c) {
		int res = getStockCode().compareTo(c.getStockCode());
		if(res == 0) {
			res = getDescription().compareTo(c.getDescription());
			if(res == 0) {
				res = getPurchaseDate().compareTo(c.getPurchaseDate());
				if(res == 0) {
					res = getCustomerId().compareTo(c.getCustomerId());
					if(res == 0) {
						res = getCountry().compareTo(c.getCountry());
						if(res == 0) {
							res = getSatisfied().compareTo(c.getSatisfied());
						}
					}
				}
			}
		}
		return res;
	}
	
}

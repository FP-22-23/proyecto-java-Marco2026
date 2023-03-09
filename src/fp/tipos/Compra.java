package fp.tipos;

import java.time.LocalDateTime;
import fp.common.Purchase;
import fp.common.TypeCountry;

public class Compra {
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
	public Compra(String stockCode, String description, Purchase purchase, LocalDateTime purchaseDate, 
				  Integer customerId, TypeCountry country, Boolean satisfied) {
		this.stockCode = stockCode;
		this.description = description;
		this.purchase = purchase;
		this.purchaseDate = purchaseDate;
		this.customerId = customerId;
		this.country = country;
		this.satisfied = satisfied;
	}

	public Compra(String description, Integer customerId, Boolean satisfied) {
		this.stockCode = "SIN CODIGO";
		this.description = description;
		this.purchase = null;
		this.purchaseDate = null;
		this.customerId = customerId;
		this.country = TypeCountry.SIN_DATOS;
		this.satisfied = satisfied;
	}
	
	//getters and setters
	//Entrega 1
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
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

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public TypeCountry getCountry() {
		return country;
	}

	public Boolean getSatisfied() {
		return satisfied;
	}

	public void setSatisfied(Boolean satisfied) {
		this.satisfied = satisfied;
	}
	
	//derivadas
	//Entrega 1
	
	
}

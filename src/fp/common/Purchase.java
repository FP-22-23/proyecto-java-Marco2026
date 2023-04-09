package fp.common;

public record Purchase(Integer quantity, Double unitPrice) {
	
	public Double getTotalPurchase() {
		return quantity * unitPrice;
	}
	
	
}

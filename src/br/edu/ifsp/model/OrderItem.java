package br.edu.ifsp.model;

public class OrderItem implements IModel {

	private Order order;
	
	private Product product;
	
	private int quantity;
	
	private float unityPrice;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnityPrice() {
		return unityPrice;
	}

	public void setUnityPrice(float unityPrice) {
		this.unityPrice = unityPrice;
	}
}

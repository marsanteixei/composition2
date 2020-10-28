package entities;

public class OrderItem {
	private static int cont = 1;
	private int id;
	private Integer quantity;
	private Product product;
	private double price;

	public OrderItem() {

	}

	public OrderItem(Integer quantity, double price, Product product) {
		this.id = cont++;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getId() {
		return id;
	}

	public double subTotal() {
		return (quantity * price);
	}

}

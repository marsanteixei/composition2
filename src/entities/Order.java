package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumeration.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH/mm/ss");
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMomente() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void addItem(OrderItem item) {
		orderItem.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}

	public OrderItem SearchFor(Integer id) {
		for (OrderItem it : orderItem) {
			if (it.getId().equals(id)) {
				return it;
			}
		}
		return null;
	}

	public double total() {
		double t = 0;
		for (OrderItem it : orderItem) {
			t += it.subTotal();
		}
		return t;
	}

	public boolean idVerification(int id) {
		for (OrderItem it : orderItem) {
			if (it.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment : ");
		sb.append(sdf1.format(moment) + "\n");
		sb.append("Orde status : ");
		sb.append(status + "\n");
		sb.append("Client : ");
		sb.append(client.getName() + " ");
		sb.append(sdf.format(client.getBirthDate()) + " - ");
		sb.append(client.getEmail() + "\n");
		sb.append("ORDER ITEM: \n");
		for (OrderItem it : orderItem) {
			sb.append("ID : ");
			sb.append(it.getId() + " -- ");
			sb.append(it.getProduct().getName() + " -- ");
			sb.append("$ ");
			sb.append(it.getPrice() + ",");
			sb.append("quantity : ");
			sb.append(it.getQuantity() + ",");
			sb.append("Subtotal : ");
			sb.append("$ ");
			sb.append(it.subTotal());
			sb.append("\n");
		}
		sb.append("Total price : ");
		sb.append("$ ");
		sb.append(total());
		return sb.toString();
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

}

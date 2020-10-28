package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import base.ClientBase;
import base.ProductBase;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enumeration.OrderStatus;

public class Program {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ProductBase pb = new ProductBase();
		ClientBase cb = new ClientBase();
		int check = 0;
		int number = 0;
		do {
			System.out.println("Choose a number:");
			System.out.println("1-to register product");
			System.out.println("2-for client registration");
			System.out.println("3-to login");
			System.out.println("-------------------------------------");
			check = sc.nextInt();
			sc.nextLine();
			switch (check) {
			case 1:
				Product p = RegisterProd();
				pb.addProduct(p);
				break;
			case 2:
				Client c = RegisterClient();
				cb.addClient(c);
				break;
			}
		} while (check != 3);
		boolean login;
		do {
			System.out.println("Logging in");
			System.out.println("------------------------------------");
			System.out.println("enter an id");
			String id = sc.nextLine();
			System.out.println("enter password");
			String pass = sc.nextLine();
			login = cb.searchFor(id, pass);
			if (cb.searchFor(id, pass)) {
				Client client = cb.getClient(id);
				Date moment = new Date();
				Order order = new Order(moment, OrderStatus.NULL_ORDER, client);
				System.out.println("Wellcome " + client.getName());
				do {
					System.out.println("Choose a number:");
					System.out.println("1- to show available products:");
					System.out.println("2- to choose products:");
					System.out.println("3- to remove item:");
					System.out.println("4- to make payment:");
					System.out.println("5- to check order");
					System.out.println("6- to get out");
					System.out.println("---------------------------------------");
					number = sc.nextInt();
					switch (number) {
					case 1:
						System.out.println(pb);
						break;
					case 2:
						sc.nextLine();
						System.out.println("enter an product id :");
						String idProduct = sc.nextLine();
						if (pb.idVerification(idProduct)) {
							System.out.println("enter the quantity to buy :");
							int quant = sc.nextInt();
							Product p = pb.selectProduct(idProduct);
							OrderItem item = new OrderItem(quant, p.getPrice(), p);
							order.setStatus(OrderStatus.PENDING_PAYMENT);
							order.addItem(item);
							System.out.println("sub total - " + item.subTotal());
							System.out.println("Total Order - " + order.total());
							System.out.println("--------------------------------------------");
						} else
							System.out.println("product id not found, enter a valid id");
						break;
					case 3:
						System.out.println("enter an item id :");
						sc.nextLine();
						Integer idRemove = sc.nextInt();
						if (order.idVerification(idRemove)) {
							OrderItem i = order.SearchFor(idRemove);
							order.removeItem(i);
							System.out.println("Total Order - " + order.total());
						} else
							System.out.println("item id not found, enter a valid id");
						break;
					case 4:
						if (order.getStatus().equals(OrderStatus.PENDING_PAYMENT)) {
							System.out.println("the total order amount - " + order.total());
							System.out.println("enter the payment card number :");
							sc.nextLine();
							String card = sc.nextLine();
							if (client.validatePayment(card)) {
								order.setStatus(OrderStatus.MADE_PAYMENT);
								System.out.println("payment made");
								System.out.println("-----------------------------------------------");
								System.out.println(order);
								order.getOrderItem().clear();
								order.setStatus(OrderStatus.NULL_ORDER);
							} else {
								System.out.println("data doesn't match");
							}
						} else
							System.out.println("you have no payment to make");
						break;
					case 5:
						System.out.println(order);
						System.out.println("--------------------------------------");
						break;
					}
				} while (number != 6);
				System.out.println("Thank you for your business!");
			} else
				System.out.println("login error");
		} while (login == false);
	}

	public static Product RegisterProd() {
		System.out.println("enter the product id :");
		String id = sc.nextLine();
		System.out.println("enter the product name :");
		String name = sc.nextLine();
		System.out.println("enter the price :");
		double price = sc.nextDouble();
		Product p = new Product(id, name, price);
		return (p);
	}

	public static Client RegisterClient() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("enter the client id :");
		String id = sc.nextLine();
		System.out.println("enter the client name :");
		String name = sc.nextLine();
		System.out.println("register password :");
		String pass = sc.nextLine();
		System.out.println("enter email :");
		String email = sc.nextLine();
		System.out.println("payment method - enter as the credit card number :");
		String card = sc.nextLine();
		System.out.println("enter the birthday format DD/MM/YYYY :");
		Date data = sdf.parse(sc.next());

		Client c = new Client(id, name, pass, email, data, card);
		return (c);
	}

}

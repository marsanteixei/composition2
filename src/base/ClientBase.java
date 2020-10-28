package base;

import java.util.ArrayList;
import java.util.List;

import entities.Client;

public class ClientBase {
	List<Client> list = new ArrayList<>();

	public ClientBase() {

	}

	public List<Client> getList() {
		return list;
	}

	public void addClient(Client client) {
		list.add(client);
	}

	public void removeCliente(Client client) {
		list.remove(client);
	}

	public void showClient() {
		System.out.println("Client Base: \n");
		for (Client it : list) {
			System.out.println("Client id - " + it.getId() + " :");
			System.out.println(it.getName());
			System.out.println(it.getEmail());
			System.out.println(it.getBirthDate());
		}
	}

	public boolean searchFor(String id, String password) {
		for (Client it : list) {
			if (it.getId().equals(id) && it.getPassword().equals(password)) {
				return true;
			}
		}
		return false;

	}

	public Client getClient(String id) {
		for (Client it : list) {
			if (it.getId().equals(id)) {
				return it;
			}
		}
		return null;
	}

}

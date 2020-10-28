package base;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductBase {
	List<Product> list = new ArrayList<>();

	public ProductBase() {

	}

	public List<Product> getList() {
		return list;
	}

	public void addProduct(Product product) {
		list.add(product);
	}

	public void removeProduct(Product product) {
		list.remove(product);
	}

	public Product selectProduct(String id) {
		for (Product it : list) {
			if (it.getId().equals(id)) {
				return it;
			}
		}
		return null;
	}

	public boolean idVerification(String id) {
		for (Product it : list) {
			if (it.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Product Base: [Description=" + list + "]";
	}

}

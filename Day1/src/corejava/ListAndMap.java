package corejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndMap {

	
	public static void main(String[] args) {
		
		// List (ordered collection of products)
		List<Product> products = new ArrayList<>();
		products.add(new Product("Shirt", 500.0));
		products.add(new Product("Hat", 150.0));

		//  (assuming order is preserved)
		Product firstProduct = products.get(0); // Shirt

		System.out.println("Accessing product by index. First Product : "+ firstProduct);
		
		// Map (key-value pairs for customer information)
		Map<String, String> customer = new HashMap<>();
		customer.put("name", "Harsh");
		customer.put("email", "patidar@gmail.com");

		// Accessing customer information by key
		String customerName = customer.get("name");

		System.out.println("Customer Name : "+ customerName);
	}
	
}

class Product{
	
	private String productName;
	private double price;
	
	public Product(String productName, double price) {
		super();
		this.productName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + "]";
	}
	
	
	
}

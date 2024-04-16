package corejava;

import java.util.ArrayList;
import java.util.List;


class Customer{
	
	private String name;
	private ShoppingCart cart;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Customer(String name, ShoppingCart cart) {
		super();
		this.name = name;
		this.cart = cart;
	}
	
	public ShoppingCart getCartCopy() {
		return new ShoppingCart(this.cart); //Deep copy
	}
}

class Items{
	private String name;
	private Integer numberOfitem;
	private Double price;
	
	
	public Items(String name, Integer numberOfitem, Double price) {
		super();
		this.name = name;
		this.numberOfitem = numberOfitem;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfitem() {
		return numberOfitem;
	}
	public void setNumberOfitem(Integer numberOfitem) {
		this.numberOfitem = numberOfitem;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Items [name=" + name + ", numberOfitem=" + numberOfitem + ", price=" + price + "]";
	}
}

class ShoppingCart{
	
	List<Items> items ;
	
	public ShoppingCart() {
		items = new ArrayList<Items>();
	}
	
	public ShoppingCart(ShoppingCart cart) { // copy constructor
		items = new ArrayList<Items>(cart.items);
	}
	
    //Methods to add/remove/print items to the cart
	public String addToCart(Items item) {
		items.add(item);
		return item+" added to cart!";
	}
	
	public String deleteFromCart(Items item) {
		items.remove(item);
		return item+" removed from cart!";
	}
	
	public void printItems() {
		items.forEach(System.out::println);
	}
}


public class CopyConstructor {
	
	// OrderProcessing
	
	public static void processOrder(Customer customer) {
		
		ShoppingCart copyCart = customer .getCartCopy();
		
		System.out.println("The Final Items : "+ copyCart.items);
		
		//process further 
	}
	
	public static void main(String[] args) {
		
		ShoppingCart sCart = new ShoppingCart();
		
		Customer cust1 = new Customer("Harsh", sCart);
		
		//customer can add items to the cart through various methods
		
		//Final order processing
		processOrder(cust1);
		
		System.out.println("sCart : "+sCart);
		System.out.println("cust1.shoppingcart : "+cust1.getCartCopy());
		
		
		ShoppingCart sCart2 = new ShoppingCart();
		Customer customer1 = new Customer("Mohit", sCart2);
		sCart2.addToCart(new Items("Shirt", 2, 1000.0));
		
		Customer customer1Friend = new Customer("Mahesh", sCart2);
		sCart2.addToCart(new Items("Mobile", 1, 10000.0));
		
		System.out.println();
		customer1.getCart().printItems();
	}
	
	
	

	/*
	 * int a;
	 * 
	 * public CopyConstructor(int a){ this.a = a; }
	 * 
	 * public CopyConstructor(CopyConstructor con) { this.a = con.a; }
	 * 
	 * public final void method() {
	 * System.err.println("Overridden method of CopyConstructor class"); }
	 * 
	 * public void method(int a) {
	 * System.err.println("Overloading method of CopyConstructor class"); }
	 * 
	 * public static void main(String[] args) { CopyConstructor con = new
	 * CopyConstructor(110);
	 * 
	 * CopyConstructor con2 = new CopyConstructor(con);
	 * 
	 * System.out.println(con2.a); }
	 */	
	
}





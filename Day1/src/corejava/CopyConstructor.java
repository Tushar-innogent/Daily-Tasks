package corejava;

import java.util.ArrayList;
import java.util.List;

class Items{
	
}
class ShoppingCart{
	
	List<Items> items ;
	
	public ShoppingCart() {
		items = new ArrayList<Items>();
	}
	
	public ShoppingCart(ShoppingCart cart) { // copy constructor
		items = new ArrayList<Items>(cart.items);
	}
	
    //Methods to add/remove items to the cart
	
	
}

class Customer{
	
	private String name;
	private ShoppingCart cart;
	
	public Customer(String name, ShoppingCart cart) {
		super();
		this.name = name;
		this.cart = cart;
	}
	
	public ShoppingCart getCartCopy() {
		return new ShoppingCart(this.cart);
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
		
		Customer cust1 = new Customer("Harsh", new ShoppingCart());
		
		//customer can add items to the cart through various methods
		
		//Final order processing
		processOrder(cust1);
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





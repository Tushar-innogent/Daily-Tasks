package corejava;

public class Polymorphism extends CopyConstructor {
	
	//Constructor using super
	public Polymorphism(){
		super(new CopyConstructor(7));
	}
	
	/*
	 * public void method() {
	 * System.err.println("Overridding method of Polymorphism class"); }
	 */	
	
	public void method(int a) {
		System.err.println("Parameterized Overloading method of Polymorphism class");
	}
	
	public static void main(String[] args) {
		
		Polymorphism mObj = new Polymorphism();
		mObj.method();
	}
	
}

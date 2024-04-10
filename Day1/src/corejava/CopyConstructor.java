package corejava;

public class CopyConstructor {

	int a;
	
	public CopyConstructor(int a){
		this.a = a;
	}
	
	public CopyConstructor(CopyConstructor con) {
		this.a = con.a;
	}
	
	public final void method() {
		System.err.println("Overridden method of CopyConstructor class");
	}
	
	public void method(int a) {
		System.err.println("Overloading method of CopyConstructor class");
	}
	
	public static void main(String[] args) {
		CopyConstructor con = new CopyConstructor(110);
		
		CopyConstructor con2 = new CopyConstructor(con);
		
		System.out.println(con2.a);
	}
	
	public static void main(String[] args, int a) {
		
	}
}

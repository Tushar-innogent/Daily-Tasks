package solidPrinciples;

public class LiskovSubstitution {

	
}

interface Animal{
	
	void flyingAnimal();
	
	void makesSound();
}

class Bird implements Animal{
	
	public void flyingAnimal() {
		
	}

	public void makesSound() {
		
	}
}


//class Dog implements Animal{
//	
//	public void flyingAnimal() {
//		
//	}
//
//	public void makesSound() {
//		
//	}
//}

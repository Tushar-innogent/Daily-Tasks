package solidPrinciples;

public class OpenClose {

}

interface Shape{
	
	double areaOfShape();
	
	String colorOfShape();
}

class Square implements Shape{

	@Override
	public double areaOfShape() {
		int side = 4;
		double area = side*side;
		return area;
	}

	@Override
	public String colorOfShape() {
		// TODO Auto-generated method stub
		return "Red";
	}
	
}
class Circle implements Shape{
	
	@Override
	public double areaOfShape() {
		int radius = 4;
		double area = Math.PI * Math.sqrt(radius);
		return area;
	}
	
	@Override
	public String colorOfShape() {
		// TODO Auto-generated method stub
		return "Orange";
	}
	
}

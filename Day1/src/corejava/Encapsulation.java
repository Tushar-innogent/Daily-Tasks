package corejava;

public class Encapsulation {

	public static void main(String[] args) {
		
		Circle circle = new Circle();
		
		circle.setRadius(2);
		
		System.out.println("Area of circle with radius 2 is "+circle.getArea());
	}
}

class Circle{
	
	private float radius;
	private double area;
	
	public void setRadius(float radius) {
		if(radius < 2) {
			System.out.println("Take radius greater than 2 for better visualization!");
			return;
		}
		this.radius = radius;
	}
	
	public float getRadius() {
		return radius;
	}
	
//	public void setArea(double area) {
//		this.area = area;
//	}
	
	public double getArea() {
		if(radius == 0.0f) {
			System.out.println("Set the radius to get the area of circle!");
			return 0;
		}
		area = Math.PI * Math.sqrt(radius);
		return area;
	}
}
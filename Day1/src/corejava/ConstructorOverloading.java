package corejava;

public class ConstructorOverloading {

	public static void main(String[] args) {
		
		FurnitureStore bookShelfPreAssembled = new FurnitureStore("Book shelf");
		
		FurnitureStore bookShelfWithTwoShelves = new FurnitureStore("Book shelf", 2);
		
		FurnitureStore bookShelfWithTwoShelvesThreeDoors = new FurnitureStore("Book shelf", 3, 2);
	}
}

class FurnitureStore{
	
	private String bookShelf;
	private int shelves;
	private int doors;
	
	public FurnitureStore(String bookShelf) {
		this.bookShelf = bookShelf;
	}
	public FurnitureStore(String bookShelf, int shelves) {
		this.bookShelf = bookShelf;
		this.shelves = shelves;
	}
	public FurnitureStore(String bookShelf, int shelves, int doors) {
		this.bookShelf = bookShelf;
		this.shelves = shelves;
		this.doors = doors;
	}
}
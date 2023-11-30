package iterator;

public class BooksMain {
	
	public static void main(String[] args) {
		
		Aggregate aggregate = new BookShelf();
		Iterator iterator = (Iterator)aggregate.iterator();
		while (iterator.hashNext()) {
			System.out.println(iterator.next());
		}
		
	}

}

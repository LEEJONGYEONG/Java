package iterator;

public class BookShelf implements Aggregate{
	
	private int[] books = new int[] {1, 2, 3, 4, 5};
	
	public BookShelf() {
	}
	
	public void appenedBook() {
	}
	
	public void getLength() {
	}
	
	@Override
	public Object iterator() {
		return new BookShelfIterator(books);
	}
	
	
	
	
}

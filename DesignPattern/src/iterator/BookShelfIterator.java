package iterator;

public class BookShelfIterator implements Iterator{
	
	int[] books;
	int currIndex;
	
	public BookShelfIterator(int[] books) {
		this.books = books;
	}
	
	@Override
	public boolean hashNext() {
		if (currIndex>4) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Object next() {
		return books[currIndex++];
	}
	
}

package template;

public class AbstractDisplay implements Display {
	
	public void open() {};
	
	public void print() {};
	
	public void close() {};
	
	public void display() {
		open();
		print();
		close();
	};

}

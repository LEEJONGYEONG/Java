package template;

public class ChatDisplay extends AbstractDisplay{
	
	char chr;
	
	ChatDisplay(char chr) {
		this.chr = chr;
	}
	
	public void open() {
		System.out.println("<<");
	}
	
	public void print() {
		System.out.println(chr);
	}
	
	public void close() {
		System.out.println(">>");
	}


}

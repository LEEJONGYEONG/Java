package template;

public abstract class DisplayMain {
	
	public static void main(String[] args) {
		
		AbstractDisplay charDisplay = new ChatDisplay('A');
		AbstractDisplay stringDisplay = new StringDisplay("Hello");
		
		charDisplay.display();
		stringDisplay.display();
	}


	
	
	
}

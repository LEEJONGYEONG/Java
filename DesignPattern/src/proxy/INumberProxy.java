package proxy;

public class INumberProxy implements INum{
	
	private INum inum;
	
	@Override
	public void print(int i) {
		if (i>5) {
			inum = new INumber();
			inum.print(i);
		} else {
			System.out.println(i + "프록시 출력");
		}

	}
	
} // class

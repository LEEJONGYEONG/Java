package adapter;

public class PrintAdapter2 implements Print {

	StringPrinter stringPrinter;
	
	@Override
	public void print() {
		stringPrinter = new StringPrinter();
		stringPrinter.printInfo();
	}
}
// 위임의 방법 (결합도를 낮춘다)
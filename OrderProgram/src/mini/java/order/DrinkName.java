package mini.java.order;

public class DrinkName {

	private String name; 	// 상품의 이름
	private String what; 		// 상품의 설명

	public DrinkName() {
	}

	public DrinkName(String name, String what) {
		super();
		this.name = name;
		this.what = what;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	@Override
	public String toString() {
		return "DrinkName [name=" + name + ", what=" + what + "]";
	}

}

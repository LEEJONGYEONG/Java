package mini.java.order;

public class DrinkSize {

	int big;
	int small;

	public DrinkSize() {
	}

	public DrinkSize(int big, int small) {
		super();
		this.big = big;
		this.small = small;
	}

	public int getBig() {
		return big;
	}

	public void setBig(int big) {
		this.big = big;
	}

	public int getSmall() {
		return small;
	}

	public void setSmall(int small) {
		this.small = small;
	}

	@Override
	public String toString() {
		return "DrinkSize [big=" + big + ", small=" + small + "]";
	}

}

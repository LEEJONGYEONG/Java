package strategy;
//가위바위보의 '전략'을 나타내는 클래스
public interface Strategy {
	
	public abstract Hand nextHand();
	public abstract void study(boolean win);
}

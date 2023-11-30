package strategy;
// 이기면 다음에도 같은손을 내미는 전략을 나타내는 클래스

import java.util.Random;

public class WinningStrategy implements Strategy{
	
	private Random random;
	private boolean won = false;
	private Hand prevHand;
	
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	
	@Override
	public Hand nextHand() {
		if (!won) {
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}
	
	@Override
	public void study(boolean win) {
		won = win;
	}
}



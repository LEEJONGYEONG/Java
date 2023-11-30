package strategy;
// 이기면 다음에도 같은손을 내미는 전략을 나타내는 클래스

import java.util.Random;

public class WinningStrategy implements Strategy{
	
	private Random random;
	private boolean won = false;
	private Hand prevHand;
}

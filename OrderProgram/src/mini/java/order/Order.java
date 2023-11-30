package mini.java.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<DrinkName> basket;
	// DrinkName장바구니로 사용할 basket 생성
	private List<Integer> sizeprice;
	// 사이즈마다 배정된 가격들 정보 저장할 price 생성

	public Order() {
		basket = new ArrayList<>();
		// 장바구니 어레이리스트 생성
		sizeprice = new ArrayList<>();
		// 장바구니 가격 어레이리스트 생성
	}

	public void addBasket(DrinkName menu) {
		ShowSoda showSoda = new ShowSoda();
		menu = showSoda.getDecideSoda();
		basket.add(menu);
		// 장바구니에 추가된 DrinkName형식의 menu의 정보를 basket에 추가
	}

	public void addPrice(int price) {
		sizeprice.add(price);
		// 장바구니에 추가된 가격정보를 int price의 정보를 sizeprice에 추가
	}
	
	public List<DrinkName> getBasket() {
		return basket;
	}

	public List<Integer> getSizeprice() {
		return sizeprice;
	}
	
	public int sumPrice() {
		// 장바구니에 들어간 basketMenu의 가격값의 총합을 구하기
		int sum = 0;
		for(int price : sizeprice) {
			sum += price;
		}
		return sum;
		// sum값을 리턴
	}

	public void clear() {
		basket.clear();
		sizeprice.clear();
		// 장바구니 안에있는 정보 초기화
	}

}

package mini.java.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShowCoffee {

	private List<DrinkName> coffee = new ArrayList<DrinkName>();
	DrinkSize size = new DrinkSize(6, 4);
	Order order = new Order();
	Scanner sc = new Scanner(System.in);

	public ShowCoffee() {

		coffee.add(new DrinkName("Coffee : ", "Black Coffee")); // 블랙커피
		coffee.add(new DrinkName("Cappuccino : ", "Milk Coffee")); // 카푸치노
		coffee.add(new DrinkName("Espresso : ", "Bitter Coffee")); // 에스프레소
		// CoffeeList의 메뉴들
	}
	
	public void showCoffeeList() {
		
		System.out.println("\n" + "[ ***** coffee List ***** ]");
		for (int i = 0; i < coffee.size(); i++) {
			DrinkName drink = coffee.get(i);
			System.out.println((i + 1) + ". " + drink.getName() + drink.getWhat());
			// coffee 리스트에 있는 메뉴들에게 번호 부여
		}
		System.out.println("\n" + "0. Get back menu");
		// 0번 입력시 메뉴로 돌아간다고 출력
		
		System.out.print("\n" + "Number : ");
		int drinkChoice = sc.nextInt();
		// 입력한 상품선택
		if (drinkChoice < 0 && drinkChoice > coffee.size()) {
			System.out.println("\n" + "!!! Wrong number !!!");
			// 다른 번호를 입력하면 잘못된 번호라고 출력
			try {
				Thread.sleep(3000);
				// 안내창 읽을수있도록 시간지연
			} catch (Exception e) {
				e.printStackTrace();
			}
			showCoffeeList();
			// 리스트로 돌아가기
		}
		else if (drinkChoice == 0) {
			ShowMainMenu showMainMenu = new ShowMainMenu();
			showMainMenu.showMain();
			// 0번입력시 메인화면으로 돌아감
		}
		DrinkName decidecoffee = coffee.get(drinkChoice-1);
		// DrinkName 객체에 drinkCoice번째 정보를 대입한다
		System.out.println("\n" + "** | Your choice | " + decidecoffee.getName() + decidecoffee.getWhat() + " | **");
		//고른 음료가 창에뜨고
		System.out.println("\n" + "** | Choose Size | "
				+ "1. Big : " + size.getBig() + "$ | "
				+ "2. Small : " + size.getSmall() + "$ | **");
		System.out.print("\n" + "Number : ");
		// 사이즈를 선택하라는 창이 뜬다
		int sizeChoice = sc.nextInt();
		int decideSize = 0;
		// 결정되는 사이즈 정보를 넣을 decideSize
		if (sizeChoice == 1) {
			decideSize = size.getBig();
			// 1번을 선택하면 Big 사이즈
		}
		else if (sizeChoice == 2) {
			decideSize =  size.getSmall();
			// 2번을 선택하면 Small사이즈
		}
		else {
			System.out.println("\n" + "!!! Wrong number !!!");
			// 그외 번호를 누르면 잘못된 번호라고 출력
			try {
				Thread.sleep(3000);
				// 안내창 읽을수있도록 시간지연
				showCoffeeList();
				// 리스트로 돌아가기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("\n" + "** | Check | "
				+ decidecoffee.getName() + decidecoffee.getWhat()
				+ " | " + decideSize + "$ | **");
		System.out.println("\n" + "Put in your basket?");
		System.out.println("1. Yes 2. No");
		System.out.print("\n" + "Number : ");
		// 선택한것들 보여주고 장바구니에 담을것인지 묻기
		int howBasket = sc.nextInt();
		
		if (howBasket ==1) {
			order.addBasket(decidecoffee);
			order.addPrice(decideSize);
			System.out.println("\n" + "Well done!");
			// 장바구니에 선택한 물건과 사이즈, 가격정보 대입
		}
		else if (howBasket == 2) {
			System.out.println("\n" + "Get back list");
		}
		else {
			System.out.println("\n" + "!!! Wrong number !!!");
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		showCoffeeList();

	} // showCoffeeList

} // class

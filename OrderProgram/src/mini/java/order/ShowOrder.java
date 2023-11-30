package mini.java.order;

import java.util.Scanner;

public class ShowOrder {
	
	Order order = new Order();
	Scanner sc = new Scanner(System.in);
	
	public ShowOrder() {
	}

	public void showOrderMenu() {
		
		System.out.println("\n"
				+ "[ ***** Basket ***** ]"
				+ "\n" + "# Order List # ");
		System.out.println(order.getBasket().size());
		for (DrinkName menu : order.getBasket()) {
			System.out.println(menu.getName() + menu.getWhat());
			// 주문넣었던 장바구니 리스트가 뜨게하기
		}
		
		System.out.println("\n" + "[ ** Total ** ]");
		System.out.println(order.sumPrice() + " $ ");
		// 주문넣었던 리스트들의 총합가격을 계산후 보여주기
		
		System.out.println("\n" + "1. Ordering | 2. Get back menu | 3. Delete all ");
		System.out.print("\n" + "Number : ");
		int orderChoice = sc.nextInt();
		// 주문 선택하기
		if (orderChoice == 1 ) {
			order.clear();
			System.out.println("Your order is complete");
			// 주문이 완료되었다는 안내창과 함께 리스트 지우기
		} else if (orderChoice == 2) {
			ShowMainMenu showMain = new ShowMainMenu();
			showMain.showMain();
			// 메인메뉴창으로 돌아가기
		} else if (orderChoice == 3) {
			order.clear();
			System.out.println("Clear !!");
			// 장바구니 안에있는 정보 삭제
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		showOrderMenu();
		// 실행이 다끝나면 처음 오더 화면으로
		
	} // showOrderMenu 

}// class

package mini.java.order;

import java.util.Scanner;

public class ShowMainMenu {
	
	ShowSoda showSoda = new ShowSoda();
	ShowJuice showJuice = new ShowJuice();
	ShowMilk showMilk = new ShowMilk();
	ShowCoffee showCoffee = new ShowCoffee();
	ShowOrder showOrder = new ShowOrder();
	
	Order order = new Order();
	
	Scanner sc = new Scanner(System.in);
	
	public ShowMainMenu() {
	}
	
	public void showMain() {
		
		System.out.println("\n"
				+ "[ ***** Drink Menu ***** ] \n"
				+ "1. Soda List \n"
				+ "2. Juice List \n"
				+ "3. Milk List \n"
				+ "4. Coffee List \n"
				+ "\n"
				+ "[ ***** Order Menu ***** ] \n"
				+ "5. Basket \n"
				+ "6. Program Off\n"
				);
		
		System.out.print("Number : ");
		int num = sc.nextInt();
		// 메뉴판과 번호를 입력할곳
			
		switch (num) {
			
		case 1 :
			showSoda.showSodaList();
			break;
			// 탄산음료 리스트로 이동
		case 2 :
			showJuice.showJuiceList();
			break;
			// 주스 리스트로 이동
		case 3 :
			showMilk.showMilkList();
			break;
			// 우유 리스트로 이동
		case 4 :
			showCoffee.showCoffeeList();
			break;
			// 커피 리스트로 이동
		case 5 :
			showOrder.showOrderMenu();
			// 장바구니 리스트로 이동
			break;
		case 6 :
			
			System.out.println("\n" + "Are you sure?");
			System.out.println("1. Yes 2. No");
			System.out.print("\n" + "Number : ");
			int exit = sc.nextInt();
			// 정말로 종료할것인지 다시한번 묻고 대답입력
			if (exit == 1) {
				System.out.println("\n" + "Shut down the program");
				System.exit(0);
				// 1번입력시 프로그램을 종료한다고 알리고 프로그램 종료
			}
			else if (exit == 2) {
				System.out.println("\n" + "Get back menu");
				// 2번입력시 메뉴로 돌아간다고 출력
			}
			else {
				System.out.println("\n" + "!!! Wrong number !!!");
				// 그 외에 입력할경우 번호를 다시 입력하라고 출력
			}
			break;
			
		default :
			System.out.println("\n" + "!!! Wrong number !!!");
			break;
			// 잘못된 번호 입력시 번호를 다시입력하라고 출력
		}
		
		try {
			Thread.sleep(3000);
			// 번호 입력한뒤 알림창 읽을수 있도록 3초 지연
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		showMain();
		// 모든기능 구현끝나면 메인화면으로 돌아가도록 설정
	
	}// showMain
	
} // class

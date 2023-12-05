package proxy;

import java.util.Scanner;

public class ProxyMain {
	
	public static void main(String[] args) {
		
		INum inum = new INumberProxy();
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			int i = sc.nextInt();
		
			inum.print(i);
		}
		
	} // main

} // class

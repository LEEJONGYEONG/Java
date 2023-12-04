package factory.main;

import java.util.List;

import factory.car.CarFactory;
import factory.framework.Factory;
import factory.framework.Product;

public class CarMain {
	
	public static void main(String[] args) {
		
		Factory factory = new CarFactory();
		Product product1 = factory.create("아우디");
		Product product2 = factory.create("모닝");
		Product product3 = factory.create("벤츠");
		
		List<Product> productList 
			= ((CarFactory)factory).getProductList();
		for (Product product : productList) {
			product.use();
		}
		
	}

}







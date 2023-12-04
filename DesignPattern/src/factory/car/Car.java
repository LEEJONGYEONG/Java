package factory.car;

import factory.framework.Product;

public class Car extends Product {
	
	private String carName;
	
	Car(String carName) {
		this.carName = carName; 
	}

	@Override
	public void use() {
		System.out.println(carName + " 자동차가 사용됨!");
	}

}
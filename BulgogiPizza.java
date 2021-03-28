package pizza.child;

import pizza.parent.Pizza;

public class BulgogiPizza extends Pizza {

	
	

	public BulgogiPizza(int price, String storeName) {
		super(price, storeName);
		
	}

	@Override
	public void topping() {
		System.out.println("BulgogiPizza Topping...Pizza");
		
	}

	
	

	
}

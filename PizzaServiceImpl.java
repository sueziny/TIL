package pizza.service.impl;

import pizza.parent.Pizza;
import pizza.service.PizzaService;



public class PizzaServiceImpl implements PizzaService {

	static final PizzaServiceImpl service = new PizzaServiceImpl();//1
	private PizzaServiceImpl() {}//2
	public static PizzaServiceImpl getInstance() {//3
		 return service;
	}
		
	@Override
	public void allMakePizza(Pizza[] pizzas) {
		for(Pizza p: pizzas) {
			System.out.println(p);
			p.makePizza();
			System.out.println("================");
			
		}
	}

}

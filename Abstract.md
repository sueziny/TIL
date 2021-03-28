# TIL
Just do it!

package pizza.parent;

/*
 * 추상 클래스의 용도
 * 1. 여러종류의 피자를 만들어내기 위한 공통적인 작업(필드, 메소드)은 그래도 자식들에게 물려주고 
 * 2. 반면에 여러종류의 피자가 만들어질 수 있는 결정적인 부분은 추상 메소드로 선언해둔다..public abstract void topping();...
 * 
 * 완벽한 추상성 ---> 인터페이스 ---> 사용자와 작성자간의 Contract
 * 부분적인 추상성 ---> 추상 클래스 --> 결정적으로 다른 부분을 미완으로 물려준다. ---> 자식이 미완을 완성하도록 리딩...
 */

public abstract class Pizza {

	protected int price;
	protected String storeName;
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	public Pizza() {
		this(15000, "PizzaHut");
	}
	
	//기능을 하나 더 추가
	public void makePizza() {
		dough();
		
		topping();
		
		bake();
		cutting();
		boxing();
		
	}
	
	public void dough() {
		System.out.println("피자 반죽과 함께 도우를 잘 만들어 줍니다..");
		
	}
	
	public void bake() {
		System.out.println("180동 온도에서 10분간 구워냅니다..");
	}
	public void cutting() {
		System.out.println("8조각으로 잘라줍니다.");
	}
	public void boxing() {
		System.out.println("잘려진 피자를 상자에 포장합니다");
	}
	public abstract void topping();
	//정보를 리턴하는 기능 추가

	@Override
	public String toString() {
		return "상점이름 " + storeName +"-가격, "+ price;
	}
	
}
-------------------------------------------------------------------------------

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

---------------------------------------------------------------------------

package pizza.child;

import pizza.parent.Pizza;

public class PineApplePizza extends Pizza {

	public PineApplePizza(int price, String storeName) {
		super(price, storeName);
		
	}
	
	@Override
	public void topping() {
		// TODO Auto-generated method stub
		
	}

}
--------------------------------------------------------------

package pizza.child;

import pizza.parent.Pizza;

public class PotatoPizza extends Pizza {



	public PotatoPizza(int price, String storeName) {
		super(price, storeName);
		
	}

	@Override
	public void topping() {
		// TODO Auto-generated method stub
		
	}
}


-----------------------------------------------------------

package pizza.service;

import pizza.parent.Pizza;

//Template기능들만 모아놓은 인터페이스...
public interface PizzaService {
	
	void allMakePizza(Pizza[] pizza);
}
--------------------------------------------------------

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
-----------------------------------------------------------

package pizza.test;

import pizza.child.BulgogiPizza;
import pizza.child.PineApplePizza;
import pizza.child.PotatoPizza;
import pizza.parent.Pizza;
import pizza.service.impl.PizzaServiceImpl;

public class PizzaTest {

	public static void main(String[] args) {
	  
		Pizza p1 = new PotatoPizza(20000,"Mr.Pizza");
		Pizza p2 = new BulgogiPizza(32000,"오구피자");
		Pizza p3 = new PineApplePizza(32000,"오구피자");
		
		Pizza[] pizzas =  {p1, p2, p3};
		
	    PizzaServiceImpl.getInstance().allMakePizza(pizzas);
			

	}

}

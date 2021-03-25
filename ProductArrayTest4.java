package com.encore.test;

import com.encore.service.OutletStoreService;
import com.encore.vo.Customer;
import com.encore.vo.Product;
//OutletStoreService와 Hasing되는 Test Class...
public class ProductArrayTest4 {

	public static void main(String[] args) {
		//service객체 생성...service 클래스 기능들을 메모리에 올린다.
		OutletStoreService service = new OutletStoreService();
		
		Product [] product1 = {
				new Product("댕기머리샴푸", 23000, 2, "LG"),
				new Product("제주삼다수", 2000, 7, "HP"),
				new Product("컵라면", 1200, 10,"Samsung"),
				new Product("캣타워",340000 ,1, "LG")
		};
		
		Product [] product2 = {
				new Product("죽염치약", 23000, 2, "CJ"),
				new Product("새우깡", 2000, 2, "농심"),
				new Product("신라면", 1200, 10,"농심"),
		};
		
//		Customer[] customers = new Customer[2];
//		customers[0] = new Customer(111, "이나영", "방배동");
//		customers[1] = new Customer(222, "원빈", "방배동");
		
		Customer[] customers = {
				new Customer(111, "이나영", "방배동"),
				new Customer(222, "원빈", "방배동")
		};
		
		customers[0].buyProducts(product1);
		customers[1].buyProducts(product2);
		
		///////////////////아래서부터는 Service의 기능을 호출할 것입니다.////////////////
		System.out.println("======방배동 거주 고객입니다.==========");
		Customer[] cust = service.getCustomer(customers, "방배동");
		for(Customer c : cust) 
			System.out.println(c.getDetail());
				
		
	}
}

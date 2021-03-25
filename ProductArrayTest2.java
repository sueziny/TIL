package com.encore.test;

import com.encore.vo.Product;
//기능들을 추가해 보겠습니다.
public class ProductArrayTest2 {

	public static void main(String[] args) {
		// 1.Product Type의 배열을 3개 생성
		// 2.Product를 3개 생성
		// 1, 2를 한번에 하시길 바랍니다.
		
		//3. for문을 이용해서 Product 정보를 출력
		
		Product [] product = {
				new Product("댕기머리샴푸", 23000, 2, "LG"),
				new Product("제주삼다수", 2000, 7, "HP"),
				new Product("컵라면", 1200, 10,"Samsung"),
				new Product("캣타워",340000 ,1, "LG")
		};
		//1. 상품들의 메이커를 출력합니다
		System.out.println("================상품들의 메이커를 출력합니다================="); 
		for(Product p : product)
			System.out.println(p.getMaker());
		
		System.out.println("================10만원 이상하는 제품들을 출력합니다================="); 
		for(Product p : product) {
			if(p.getPrice()>=100000)
			System.out.println(p.getDetail());
		}
		
		//3.구매한 물건들의 총가격
		System.out.println("================총 구입 가격을 출력합니다================="); 
		for(Product p : product) {
		int total = 0;  total += p.getPrice()*p.getQuantity();
			System.out.println("Total Price "+ total+ "원");
		}
	
	}	
		 

}

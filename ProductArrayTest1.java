package com.encore.test;

import com.encore.vo.Product;

public class ProductArrayTest1 {

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
		
		for(Product p : product)
			System.out.println(p.getDetail());
	}

}

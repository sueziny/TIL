package com.encore.test;

import com.encore.service.ProductStoreService;
import com.encore.vo.Product;
//기능들을 추가해 보겠습니다.
public class ProductArrayTest3 {

	public static void main(String[] args) {
		//service객체 생성...service 클래스 기능들을 메모리에 올린다.
		ProductStoreService service = new ProductStoreService();
		
		Product [] product = {
				new Product("댕기머리샴푸", 23000, 2, "LG"),
				new Product("제주삼다수", 2000, 7, "HP"),
				new Product("컵라면", 1200, 10,"Samsung"),
				new Product("캣타워",340000 ,1, "LG")
		};
		
	System.out.println("==========1. 모든 상품의 메이커를 출력합니다.===========");
	service.printAllProductMaker(product);
	
	System.out.println("==========2. 모든 상품의 총 구입액을 받아옵니다.===========");
	//int total = service.getTotalPrice(product);
	//System.out.println(total+"원");
	
	System.out.println(service.getTotalPrice(product)+"원");

	System.out.println("==========3. 10000원 이상의 제품들을 받아옵니다.===========");
	//1
	Product[] returnPros = service.getMorePrice(product, 10000);
	for(Product p : returnPros) {
		if(p==null) continue;
		System.out.println(p.getDetail());
	}
	//2
	//System.out.println("10000원 이상인 제품은" + service.getMorePrice(product, 10000));
	
	//3
//	for(Product p : service.getMorePrice(product, 10000)) {
//		if(p != null)
//			System.out.println(p.getDetail());			
//	}
//		
		//System.out.println(p.getDetail());
	
	
	System.out.println("==========4.동일한 회사 제품들입니다..===========");
	Product[] returnPros1 = service.getCertainCompany(product, "LG");
	for(Product p : returnPros1) {
		if(p==null) continue;
		System.out.println(p.getDetail());
	}
	
	System.out.println("==========5.제품들의 평균가입니다...===========");
	
	System.out.println(service.getAvgPrice(product)+"원 입니다.");
	}	 

}

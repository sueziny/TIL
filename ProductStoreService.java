package com.encore.service;

import com.encore.vo.Product;

/*
 * ProductStore에 있는 다양한 상품들을 다루는 
 * 기능만을 모아놓은 클래스
 * 이런 기능만으로 작성된 클래스를 서비스(Manage) 클래스라 한다.
 * 
 * 이 클래스에서 다루는 기능들
 * 1)다양한 상품들의 메이커를 출력하는 기능
 * 2)상품들의 총 구입액을 리턴하는 기능
 * 3)특정 금액 이상이 되는 상품을 리턴하는 기능
 * 4)특정회사 제품들을 리턴하는 기능
 * 5)구입한 상품의 평균가를 리턴하는 기능
 * --->기능의 Identifier 지저하는 방법도 함께
 */

public class ProductStoreService {
	//1)다양한 상품들의 메이커를 출력하는 기능
	public void printAllProductMaker(Product[] pros) {
		for(Product p : pros) System.out.println(p.getMaker());
	}
	//2)상품들의 총 구입액을 리턴하는 기능
	public int getTotalPrice(Product[] pros ) {
		//구현
		int total = 0;
		for(Product p : pros) total += p.getPrice()*p.getQuantity();
		return total;
	}
	//3)특정 금액 이상이 되는 상품을 리턴하는 기능
	public Product[] getMorePrice(Product[] pros, int price) {
		Product[] temp = new Product[pros.length];
		int idx = 0;
		for(Product p : pros) {
			if(p.getPrice()>=price) 
				temp[idx++] = p;
				//idx++;
		}
		return temp;
	}
	//4)특정회사 제품들을 리턴하는 기능
	public Product[] getCertainCompany(Product[] pros, String company) {
		Product[] temp = new Product[pros.length];
		int idx = 0;
		for(Product p : pros) {
			if(p.getCompany().equals(company))
				temp[idx++] = p;
		}	
		return temp;
	}
	//5)구입한 상품의 평균가를 리턴하는 기능
	   
//	1.
//		public int getAvgPrice(Product[] pros) {
//	
//		return getTotalPrice(pros)/pros.length;
//		
//	}
	
	//2.
//	public int getAvgPrice(Product[] pros) {
//		Product [] temp = new Product[pros.length];
//		int total = 0;
//		int idx = 0;
//		for(Product p : pros) {
//	       temp[idx++]= p;
//		   total += p.getPrice();
//		}		   
//			return total/pros.length;
//  }
	//3.
	public int getAvgPrice(Product[] pros) {
		int total = 0;
		for(Product p : pros) {
	       total += p.getPrice();
		}		   
		return total/pros.length;
	}
	
}

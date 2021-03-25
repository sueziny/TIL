package com.encore.vo;
/*
 * 상품에 대한 정보를 가지고 있는 클래스
 * vo - Value Object 약자로서 지금처럼 특정한 정보를 담고 있는 클래스들을 VO클래스라고 지칭한다.
 * 
 * 1. 필드선언
 * 2. 명시적 생성자
 * 3. setter()/getter()
 */

public class Product {
	private String maker;
	private int price;
	private int quantity;
	private String company;
	
	
	public Product(String maker, int price, int quantity, String company) {
		super();
		this.maker = maker;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
	}
	
	public String getDetail( ) {
		return maker +","+price +"," +quantity +","+company;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
}

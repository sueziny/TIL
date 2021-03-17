package com.encore.cons;

/*
 * 1. 생성자
 * 객체가 생성될때마다 구동(호출)되는 것.
 * 
 * 2.기본 생성자
 * ::
 * 인자값 없고
 * {} 안에서 아무런 동작도 하지 않는 생성자.
 */
public class Shirt {
	//1. 필드 선언
	public String brandName;
	public double price;
	public boolean longSleeved;
	
	//public Shirt() {  } : 기본 생성자로 현재 생략됨. (식구가 아님)
	public Shirt() { }
	
	public Shirt(String brandName, double price, boolean longSleeved) {
		
		this.brandName = brandName;
		this.price = price;
		this.longSleeved =longSleeved;

	}
	
	public String getDetails() {
		return brandName+","+price+","+longSleeved;
	}
}

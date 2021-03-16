package com.encore.datatype;

/*
 * 1.필드
 * 	int 사이즈, char 컬러, float 가격, String 제조회사, String 재질, 
 *  스크래치 여부를 알 수 있는 필드를 추가
 * 2.메소드
 * 	2개 정의
 * 	- 필드 값을 Test 클래스에서 받아서 필드에 입력하는 기능
 * 	- 필드에 입력된, 저장된 값을 콘솔창으로 출력하는 기능 
 * ------------------------------------------------
 * 1.
 * 변수는 사용되는 위치에 따라서 필드과 로컬v로 구분된다)
 * 필드 --> 클래스 선언 바로 밑, 메소드 블락 바깥
 * Local V(지역)-->메소드 안에서 선언
 * 
 * 2.
 * 
 */

public class WhiteBoard {
	// field
	public int size;
	public char color;
	public float price;
	public String company;
	public String material;
	public boolean scratch;

	public void setInfo(int size, char color, float price, String company, String material, boolean scratch) {
		// 필드와 로컬변수의 이름이 같을 때, 구분하기 위해서 필드 앞에 this를 붙인다.
		// this는 해당클래스 자기자식...쯤으로 일단 해석...
		this.size = size;
		this.color = color;
		this.price = price;
		this.company = company;
		this.material = material;
		this.scratch = scratch;
	}

	public void printInfo() {
		System.out.println(size + "\t" + color + "\t" + price + "\t" + company + "\t" + material + "\t" + scratch);
	}

}

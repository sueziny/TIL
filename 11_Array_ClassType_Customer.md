# TIL
Just do it!
package com.encore.array;

public class Customer {
	//1.필드선언
	private String name;
	private int ssn;
	
	///////////////has a Relation/////////////////
	// 필드추가...여러개의 통장을 가지는 고객이 되도록
	private Account[] account;
	
	// 기능 추가.. 추가한 필드를 setter로 주입
	public void setAccount(Account[] account) {
		this.account = account;
	}
	
	// 기능 추가.. 추가한 필드를 받아오는 기능
	public Account[] getAccount() {
		return account;
	}
	
	 //////////////////////////////////////////////
	
	
	//2.주입의 통로..생성자 주입
	public Customer(String name, int ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	

	//3.필드 정보를 받아옴
	public String getCustomerIfo() {
		return name + "," +ssn;
	}
	
	

}

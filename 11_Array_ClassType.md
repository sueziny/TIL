# TIL
Just do it!

package com.encore.array;
//통장에 대한 정보를 가지고 있는 Account클래스

public class Account {
	//1.필드 선언
	private double balance;
	private String bankName;
	
	
	//2. 주입의 통로...생성자/setter
	public Account(double balance, String bankName) {
		this.balance = balance;
		this.bankName=bankName;
	}
	
	//3.필드 정보를 받아옴
	public String getDetail() {
		return balance + "," +bankName;
	}
	
	//4.나머지 기능
	public void withdraw(double amt) {
		if(balance>=amt) balance -= amt;
		else return;
	}
	
	public void deposit(double amt) {
		if(balance>=1000) balance += amt;
		else return;
	}

	
	//기능 추가
	public double getBalance() {
		return balance;
	}

	public String getBankName() {
		return bankName;
	}
	
}//class

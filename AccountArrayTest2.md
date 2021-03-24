# TIL
Just do it!
package com.encore.array.test;

import com.encore.array.Account;
import com.encore.array.Customer;

public class AccountArrayTest2 {

	public static void main(String[] args) {
		//Account Type의 배열 선언, 생성, 초기화
		Account[] acc = {
				new Account(1000.0,"신한은행"),
				new Account(30000.0,"국민은행"),
				 new Account(40000.0,"우리은행")
		};
		
		//1. Customer 객체를 생성
		Customer c = new Customer("james", 12345);
		
		//2. James라는 고객의 통장 3개를 Hasing 하도록 한다.
		c.setAccount(acc);
		
		//3. James가 개설한 통장들을 받아온다.
		Account[] returnAcc = c.getAccount();
		
		//4. James의 통장들 중에서 신한은행 통자에만 500000만원을 입금한다.
		for(Account a : returnAcc) {
			if(a.getBankName().equals("신한은행")) 
				a.deposit(50000.0);
		}
	
		System.out.println("========통장의 잔고를 확인합니다.==========");
		
		//5. 각 통장들의 잔고를 확인한다.
		// 필요한 기능이 있다면 알아서 추가
		
		for(Account account : returnAcc) System.out.println(account.getDetail());
	}	
	
}

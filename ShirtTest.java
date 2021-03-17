package com.encore.cons.test;

import com.encore.cons.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		
		Shirt longT = new Shirt("나이키",120.0,true); //;은 문장(Statement)의 종결과 calling 의 의미
		Shirt halfT = new Shirt("아디다스",125.0,true);
		
		System.out.println(longT.getDetails());
		System.out.println(halfT.getDetails());
		
	}

}

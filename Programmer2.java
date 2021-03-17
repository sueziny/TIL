package com.encore.cons;

import com.encore.util.MyDate;

//개발자 정보를 담고 있는 클래스
public class Programmer2 {
	
	//필드 선언
	public String name; //클래스데이터타입(API)
	public MyDate birthday; //내가 만든 데이터타입(User Definition)
	public float salary;
	public int bonus;
	
	//2. 주입
	public void setProgrammer(String name, MyDate birthday, float salary, int bonus) {
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	
	//3. 필드 값 받아오기
	public String getProgrammer() {
		return name+","+birthday.getDate()+","+salary+","+bonus;
		
	}
	
}

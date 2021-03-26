package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Engineer extends Employee {
	
	private String tech;
	private int bonus;
	
	public Engineer(String name, MyDate birthDay, double salary, String tech, int bonus ) {//자식이 생성되려할때...
		//부모 기본 생성자 호출이 여기서 무조건 일어난다....super();
		super(name, birthDay, salary);
		this.tech=tech;
		this.bonus=bonus;
	}
	
	public String getDetails() {
		return super.getDetails() +","+tech;
	}

	//기능 추가
	public void changeTech(String tech) {
		this.tech = tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public String getTech() {
		return tech;
	}

	public int getBonus() {
		return bonus;
	}
	
	
	
}

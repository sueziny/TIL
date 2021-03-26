package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class Secretary extends Employee{

	public String bossOfName;
	
	public Secretary(String name, MyDate birthDay, double salary, String bossOfName) {//자식이 생성되려할때...
		//부모 기본 생성자 호출이 여기서 무조건 일어난다....super();
		super(name, birthDay, salary);
		this.bossOfName=bossOfName;
	}
	
	public String getDetails() {
		return super.getDetails() +","+bossOfName;
	}

	public void changeBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}
	
	
	
}



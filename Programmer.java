package com.encore.cons;

import com.encore.util.MyDate;

//������ ������ ��� �ִ� Ŭ����..
public class Programmer {

	// 1. �ʵ� ����...
	public String name;
	public MyDate birthday;
	public float salary;
	public int bonus;

	// 2. ����
	/*
	 * public void setProgrammer(String name,MyDate birthday, float salary, int
	 * bonus) { this.name = name; this.birthday = birthday; this.salary = salary;
	 * this.bonus = bonus; }
	 */

	// �߰�...������

	public Programmer(String name, MyDate birthday, float salary, int bonus) {
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
		this.bonus = bonus;

	}

	// �߰�...�������� ������ �����ϴ� ����� ����

	// 1���õ�
	// public String income(String name, float salary) {
	// return name+","+salary;

	// }

	public float getIncome() {
		return salary * 12 + bonus;
	}

	// 3. �ʵ� �� �޾ƿ���
	public String getProgrammer() {
		return name + "," + birthday.getDate() + ", " + salary + ", " + bonus;
	}

	public String getName() {
		return name;
	}

}
package com.encore.service;

import com.encore.child.Engineer;
import com.encore.parent.Employee;

/*
 * 상속관계에 있는 다양한 subclass들을 핸들링하는 기능만으로 이루어진 서비스 클래스.
 * 
 */
public class EmployeeService {
	/*
	 * 1step
	 * ::
	 * public void manageManager(Manager m){}
	 * public void manageEngineer(Engineer eg){}
	 * public void manageSecretary(Secretary s){}
	 * 
	 * 2step------Overloading
	 * "메소드 이름은 같고
	 * 처리하는 데이터를 달리하는 기법"
	 * ::
	 * << Rule >>
	 * 0.하나의 클래스에서만 적용되는 기법
	 * 1.메소드 이름은 반드시 같아야 한다.
	 * 2.메소드 인자값은 반드시 달라야 한다.
	 * 3.메소드 리턴타입은??...상관없다.
	 * ::
	 * public void manageEmployee(Manager m){}
	 * public void manageEmployee(Engineer eg){}
	 * public void manageEmployee(Secretary s){}
	 * 
	 * 3step
	 * public void manageEmployee(Employee e){}
	 * 
	 */
	
	public void manageEmployee(Employee e) {
		if(e.getName().equals("Peter")) {
			System.out.println(e.getDetails());
		}
		if(e instanceof Engineer) {
			System.out.println("연봉 :: "+(e.getSalary()*12+((Engineer) e).getBonus()));
		}
	}
	public void printAllEmployee(Employee[] emps) {
		for(Employee e:emps)
			System.out.println(e.getDetails());
	}
	
}

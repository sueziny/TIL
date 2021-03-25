# TIL
Just do it!

package com.encore.parent;

public class Person {

		private String name;
		private int age;
		private String address;
		
		
		public Person(String name, int age, String address) {
			super();
			this.name = name;
			this.age = age;
			this.address = address;
		}
		
		@Override
		public String toString() {
		
			return name+","+age+","+address;
		}
		
		
}


-------------------------------------------------------------------------------------------
package com.encore.child;

import com.encore.parent.Person;

public class Student extends Person {

	private int stuId;


	public Student(String name, int age, String address, int stuId) {
		super(name, age, address);
		this.stuId = stuId;
	}


	@Override
	public String toString() {
		return super.toString() +", Student [stuId=" + stuId + "]";
	}
	
	
}

----------------------------------------------------------------------------

package com.encore.child;

import com.encore.parent.Person;

public class Teacher extends Person {

	private String subject;

	public Teacher(String name, int age, String address, String subject) {
		super(name, age, address);
		this.subject = subject;
	}

	@Override
	public String toString() {
		return super.toString() + ", Teacher [subject=" + subject + "]";
	}
	
	
}

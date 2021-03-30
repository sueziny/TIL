# TIL
Just do it!

package collection.sort.test;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 배열은 이게 가능 --->Arrray.sort(Xxx[]) sort()는 comparable에 의해서 정렬된 것이다.
 *  리스트는 이게 불가능 ---->Arrray.sort(arraylist)는 안돌아간다.
 *  리스트는 Collection.sort()를 하면 된다.
 *  
 *  이번예제에서는 Comparable을 사용해서 ArrayList 안에 들어있는 객체들을 특정한 값에 의해서 정렬해보겠다. 
 * 
 * 1. Comparable을 직접 상속 받아서 구현하는 방법...compareTo를 정렬하고픈 필드(나이순, 이름순)에 맞춰서 구현
 * 2. Comparator를 sort 함수 안에서 직접 구현하는 방법
 */

class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int compareTo(Person p) {//나이순
		
		//return new Integer(age).compareTo(p.getAge());//나이가 적은 순서대로
		return -(new Integer(age).compareTo(p.getAge())); //나이가 많은 순서대로
	}
	
	
//	@Override
//	public int compareTo(Person p) {//이름순
//		
//		//return name.compareTo(p.getName());
//		return -name.compareTo(p.getName()); //내림차순은 앞에 -를 붙인다.
//	}
//	
	
}
public class ComparableTest1 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("강호동", 48));
		list.add(new Person("이수근", 45));
		list.add(new Person("서장훈", 38));
		
		Collections.sort(list);
		System.out.println(list);
	}

}
------------------------------------------------------------------------------

package collection.sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 앞에서 작성된 Person으 여기서 그대로 사용함니다.
 */

public class comparatorTest2 {

	public static void main(String[] args) {
	
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("강호동", 48));
		list.add(new Person("이수근", 45));
		list.add(new Person("서장훈", 38));
		
		//Array.sort(배열) | collection.sort(리스트, Comparator 객체)
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return p1.getAge()-p2.getAge();//오름, 내림
			}
		});
		
		//확인
		for(Person p : list) System.out.println(p);
		
	}

}

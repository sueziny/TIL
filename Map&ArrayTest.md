# TIL
Just do it!

package collection.vo;

public class Person {
	
	private String name;
	private String addr;
	private int age;
	public Person(String name, String addr, int age) {
		super();
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	public Person() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
	
}
-----------------------------------------------------------------------------------

package collection.test2;
/*
 * List안에 여러명의 사람을 추가하는 로직을 작성
 * 추가된 사람의 정보를 핸들링하는 방법도 로직으로 작성
 * 
 */

import java.util.ArrayList;

import collection.vo.Person;

public class PersonArrayTest1 {

	public static void main(String[] args) {
	 ArrayList<Person> list = new ArrayList<Person>();// 예전에는 Arry를 사용했지만 이제는 List
	 
	 list.add(new Person("강호동", "서초동", 45));
	 list.add(new Person("이수근", "방배동", 42));
	 list.add(new Person("강호동", "여의도", 33));
	 list.add(new Person("서장훈", "평창동", 40));
	 list.add(new Person("김희철", "서초동", 36));

	 System.out.println(list);
	 
	 //1. 리스트에 있는 들어있는 사람이 몇명인지 출력
	 System.out.println(list.size());
	 //2. 리스트에 저장된 사람의 평균 연령을 출력
	 int total = 0;
	 for(Person p : list) total += p.getAge();
	 System.out.println(total/list.size());
	 //3. 저장된 사람들 중에서 서초동에 사는 사람을 출력
	 for(Person p : list) {
		 if(p.getAddr().equals("서초동")) System.out.println(p);
	 }
	 
	 
	}

}
-------------------------------------------------------------------------------------------------------



package collection.vo;

public class Customer {

	private String id;
	private String name;
	private int age;
	
	
	public Customer(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Customer() {  }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
----------------------------------------------------------------------------------

package collection.test2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import collection.vo.Customer;

public class CustomerMapTest2 {

	public static void main(String[] args) {
		HashMap<String, Customer> map= new HashMap<String, Customer>();
		
		map.put("111", new Customer("KANG","강호동",48));
		map.put("222", new Customer("LEE","이수근",44));
		map.put("333", new Customer("SEO","서장훈",42));
		map.put("444", new Customer("KIM","김희철",37));
		
		//1. KEY 값이 222인 사람의 정보를 출력
		System.out.println(map.get("222"));
		
		//2. id가 LEE인 사람을 찾아서 그 사람의 이름을 출력
		Set<String> set =map.keySet();
		Iterator<String> it =set.iterator();
		while(it.hasNext()) {
			Customer c = map.get(it.next());
				if(c.getId().equals("LEE")) System.out.println(c.getName());
			}
		
		
		//3. MAP에 저장된 데이터의 모든 KEY값들을 출력
		System.out.println(map.keySet());
		
		//4. MAP에 저장된 사람들 나이의 총합과 평균연령을 출력
		Set<String> keys = map.keySet();
		int totalAge = 0;
		for(String s: keys) {
			totalAge += map.get(s).getAge();
		}
		
		System.out.println("연령의 총합" +totalAge+"세");
		System.out.println("연령의 평균" +totalAge/map.size()+"세");
	}

}



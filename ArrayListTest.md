# TIL
Just do it!

package collection.test;

import java.util.ArrayList;
import java.util.List;

/*
 * List
 * 순서를 가지면서(내부적으로 index로 관리된다) 객체를 저장하는 방식
 * 중복은 허용한다.
 */
public class ArrayListTest {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("강호동");
		list.add("이수근");
		list.add("강호동");
		list.add("서장훈");
		list.add("김희철");
		
		System.out.println(list);
		
		//3번째 객체를 삭제
		String name = list.remove(2);
		
		//삭제된 데이터를 출력
		System.out.println("삭제된 사람은 "+ name + " 입니다!!");
		//첫번째 데이터를 아이유로 수정
		list.add(0, "아이유");
		//모든 정보를 출력
		System.out.println(list);
		
		//list에 저장된 멤버들 중에서 이름이 서장훈을 받아온다.
		int cnt = 0;
		for(String str: list) {
			if(str.equals("서장훈")) System.out.println(list.get(cnt));
			cnt++;
		}
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).equals("서장훈"))System.out.println(list.get(i));
		}
		
	}

}

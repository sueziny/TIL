package com.encore.datatype.test;

import com.encore.datatype.WhiteBoard;

/*
 * WhiteBoardtest1... Test,실행 클래스라고 부른다.
 * 
 * Test,실행 클래스가 하는 일
 * 1)객체를 생성한다 == 객체의 구성요소(식수)를 메모리에 올린다.
 * 2)식구에 접근
 *   필드 ---값할당----실제값이 하드코딩되면 그것을 프로그램이 아니다..하면 안된다...
 *   메소드---Calling
 *   
 */
public class WhiteBoardTest1 {

	public static void main(String[] args) {
		/*
		 * WhiteBoard 객체를 wb라는 이름으로 하나 생성
		 * 필드에 값을 입력
		 * 입력된 값을 출력
		 * 
		 * 3시 15분에 다시 만남
		 * 슬랙
		 * 
		 */

		WhiteBoard wb = new WhiteBoard();
		
		wb.setInfo(100, 'W', 120, "Encore", "Plactic", true);
		
		wb.printInfo();
		
	}

}

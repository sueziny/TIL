package com.encore.capsulation;

/*
 * Encapsulation Pattern
 * 1. 다른 클래스에서 직접적으로 접근할 수 없도록
 *    필드앞에 private 지정
 * 2. 클래스의 필드에 접근은 setter()/getter() 한다
 *    그리고 얘네들이 다른 클래스에서도 접근할 수 있도록 public
 *    public void setXx()
 *    public int getXx()
 * 3.setXx() {
 *    첫 라인에서(필드 초기화 되기 직전!!)에  타당한 값만 받을 수 있도록 로직을 제어한다
 *    
 *    setDay()
 *    ::
 *    1,3,5,7,8,10,12월 ---> 1~31일
 *    2월은 1~28일
 *    4 6 9 11 월은 1~30일
 *    switch, if
 *    
 *    ::
 *    0월 22일입니다 x
 *    2월 0일 입니다 x
 */
public class MyDate {
	private int month;
	private int day;
	

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		//제어문 1~12월에 해당하는 값만 처리..나머지는 메세지..
		if(month>=1&&month<=12) {
		this.month = month;
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		//제어문 
		//월에 따라서 day가 달라진다..
		switch(month) {
		case 2:
			if(day>=1 && day<=28) {
				this.day = day;
			}else {
				System.out.println("잘못입력");
				return;
				
			}
			break;
		case 4:
			
		}
		
	}
}

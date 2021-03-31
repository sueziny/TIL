# TIL
Just do it!

package exception.user.vo;

//사용자 정의 Exception으로 만들어보자..
public class ZeroDivide extends Exception {
	public ZeroDivide() {
		this("This is UserException.....ZeroBoomException...");
	}
	
	public ZeroDivide(String message) {
		super(message);
	}
}
--------------------------------------------------------

package exception.user.test;

class User{
	public void go() throws ArithmeticException {
		//스캐너로 i, j에 해당하는 값을 받아들인다고 가정...
		int i=10; int j = 0;
		
		System.out.println("1.Scanner로 입력받는 j값이 0이면 안되는데...");
		//j값이 0이면 예외를 고의적으로 발생시켜서 더 이상 진행되지 않도록 처리..예외 객체를 생성...
		if(j==0) throw new ArithmeticException();
		
		// 아랫부분 어딘가에서 i/j j가 분모가 되는 연산이 진행된다고 가정...
	}
}
public class UserExceptionTest1 {

	public static void main(String[] args) {
		
      User user = new User();
      try {
      user.go();
      System.out.println("2. 폭탄이 이곳으로 날아왔습니다.");
      
      }catch(ArithmeticException e) {
    	  System.out.println("3. 폭탄 처리 성공");
      }
      System.out.println("4. 프로그램은 정상 종료 됩니다...");
	}

}
--------------------------------------------------------------

package exception.user.test;

import exception.user.vo.ZeroDivide;

class User2 {
	public void go() throws ZeroDivide {
		// 스캐너로 i, j에 해당하는 값을 받아들인다고 가정...
		int i = 10;
		int j = 0;

		System.out.println("1.Scanner로 입력받는 j값이 0이면 안되는데...");
		// j값이 0이면 예외를 고의적으로 발생시켜서 더 이상 진행되지 않도록 처리..예외 객체를 생성...
		if (j == 0)
			throw new ZeroDivide("분모가 0이되면 안됩니다");

		// 아랫부분 어딘가에서 i/j j가 분모가 되는 연산이 진행된다고 가정...
	}
}

public class UserExceptionTest2 {

	public static void main(String[] args) {
		User2 user = new User2();
		try {
			user.go();
			System.out.println("2. 폭탄이 이곳으로 날아왔습니다.");
		} catch (ZeroDivide e) {
			System.out.println(e.getMessage());
		}
		System.out.println("4. 프로그램은 정상 종료 됩니다...");
	}
}
--------------------------------------------------

package exception.user.test;

import java.util.Scanner;

/*
 * 
 * 사용자 정의 Exception 
 * 1. 예외 클래스를 내가 직접 작성해서 사용
 * 	  class A Extends Exception { }  
 * 2. 강력한 제어문으로 사용됨
 * 	  특정한 조건이 형성되면 예외를 고의적으로 생성시켜서 프로그램을 핸들링한다.
 * ----------------------------------
 * 	성인영화를 관람하는데
 *  나이가 19세가 안되는 사람이 극장에 입장하는 경우 
 *  입장을 허용하지 않고 19세 이상되는 사람만 영화관람을 
 *  허용할 수 있는 로직을 작성
 *  -->
 *  UnderAgeException을 정의해서 사용하겠다.
 */

class UnderAgeException extends Exception {
	
	UnderAgeException(){
		this("19세 나이가 안되면 영화 관람 안됩니다.");
		
	}
	 
	UnderAgeException(String message){
		super(message);
	}
	
}

class AdultMovieService {
	public void entrance(int age) throws UnderAgeException{
		if(age<19) //나이가 19세가 안되면 예외 발생!! == 예외 객체 생성 ---> throw
			throw new UnderAgeException();
		else
			System.out.println("Ticketing...Entrance OK!!");
	}
}
 
public class AdultMovieExceptionTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		AdultMovieService service = new AdultMovieService();
		try {
			service.entrance(age);
		}catch(UnderAgeException e) {
			System.out.println(e.getMessage());
		}
	}

}
--------------------------------------------------------

package exception.user.test;



class AmountInputException extends Exception {
	
	AmountInputException(){
		this("10000원 이상만 입금이 가능합니다");
		
	}
	 
	AmountInputException(String message){
		super(message);
	}
	
}

class InvalidAmountException extends Exception {
	
	InvalidAmountException(){
		this("잔액보다 출금액이 더 많습니다.");
		
	}
	 
	InvalidAmountException(String message){
		super(message);
	}
	
}


class Account{
	int balance;

	public Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amt) throws AmountInputException {
		//입금하는 로직
		// 입금액이 10000원이 안되면 AmountInputException을 발생
		if (amt<10000) throw new AmountInputException();
		else
			balance += amt;
			System.out.println(amt +"원 입금되었습니다. 현재 잔액은 "+ balance);
		//정상적인 입금이면 잔액에 금액을 추가하고 얼마 입금되었고 잔액은 얼마인지 출력한다.
		
	}
	
	public void withdraw(int amt) throws InvalidAmountException{
		//출금하는 로직
		//현재 잔액보다 더 많은 금액을 출금하려는 경우 InvalidAmountException을 발생
		if (amt>balance) throw new InvalidAmountException();
		else
			balance -= amt;
			System.out.println(amt+"원 출금되었습니다. 현재 잔액은 "+ balance);
		//출금액이 잔액보다 작거나 같다면 잔액에서 출금액을 빼고..얼마 출금했는지와 남아있는 잔액을 출력
 	}
}


public class BankAccountExceptionTest4 {

	public static void main(String[] args) {
		/*
		 * 객체 생성
		 * 메소드 가각 호출...예외를 여기서 잡아준다
		 */
		Account acc = new Account(10000);
		try {
			acc.deposit(20000);
		}catch(AmountInputException e){
			System.out.println(e.getMessage());
		}
		try {
			acc.deposit(200);
		}catch(AmountInputException e){
			System.out.println(e.getMessage());
		}
		try {
			acc.withdraw(5000);
		}catch(InvalidAmountException e){
			System.out.println(e.getMessage());
		}
		try {
			acc.withdraw(500000);
		}catch(InvalidAmountException e){
			System.out.println(e.getMessage());
		}
	}

}




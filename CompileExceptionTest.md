# TIL
Just do it!

package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String filename) {
		try {
			FileReader fr = new FileReader(filename);
			System.out.println("..new FileReader()...filename...");
		}catch(FileNotFoundException e) {
			//System.out.println("Nice Catch...");
			//1. 비워두거나
			//2. printStackTrace(), getMessage()
			//e.printStackTrace();---> 선호하지않음. 해커에게 표적이 될 수 있기 때문에
			//System.out.println(e.getMessage());
			
		}
		System.out.println("FileReader Creating....");
	}
}

public class CompileExceptionTest1 {

	public static void main(String[] args) {
		
	 FileReading f = new FileReading();
	 String path = "C:\\encore_KSJ\\util\\poem.txt";
	 f.readFile(path);
	 System.out.println("파일을 잘 읽어들였습니다....");
	}

}
----------------------------------------------------------------------------------------------------

package exception.compile.test;
//. try~catch  2.throws
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading2{
	public void readFile(String filename) throws FileNotFoundException {
	
			FileReader fr = new FileReader(filename);
			System.out.println("..new FileReader()...filename...");
		
		System.out.println("FileReader Creating....");
	}
}

public class CompileExceptionTest2 {

	public static void main(String[] args) {
		
	 FileReading2 f = new FileReading2();
	 String path = "C:\\encore_KSJ\\util\\poem.txt";
	 try {
	 f.readFile(path); {
		 
	 }
	 }catch(FileNotFoundException e) {
	 
	 }
	 System.out.println("파일을 잘 읽어들였습니다....");
	
	}
}
---------------------------------------------------------------------

package exception.compile.test;

//. try~catch  2.throws  3 main...
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading3 {
	public void readFile(String filename) throws FileNotFoundException {

		FileReader fr = new FileReader(filename);
		System.out.println("..new FileReader()...filename...");

		System.out.println("FileReader Creating....");
	}
}

public class CompileExceptionTest3 {

	public static void main(String[] args) throws FileNotFoundException {

		FileReading3 f = new FileReading3();
		String path = "C:\\encore_KSJ\\util\\poem.txt";
		
			f.readFile(path);
		
		System.out.println("파일을 잘 읽어들였습니다....");

	}
}
----------------------------------------------------------------------------------

package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileExceptionTest4 {

	public static void main(String[] args) {

		String path = "C:\\encore_KSJ\\util\\poem.txt";
		FileReader fr = null;
		
		System.out.println("1. FileReader 객체를 생성...");
		
		try {
			fr = new FileReader(path);
			
			System.out.println("2. FileReader의 기능을 이용해서 파일의 내용을 읽어들입니다.");
		    fr.read();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();//이 코드가 상당히 중요하다.
			} catch (IOException e) {
				
			} 
		}
		
	}
}
-------------------------------------------------------------------------

package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileExceptionTest5 {

	public static void main(String[] args) throws FileNotFoundException, IOException{

		String path = "C:\\encore_KSJ\\util\\poem.txt";
		FileReader fr = null;
		
		System.out.println("1. FileReader 객체를 생성...");
		
		try {
			fr = new FileReader(path);
			
			System.out.println("2. FileReader의 기능을 이용해서 파일의 내용을 읽어들입니다.");
		    fr.read();
			
		}finally {//try이 없이 finally를 사용 못함
				fr.close();//이 코드가 상당히 중요하다.
		}
		
	}
}
-------------------------------------------------------------------------

package exception.compile.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 1.
 * 예외라는 것은 매우 다양한 상황에서 발생할 수 있다.
 * 이럴 때 모든 에외를 Exception 상위 클래스로 뭉뚱그려서 하나로 처리하는 것은 그다지 좋은 방법이 아니다.
 * ---> 어느정도 세분화 하는 것이 좋다.
 * ---> 공통적인 카테고리의 예외는 한가지로 묶어주는 것도 좋다.
 * 
 */

public class CompileExceptionTest6 {

	public static void main(String[] args) {
		try {
			Class.forName("exception.compile.test.CompileExceptionTest6");
			new FileInputStream("Hello");
			DriverManager.getConnection("aaa");
		} catch (ClassNotFoundException e) {
			System.out.printf("해당 클래스를 찾을 수가 없습니다...%s%n", e.getMessage());
		} catch (FileNotFoundException | SQLException e) {
			System.out.printf("해당하는 리소스가 없습니다...%s%n", e.getMessage());
		} // FQCN
		System.out.printf("프로그램 정상 종료");
	}
}





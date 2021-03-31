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

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
